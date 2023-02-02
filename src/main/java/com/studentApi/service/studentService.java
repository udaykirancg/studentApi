package com.studentApi.service;

import java.util.List;
import java.util.Optional;

import com.studentApi.entity.Student;

public interface studentService {

	Student updateStudent(Student student);

	String deleteStudentByid(Long id);

	Student addStudent(Student student);

	Optional<Student> findByStudentId(Long id);

	List<Student> getAllStudents();



}


