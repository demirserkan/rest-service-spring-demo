package com.demirserkan.restservicespringdemo.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long studentNo){
        super("Could not find student "+studentNo);
    }
}
