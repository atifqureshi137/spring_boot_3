package com.sa.paniwala.restdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.paniwala.restdemo.entity.Student;
import com.sa.paniwala.restdemo.exception.StudentErrorResponse;
import com.sa.paniwala.restdemo.exception.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<Student>();
		theStudents.add(new Student(1, "Atif", "Qureshi", "atif@1sa.com"));
		theStudents.add(new Student(2, "Waqas", "Qureshi", "waqas@1sa.com"));
		theStudents.add(new Student(3, "Najam", "Qureshi", "najam@1sa.com"));
	}
	// define end point for Students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		// check the student id against list size
		if (studentId >= theStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("Student not found :" + studentId);
		}
		return theStudents.get(studentId);
	}
}
