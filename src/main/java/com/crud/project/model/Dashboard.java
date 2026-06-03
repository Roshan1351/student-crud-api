package com.crud.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Dashboard {
    int totalStudent;
    int totalClasses;
    public Dashboard(){}

    public Dashboard(int totalStudent, int totalClasses){
        this.totalStudent= totalStudent;
        this.totalClasses=totalClasses;
    }

}
