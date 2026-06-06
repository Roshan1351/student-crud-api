package com.crud.project.exception;

import com.crud.project.model.Student;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message){
        super(message);
    }
    public StudentNotFoundException(int id){
        super("student not found with Id: "+ id);
    }


}
