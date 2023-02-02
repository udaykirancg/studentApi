package com.studentApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentApi.Exception.NoRecordFoundExp;
import com.studentApi.entity.Student;
import com.studentApi.studentRepo.studentRepo;

@Service
public class studentServiceImpl implements studentService {
	
	@Autowired
	private studentRepo repo;

	@Override
	public Student addStudent(Student student) {
		Student check = repo.findByName(student.getName());
		if(check!=null)
		{
			throw new NoRecordFoundExp("Record Already exists!");
		}
		
		repo.save(student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		Optional<Student> a=repo.findById(student.getId());
		if(a.isPresent()) {
			return repo.save(student);
		}else
			throw new NoRecordFoundExp("No Data To Update");	 
	}

	@Override
	public String deleteStudentByid(Long id) {
		
		if(repo.findById(id).isEmpty()) {
			
			throw new NoRecordFoundExp("No data found to Delete");
		}else
			repo.deleteById(id);
		return "Data Deleted";
	}

	@Override
	public Optional<Student> findByStudentId(Long id) {
		if(repo.findById(id).isEmpty())
		{
			throw new NoRecordFoundExp("No Data Found");
		}
		
		return repo.findById(id);
	}

	@Override
	public List<Student> getAllStudents() {
		if(repo.findAll().size()==0) {
			throw new NoRecordFoundExp("No Students Found");
		}
		
		return repo.findAll();
	}

}
