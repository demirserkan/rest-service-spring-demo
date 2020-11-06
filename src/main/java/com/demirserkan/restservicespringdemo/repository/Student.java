package com.demirserkan.restservicespringdemo.repository;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Student extends RepresentationModel<Student> {

    private @Id @GeneratedValue Long studentNo;
    private String fullName;
    private String gender;
    private int age;

    public Student(){}

    public Student (String fullName, String gender, int age){
        this.fullName=fullName;
        this.gender=gender;
        this.age=age;
    }
}
