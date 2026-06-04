package com.crud.project.StudentController;

import com.crud.project.StudentRepo.StudentRepo;
import com.crud.project.model.Dashboard;
import com.crud.project.model.Student;
import com.crud.project.model.classEnum;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
        Student stud= repo.findById(id).get();
        return stud;
    }

    @PostMapping("/create")//only access of endpoint for admin
    public void createStudent(@Valid @RequestBody Student student){

        repo.save(student);
    }

    @DeleteMapping("/delete/{id}") //access only admin
    public void deleteStudent(@PathVariable int id){
        Student stud= repo.findById(id).get();
        repo.delete(stud);
    }

    @PutMapping("/update/{id}") //access only admin
    public Student studentupdate(@PathVariable int id,@Valid @RequestBody Student stud){
        Student existstudent= repo.findById(id).orElseThrow(()->new RuntimeException("student not found with this id"));
        existstudent.setFirstName(stud.getFirstName());
        existstudent.setLastName(stud.getLastName());
        existstudent.setClassName(stud.getClassName());

        return repo.save(existstudent);
    }

    @GetMapping("/search/{name}") //access by both admin/teacher
    public List<Student> searchStudent(@PathVariable String name){
        return repo.findByFirstNameContainingIgnoreCase(name);
    }

    @GetMapping("/count") // access by admin/teacher
    public int countStudent(){
        return repo.countStudentAll();
    }

    @GetMapping("/class/{className}")//access by only admin
    public List<Student> getStudentByClassName(@PathVariable classEnum className){
        return repo.findByClassName(className);
    }

}
