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

import com.example.demo.model.StudentFeeParams;
import com.example.demo.repository.StudentFeeParamsRepository;

@RestController
@RequestMapping("/api")
public class StudentFeeParamsController {

	@Autowired
	private StudentFeeParamsRepository studentFeeParamsRepository;
	
	@RequestMapping(value="/studentfeeparams", method=RequestMethod.GET)
	public List<StudentFeeParams> getStudentFeeParams(){
		return (List<StudentFeeParams>) studentFeeParamsRepository.findAll();
	}
	
	@RequestMapping(value="/studentfeeparams/{id}", method=RequestMethod.GET)
	public Optional<StudentFeeParams>  getStudentFeeParamsById(@PathVariable Long id){
		Optional<StudentFeeParams> class1 = studentFeeParamsRepository.findById(id);
		if( class1 == null){
			throw new RuntimeException("Student Fee Params  do not exist");
		}
		
		return class1;
	}
	
	@RequestMapping(value="/studentfeeparams", method=RequestMethod.POST)
	public ResponseEntity<StudentFeeParams>  addStudentFeeParams(@RequestBody StudentFeeParams studentFeeParams) {
		if(studentFeeParams !=null && studentFeeParamsRepository.findByName(studentFeeParams.getName()) !=null) {
			throw new RuntimeException("Student Fee Params  already exist");
			//return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<StudentFeeParams>(studentFeeParamsRepository.save(studentFeeParams), HttpStatus.OK);
	}
	
	@RequestMapping(value="/studentfeeparams", method=RequestMethod.PUT)
	public ResponseEntity<StudentFeeParams>  updateStudentFeeParams(@RequestBody StudentFeeParams studentFeeParams) {	
	
		return new ResponseEntity<StudentFeeParams>(studentFeeParamsRepository.save(studentFeeParams), HttpStatus.OK);
	}
	
	@RequestMapping(value="/studentfeeparamsList", method=RequestMethod.POST)
	public ResponseEntity<StudentFeeParams> addStudentFeeParams(@RequestBody List<StudentFeeParams> studentFeeParams) {
		studentFeeParamsRepository.saveAll(studentFeeParams);
		return new ResponseEntity<StudentFeeParams>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/studentfeeparams/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<StudentFeeParams> deleteStudentFeeParams(@PathVariable Long id){
		if(studentFeeParamsRepository.findById(id) ==null) {
			throw new RuntimeException("Student Fee Params do not exist");
		}
		studentFeeParamsRepository.deleteById(id);
		return new ResponseEntity<StudentFeeParams>(HttpStatus.OK);
	}
}
