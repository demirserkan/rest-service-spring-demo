package com.demirserkan.restservicespringdemo.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private @Id @GeneratedValue Long studentNo;
    private String fullName;
    private String gender;
    private int age;

}
