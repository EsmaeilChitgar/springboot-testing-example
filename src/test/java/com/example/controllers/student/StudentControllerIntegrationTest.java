package com.example.controllers.student;

import com.example.dao.StudentRepository;
import com.example.model.Student;
import com.example.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerIntegrationTest {
    @Autowired
    private StudentService service;

    @MockBean
    private StudentRepository repository;

    @Test
    public void getStudentsTest() {
        when(repository.findAll()).thenReturn(Stream
                .of(new Student(10, "Ahmad", 40, "Iran"), new Student(20, "Daniel", 25, "UK")).collect(Collectors.toList()));
        assertEquals(2, service.getStudents().size());
    }

    @Test
    public void getStudentByAddressTest() {
        String address = "Shiraz";
        when(repository.findByAddress(address))
                .thenReturn(Stream.of(new Student(10, "Ahmad", 40, "Iran")).collect(Collectors.toList()));
        assertEquals(1, service.getStudentByAddress(address).size());
    }

    @Test
    public void saveStudentTest() {
        Student student = new Student(30, "Saeed", 33, "Iraq");
        when(repository.save(student)).thenReturn(student);
        assertEquals(student, service.addStudent(student));
    }

    @Test
    public void deleteStudentTest() {
        Student student = new Student(30, "Saeed", 33, "Iraq");
        service.deleteStudent(student);
        verify(repository, times(1)).delete(student);
    }
}

