package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentClassRepository;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentClassRepository studentClassRepository;
	
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public List<Student> getStudents(){
		return (List<Student>) studentRepository.findAll();
	}
	
	@RequestMapping(value="/students/{id}", method=RequestMethod.GET)
	public Optional<Student>  getStudentsById(@PathVariable Long id){
		Optional<Student> student = studentRepository.findById(id);
		if( student == null){
			throw new RuntimeException("Student do not exist");
		}
		return student;
	}
	
	@RequestMapping(value="/students", method=RequestMethod.POST)
	public ResponseEntity<Student>  addStudent(@RequestBody Student student) {
		if(student !=null && studentRepository.findByAdmissionno(student.getAdmissionno()) !=null) {
			throw new RuntimeException("Student already exist");
			//return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Student>(studentRepository.save(student), HttpStatus.OK);
	}
	
	@RequestMapping(value="/students", method=RequestMethod.PUT)
	public ResponseEntity<Student>  updateStudent(@RequestBody Student student) {		
		return new ResponseEntity<Student>(studentRepository.save(student), HttpStatus.OK);
	}
	
	@RequestMapping(value="/studentsList", method=RequestMethod.POST)
	public ResponseEntity<Student> addStudents(@RequestBody List<Student> students) {
		studentRepository.saveAll(students);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/students/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
		if(studentRepository.findById(id) ==null) {
			throw new RuntimeException("Student do not exist");
		}
		studentRepository.deleteById(id);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
}
