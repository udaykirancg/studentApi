package com.studentApi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.studentApi.entity.Student;

@SpringBootTest
class StudentApiApplicationTests {

	@Test
	void testGetStudent() {
		RestTemplate restTemplate= new RestTemplate();
		Student student = restTemplate.getForObject("http://localhost:8080/getStudentById/1",Student.class);
		assertNotNull(student);
		assertEquals("Behzad ali", student.getName());
	}
	
	@Test
	void addStudent() {
		RestTemplate restRemplate =new RestTemplate();
		Student student = new Student();
		student.setName("Pratyushaa");
		student.setTestScore(93);
		Student newStudent = restRemplate.postForObject("http://localhost:8080/addStudents", student, Student.class);
		assertNotNull(newStudent);
		assertNotNull(newStudent.getId());
		assertEquals("Pratyushaa", newStudent.getName());
	}
	
	@Test
	void testUpdateStudent() {
		RestTemplate restTemplate= new RestTemplate();
		Student student = restTemplate.getForObject("http://localhost:8080/getStudentById/1",Student.class);
		student.setName("Behzad ali");
		
		restTemplate.put("http://localhost:8080/updateStudent", student);
	}

}
