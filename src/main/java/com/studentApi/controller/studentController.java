package com.studentApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.entity.Student;
import com.studentApi.service.studentService;
import com.studentApi.studentRepo.studentRepo;


@RestController
public class studentController {
	
	@Autowired
	private studentService stu;
	
	@PostMapping("/addStudents")
	public ResponseEntity<?> addStudnet(@RequestBody Student student){
		return new ResponseEntity<>(stu.addStudent(student),HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<?> updateStudent(@RequestBody Student student) {
		return new ResponseEntity<>(stu.updateStudent(student),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/getAllStudent")
	public ResponseEntity<?> getAllStudents(){
		return new ResponseEntity<>(stu.getAllStudents(),HttpStatus.FOUND);
	}
	
	
	@GetMapping("/getStudentById/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		
		return new ResponseEntity<>(stu.findByStudentId(id),HttpStatus.OK);		
	}
	
	@DeleteMapping("/deleteStudnetById/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {
		
		return new ResponseEntity<>(stu.deleteStudentByid(id),HttpStatus.ACCEPTED);
	}
	

}
