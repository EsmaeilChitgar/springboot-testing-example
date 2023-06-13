package com.example.service;

import com.example.dao.StudentRepository;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public Student addStudent(Student student) {
		return repository.save(student);
	}

	public List<Student> getStudents() {
		List<Student> students = repository.findAll();
		System.out.println("Getting data from DB : " + students);
		return students;
	}

	public List<Student> getStudentByAddress(String address) {
		return repository.findByAddress(address);
	}

	public void deleteStudent(Student student) {
		repository.delete(student);
	}
}
