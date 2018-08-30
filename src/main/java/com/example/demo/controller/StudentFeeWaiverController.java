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

import com.example.demo.model.StudentFeeWaiver;
import com.example.demo.repository.StudentFeeWaiverRepository;

@RestController
@RequestMapping("/api")
public class StudentFeeWaiverController {

	@Autowired
	private StudentFeeWaiverRepository studentFeeWaiverRepository;
	
	@RequestMapping(value="/studentfeewaiver", method=RequestMethod.GET)
	public List<StudentFeeWaiver> getStudentFeeParams(){
		return (List<StudentFeeWaiver>) studentFeeWaiverRepository.findAll();
	}
	
	@RequestMapping(value="/studentfeewaiver/{id}", method=RequestMethod.GET)
	public Optional<StudentFeeWaiver>  getStudentFeeWaiverById(@PathVariable Long id){
		Optional<StudentFeeWaiver> class1 = studentFeeWaiverRepository.findById(id);
		if( class1 == null){
			throw new RuntimeException("Student Fee Waiver  do not exist");
		}
		
		return class1;
	}
	
	@RequestMapping(value="/studentfeewaiver", method=RequestMethod.POST)
	public ResponseEntity<StudentFeeWaiver>  addStudentFeeWaiver(@RequestBody StudentFeeWaiver studentFeeWaiver) {		
		System.out.println("============================Inside addStudentFeeWaiver============================");
		System.out.println(studentFeeWaiver.toString());
		return new ResponseEntity<StudentFeeWaiver>(studentFeeWaiverRepository.save(studentFeeWaiver), HttpStatus.OK);
	}
	
	@RequestMapping(value="/studentfeewaiver", method=RequestMethod.PUT)
	public ResponseEntity<StudentFeeWaiver>  updateStudentFeeWaiver(@RequestBody StudentFeeWaiver studentFeeWaiver) {
		return new ResponseEntity<StudentFeeWaiver>(studentFeeWaiverRepository.save(studentFeeWaiver), HttpStatus.OK);
	}
	

	
	@RequestMapping(value="/studentfeewaiver/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<StudentFeeWaiver> deleteStudentFeeWaiver(@PathVariable Long id){
		if(studentFeeWaiverRepository.findById(id) ==null) {
			throw new RuntimeException("Student Fee Waiver do not exist");
		}
		studentFeeWaiverRepository.deleteById(id);
		return new ResponseEntity<StudentFeeWaiver>(HttpStatus.OK);
	}
}
