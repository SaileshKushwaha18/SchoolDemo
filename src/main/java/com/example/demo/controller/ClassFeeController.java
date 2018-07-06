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

import com.example.demo.model.ClassFee;
import com.example.demo.repository.ClassFeeRepository;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ClassFeeController {
	@Autowired
	private ClassFeeRepository classFeeRepository;
	
	@RequestMapping(value="/classfee", method=RequestMethod.GET)
	public List<ClassFee> getClassFees(){
		return (List<ClassFee>) classFeeRepository.findAll();
	}
	
	@RequestMapping(value="/classfee/{id}", method=RequestMethod.GET)
	public Optional<ClassFee>  getClassFeesById(@PathVariable Long id){
		Optional<ClassFee> class1 = classFeeRepository.findById(id);
		if( class1 == null){
			throw new RuntimeException("Class Fee do not exist");
		}
		
		return class1;
	}
	
	@RequestMapping(value="/classfee", method=RequestMethod.POST)
	public ResponseEntity<ClassFee>  addClassFee(@RequestBody ClassFee classFee) {
		if(classFee !=null && classFeeRepository.findByName(classFee.getName()) !=null) {
			throw new RuntimeException("Class Fee already exist");
			//return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ClassFee>(classFeeRepository.save(classFee), HttpStatus.OK);
	}
	
	@RequestMapping(value="/classfee", method=RequestMethod.PUT)
	public ResponseEntity<ClassFee>  updateClassFee(@RequestBody ClassFee classFee) {	
	
		return new ResponseEntity<ClassFee>(classFeeRepository.save(classFee), HttpStatus.OK);
	}
	
	@RequestMapping(value="/classfeeList", method=RequestMethod.POST)
	public ResponseEntity<ClassFee> addFees(@RequestBody List<ClassFee> classFees) {
		classFeeRepository.saveAll(classFees);
		return new ResponseEntity<ClassFee>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/classfee/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ClassFee> deleteFees(@PathVariable Long id){
		if(classFeeRepository.findById(id) ==null) {
			throw new RuntimeException("Class Fee do not exist");
		}
		classFeeRepository.deleteById(id);
		return new ResponseEntity<ClassFee>(HttpStatus.OK);
	}
}
