package com.example.controllers;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping(value = "/save")
	public Student saveStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}

	@GetMapping("/getStudents")
	public List<Student> findAllStudents() {
		return service.getStudents();
	}

	@GetMapping("/getStudentByAddress/{address}")
	public List<Student> findStudentByAddress(@PathVariable String address) {
		return service.getStudentByAddress(address);
	}

	@DeleteMapping(value="/remove")
	public Student removeStudent(@RequestBody Student student) {
		service.deleteStudent(student);
		return student;
	}
}
