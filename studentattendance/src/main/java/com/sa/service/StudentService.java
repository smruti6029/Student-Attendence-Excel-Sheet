package com.sa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.dao.StudentDao;
import com.sa.dto.StudentDto;
import com.sa.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public Integer saveStudent(List<StudentDto> students)
	{
		
		List<Student> studentslist=new ArrayList<>();
		for(StudentDto dto:students)
		{
			StudentDto obj=new StudentDto();
			Student stduent = obj.convertEntity(dto);
			Random random=new Random();
			
			
			 StringBuilder randomDigits = new StringBuilder();
		        for (int i = 0; i < 6; i++) {
		            int digit = random.nextInt(10); // Generate a random digit from 0 to 9
		            randomDigits.append(digit);
		        }

		        // Convert the StringBuilder to a String
		        String randomNumber = randomDigits.toString();
		        
		        stduent.setRollnumber(randomNumber);
		        studentslist.add(stduent);
		}
		
		Integer saveStudent = studentDao.saveStudent(studentslist);
		
		return saveStudent;
	}

}
