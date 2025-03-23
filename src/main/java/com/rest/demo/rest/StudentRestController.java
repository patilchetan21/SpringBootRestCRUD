package com.rest.demo.rest;


import com.rest.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>(); // Initialize the list

        theStudents.add(new Student(1,"Chetan","Patil"));
        theStudents.add(new Student(2,"stud1","lastnameStud1"));
        theStudents.add(new Student(3,"stud2","lastnameStud2"));
        theStudents.add(new Student(4,"stud3","lastnameStud3"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return theStudents.get(studentId);
    }
}