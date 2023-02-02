package com.studentApi.studentRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentApi.entity.Student;

public interface studentRepo extends JpaRepository<Student, Long> {
	
	public Student findByName(String string);

}
