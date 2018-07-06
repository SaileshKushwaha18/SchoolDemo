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

import com.example.demo.model.ClassFeeParams;
import com.example.demo.repository.ClassFeeParamsRepository;

@RestController
@RequestMapping("/api")
public class ClassFeeParamsController {

	@Autowired
	private ClassFeeParamsRepository classFeeParamsRepository;
	
	@RequestMapping(value="/classfeeparams", method=RequestMethod.GET)
	public List<ClassFeeParams> getClassFeeParams(){
		return (List<ClassFeeParams>) classFeeParamsRepository.findAll();
	}
	
	@RequestMapping(value="/classfeeparams/{id}", method=RequestMethod.GET)
	public Optional<ClassFeeParams>  getClassFeeParamsById(@PathVariable Long id){
		Optional<ClassFeeParams> class1 = classFeeParamsRepository.findById(id);
		if( class1 == null){
			throw new RuntimeException("Class Fee Params  do not exist");
		}
		
		return class1;
	}
	
	@RequestMapping(value="/classfeeparams", method=RequestMethod.POST)
	public ResponseEntity<ClassFeeParams>  addClassFeeParams(@RequestBody ClassFeeParams classFeeParams) {
		/*if(classFeeParams !=null && classFeeParamsRepository.findByName(classFeeParams.getName()) !=null) {
			throw new RuntimeException("Class Fee Params  already exist");
			//return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
		}*/
		
		return new ResponseEntity<ClassFeeParams>(classFeeParamsRepository.save(classFeeParams), HttpStatus.OK);
	}
	
	@RequestMapping(value="/classfeeparams", method=RequestMethod.PUT)
	public ResponseEntity<ClassFeeParams>  updateClassFeeParams(@RequestBody ClassFeeParams classFeeParams) {	
	
		return new ResponseEntity<ClassFeeParams>(classFeeParamsRepository.save(classFeeParams), HttpStatus.OK);
	}
	
	@RequestMapping(value="/classfeeparamsList", method=RequestMethod.POST)
	public ResponseEntity<ClassFeeParams> addClassFeeParams(@RequestBody List<ClassFeeParams> classFeeParams) {
		classFeeParamsRepository.saveAll(classFeeParams);
		return new ResponseEntity<ClassFeeParams>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/classfeeparams/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ClassFeeParams> deleteClassFeeParams(@PathVariable Long id){
		if(classFeeParamsRepository.findById(id) ==null) {
			throw new RuntimeException("Class Fee Params do not exist");
		}
		classFeeParamsRepository.deleteById(id);
		return new ResponseEntity<ClassFeeParams>(HttpStatus.OK);
	}
}
