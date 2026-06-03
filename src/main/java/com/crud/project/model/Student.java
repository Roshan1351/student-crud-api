package com.crud.project.model;


import com.sun.source.doctree.EscapeTree;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Student_Info")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "firstName is required")
    @Size(min = 3, message = "firstName must be at least 3 character")
    @Column(name="First_name")
    private String firstName;

    @NotBlank(message = "lastName is required")
    @Size(min=3, message = "lastName must be at least 3 character")
    @Column(name="Last_name")
    private String lastName;

    @Column(name ="Class")
    @Enumerated(EnumType.STRING)
    private classEnum className;



    public classEnum getClassName() {
        return className;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setClassName(classEnum className) {
        this.className = className;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "className='" + className + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
