package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StudentClass;
import com.example.demo.repository.StudentClassRepository;



@RestController
@RequestMapping("/api")
public class StudentClassController {
	@Autowired
	private StudentClassRepository studentClassRepository;
	
	@RequestMapping(value="/studentclass", method=RequestMethod.GET)
	public List<StudentClass> getStudentClass(){
		return (List<StudentClass>) studentClassRepository.findAll();
	}
	
	@RequestMapping(value="/studentclass/{id}", method=RequestMethod.GET)
	public Optional<StudentClass>  getStudentClassById(@PathVariable Long id){
		Optional<StudentClass> class1 = studentClassRepository.findById(id);
		if( class1 == null){
			throw new RuntimeException("Student Class do not exist");
		}
		return class1;
	}
	
	@RequestMapping(value="/studentclass", method=RequestMethod.POST)
	public ResponseEntity<StudentClass>  addStudentClass(@RequestBody StudentClass studentClass) {
		if(studentClass !=null && studentClassRepository.findByName(studentClass.getName()) !=null) {
			throw new RuntimeException("Student Class already exist");
			//return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<StudentClass>(studentClassRepository.save(studentClass), HttpStatus.OK);
	}
	
	@RequestMapping(value="/studentclass", method=RequestMethod.PUT)
	public ResponseEntity<StudentClass>  updateStudentClass(@RequestBody StudentClass studentClass) {		
		return new ResponseEntity<StudentClass>(studentClassRepository.save(studentClass), HttpStatus.OK);
	}
	
	@RequestMapping(value="/studentclassList", method=RequestMethod.POST)
	public ResponseEntity<StudentClass> addFees(@RequestBody List<StudentClass> studentclass) {
		studentClassRepository.saveAll(studentclass);
		return new ResponseEntity<StudentClass>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/studentclass/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<StudentClass> deleteFees(@PathVariable Long id){
		if(studentClassRepository.findById(id) ==null) {
			throw new RuntimeException("Student Class do not exist");
		}
		studentClassRepository.deleteById(id);
		return new ResponseEntity<StudentClass>(HttpStatus.OK);
	}
}
