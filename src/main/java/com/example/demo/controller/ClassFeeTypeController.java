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

import com.example.demo.model.ClassFeeType;
import com.example.demo.repository.ClassFeeTypeRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ClassFeeTypeController {
	@Autowired
	private ClassFeeTypeRepository classFeeTypeRepository;
	
	@RequestMapping(value="/feetype", method=RequestMethod.GET)
	public List<ClassFeeType> getStudentFees(){
		return (List<ClassFeeType>) classFeeTypeRepository.findAll();
	}
	
	@RequestMapping(value="/feetype/{id}", method=RequestMethod.GET)
	public Optional<ClassFeeType>  getClassFeeTypeById(@PathVariable Long id){
		Optional<ClassFeeType> class1 = classFeeTypeRepository.findById(id);
		if( class1 == null){
			throw new RuntimeException("Fee Type do not exist");
		}
		return class1;
	}
	
	@RequestMapping(value="/feetype", method=RequestMethod.POST)
	public ResponseEntity<ClassFeeType>  addClassFeeType(@RequestBody ClassFeeType classFeeType) {
		if(classFeeType !=null && classFeeTypeRepository.findByName(classFeeType.getName()) !=null) {
			throw new RuntimeException("Fee Type already exist");
			//return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ClassFeeType>(classFeeTypeRepository.save(classFeeType), HttpStatus.OK);
	}
	
	@RequestMapping(value="/feetype", method=RequestMethod.PUT)
	public ResponseEntity<ClassFeeType>  updateClassFeeType(@RequestBody ClassFeeType classFeeType) {		
		return new ResponseEntity<ClassFeeType>(classFeeTypeRepository.save(classFeeType), HttpStatus.OK);
	}
	
	@RequestMapping(value="/feetypeList", method=RequestMethod.POST)
	public ResponseEntity<ClassFeeType> addFeeType(@RequestBody List<ClassFeeType> classFeeTypes) {
		classFeeTypeRepository.saveAll(classFeeTypes);
		return new ResponseEntity<ClassFeeType>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/feetype/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ClassFeeType> deleteFeeType(@PathVariable Long id){
		if(classFeeTypeRepository.findById(id) ==null) {
			throw new RuntimeException("Fee Type do not exist");
		}
		classFeeTypeRepository.deleteById(id);
		return new ResponseEntity<ClassFeeType>(HttpStatus.OK);
	}
}
