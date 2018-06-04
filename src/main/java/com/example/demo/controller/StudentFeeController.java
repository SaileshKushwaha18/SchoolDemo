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

import com.example.demo.model.StudentFee;
import com.example.demo.repository.StudentFeeRepository;

@RestController
@RequestMapping("/api")
public class StudentFeeController {
	@Autowired
	private StudentFeeRepository studentFeeRepository;
	
	@RequestMapping(value="/studentfees", method=RequestMethod.GET)
	public List<StudentFee> getStudentFees(){
		return (List<StudentFee>) studentFeeRepository.findAll();
	}
	
	@RequestMapping(value="/studentfees/{id}", method=RequestMethod.GET)
	public Optional<StudentFee>  getStudentFeesById(@PathVariable Long id){
		Optional<StudentFee> class1 = studentFeeRepository.findById(id);
		if( class1 == null){
			throw new RuntimeException("Student Fee do not exist");
		}
		return class1;
	}
	
	@RequestMapping(value="/studentfees", method=RequestMethod.POST)
	public ResponseEntity<StudentFee>  addStudentFee(@RequestBody StudentFee studentFee) {
//		if(studentFee !=null && studentFeeRepository.findByName(studentFee.getName()) !=null) {
//			throw new RuntimeException("Student Fee already exist");
//			//return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
//		}
		
		return new ResponseEntity<StudentFee>(studentFeeRepository.save(studentFee), HttpStatus.OK);
	}
	
	@RequestMapping(value="/studentfees", method=RequestMethod.PUT)
	public ResponseEntity<StudentFee>  updateStudentFee(@RequestBody StudentFee studentFee) {		
		return new ResponseEntity<StudentFee>(studentFeeRepository.save(studentFee), HttpStatus.OK);
	}
	
	@RequestMapping(value="/studentfeesList", method=RequestMethod.POST)
	public ResponseEntity<StudentFee> addFees(@RequestBody List<StudentFee> studentFees) {
		studentFeeRepository.saveAll(studentFees);
		return new ResponseEntity<StudentFee>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/studentfees/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<StudentFee> deleteFees(@PathVariable Long id){
		if(studentFeeRepository.findById(id) ==null) {
			throw new RuntimeException("Student Fee do not exist");
		}
		studentFeeRepository.deleteById(id);
		return new ResponseEntity<StudentFee>(HttpStatus.OK);
	}
}
