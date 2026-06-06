package com.crud.project.StudentController;

import com.crud.project.StudentRepo.StudentRepo;
import com.crud.project.exception.StudentNotFoundException;
import com.crud.project.model.Dashboard;
import com.crud.project.model.Student;
import com.crud.project.model.classEnum;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentRepo repo;

    @GetMapping // fetching student can access both admin/teacher
    public List<Student> getAllStudents(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5") int size){
        List<Student> list= repo.findAll(PageRequest.of(page, size)).getContent();
        return list;
    }

    @GetMapping("/{id}") // fetching student by id can access both admin/teacher
    public Student getStudentById(@PathVariable int id){
        return repo.findById(id).orElseThrow(()->new StudentNotFoundException(id));
    }

    @PostMapping("/create")//only access of endpoint for admin
    public void createStudent(@Valid @RequestBody Student student){

        repo.save(student);
    }

    @DeleteMapping("/delete/{id}") //access only admin
    public String deleteStudent(@PathVariable int id){
        Student stud= repo.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
        repo.delete(stud);
        return "student delete successfully";
    }

    @PutMapping("/update/{id}") //access only admin
    public Student studentupdate(@PathVariable int id,@Valid @RequestBody Student stud){
        Student existstudent= repo.findById(id).orElseThrow(()->new RuntimeException("student not found with id: "+id));
        existstudent.setFirstName(stud.getFirstName());
        existstudent.setLastName(stud.getLastName());
        existstudent.setClassName(stud.getClassName());

        return repo.save(existstudent);
    }

    @GetMapping("/search/{name}") //access by both admin/teacher
    public ResponseEntity<?> searchStudent(@PathVariable String name){

        List<Student> stud=  repo.findByFirstNameContainingIgnoreCase(name);

        if(stud.isEmpty()){
            return ResponseEntity.ok("No student found with name: "+ name);
        }
        return ResponseEntity.ok(stud);
    }

    @GetMapping("/count") // access by admin/teacher
    public int countStudent(){
        return repo.countStudentAll();
    }

    @GetMapping("/class/{className}")//access by only admin
    public ResponseEntity<?> getStudentByClassName(@PathVariable classEnum className){
        List<Student> student=  repo.findByClassName(className);
        if(student.isEmpty()){
            return ResponseEntity.ok("No student is found with class: "+ className);
        }
        return ResponseEntity.ok(student);
    }

}
