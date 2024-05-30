package com.student.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.entities.Student;
import com.student.repo.StudentRepository;
import com.student.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
