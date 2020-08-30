package com.demirserkan.restservicespringdemo.controller;

import com.demirserkan.restservicespringdemo.repository.Student;
import com.demirserkan.restservicespringdemo.repository.StudentRepository;
import com.demirserkan.restservicespringdemo.exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    StudentController (StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @GetMapping("/students")
    public List<Student> all(){
        return studentRepository.findAll();
    }

    @PostMapping("/students")
    public Student newStudent (@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("/students/{studentNo}")
    public Student getStudent(@PathVariable Long studentNo){
        return studentRepository.findById(studentNo)
                .orElseThrow(() -> new StudentNotFoundException(studentNo));
    }

    @PutMapping("/students/{studentNo}")
    public Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long studentNo) {

        return studentRepository.findById(studentNo)
                .map(student -> {
                    student.setFullName(newStudent.getFullName());
                    student.setGender(newStudent.getGender());
                    student.setAge(newStudent.getAge());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setStudentNo(studentNo);
                    return studentRepository.save(newStudent);
                });
    }

    @DeleteMapping("/students/{studentNo}")
    public void deleteStudent(@PathVariable Long studentNo) {
        studentRepository.deleteById(studentNo);
    }
}
