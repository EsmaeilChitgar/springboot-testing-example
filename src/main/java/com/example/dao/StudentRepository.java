package com.example.dao;

import com.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByAddress(String address);
}
