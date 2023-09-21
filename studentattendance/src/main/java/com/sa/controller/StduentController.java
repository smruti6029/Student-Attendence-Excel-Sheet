package com.sa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sa.dto.StudentDto;
import com.sa.service.StudentService;

@RestController
@RequestMapping("/v1/student/")
public class StduentController {
	
	
	@Autowired
	private StudentService studentService;
	
	
	
	@PostMapping("/save")
	public ResponseEntity<?> saveStduent(@RequestBody List<StudentDto> studentDto)
	{
		Integer saveStudent = studentService.saveStudent(studentDto);
		if(saveStudent>0)
		{
			return ResponseEntity.ok("Success Insert Student");
		}
		
		
		return ResponseEntity.badRequest().body("try Agin");
	}
	
	

}
