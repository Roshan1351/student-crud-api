package com.crud.project.StudentController;

import com.crud.project.StudentRepo.StudentRepo;
import com.crud.project.model.Dashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController{
    @Autowired
    StudentRepo repo;
    @GetMapping //access by only admin
    public Dashboard getDashboard(){
        int totalStudent= repo.countStudentAll();
        int totalClasses= repo.CountDistinctClass();
        return new Dashboard(totalStudent, totalClasses);
    }
}
