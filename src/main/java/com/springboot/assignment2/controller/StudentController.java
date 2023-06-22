package com.springboot.assignment2.controller;

import com.springboot.assignment2.entities.Student;
import com.springboot.assignment2.service.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

  @Autowired
  private final StudentServiceImplementation serviceImplementation;

  public StudentController(StudentServiceImplementation serviceImplementation) {
    this.serviceImplementation = serviceImplementation;
  }

  @GetMapping
  public ResponseEntity<List<Student>> getAllStudents() {
    List<Student> students = this.serviceImplementation.getAllStudent();
    return ResponseEntity.ok(students);
  }


  @PostMapping
  public ResponseEntity<Student> createStudent(@RequestBody Student student) {
    Student createdStudent = serviceImplementation.createStudent(student);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
    Student student = serviceImplementation.getStudentById(id);
    return ResponseEntity.ok(student);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
    student.setId(id);
    Student updatedStudent = serviceImplementation.updateStudent(student);
    return ResponseEntity.ok(updatedStudent);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
    serviceImplementation.deleteStudent(id);
    return ResponseEntity.noContent().build();
  }
}
