package com.springboot.assignment2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @NotBlank(message = "Name is required")
  @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
  private String name;

  @Email(message = "Email should be valid")
  private String email;

  public Student(Integer id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public Student(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Student() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Student{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + '}';
  }
}
