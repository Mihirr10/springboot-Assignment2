package com.springboot.assignment2.service;


import com.springboot.assignment2.entities.Student;
import com.springboot.assignment2.repositories.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImplementation implements StudentService {


  private final StudentRepository studentRepository;


  public StudentServiceImplementation(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Student createStudent(Student student) {
    return studentRepository.save(student);
  }


  public List<Student> getAllStudent() {
    return studentRepository.findAll();
  }

  public Student getStudentById(Integer id) {
    return studentRepository.findById(id).get();

  }

  public Student updateStudent(Student student) {

    return studentRepository.save(student);
  }

  public void deleteStudent(Integer id) {
    studentRepository.deleteById(id);
  }
}
