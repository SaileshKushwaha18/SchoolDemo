package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.example.demo.model.StudentFee;
import com.example.demo.model.StudentPaymentHistory;
import com.example.demo.repository.StudentFeePaymentRepository;
import com.example.demo.repository.StudentFeeRepository;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentFeeController {
	@Autowired
	private StudentFeeRepository studentFeeRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	StudentFeePaymentRepository studentFeePaymentRepository;
	
	@RequestMapping(value="/studentfees", method=RequestMethod.GET)
	public List<StudentFee> getStudentFees(){
		return (List<StudentFee>) studentFeeRepository.findAll();
	}
	
//	@RequestMapping(value="/studentfees/{id}", method=RequestMethod.GET)
//	public Optional<StudentFee>  getStudentFeesById(@PathVariable Long id){
//		System.out.println("=============StudentId==============="+id);
//		Optional<StudentFee> class1 = studentFeeRepository.findById(id);
//		if( class1 == null){
//			throw new RuntimeException("Student Fee do not exist");
//		}
//		return class1;
//	}
	
	@RequestMapping(value="/studentfees/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudentFee>  getStudentFeesByStudentId1(@PathVariable Long id){
		System.out.println("=============getStudentFeesByStudentId1==============="+id);
		
		// implemented to show the latest studentFee when generated.
		for(Student student : studentRepository.findAll()){
			if(student.getStudentId().equals(id)){
				List<StudentFee> srudentFees = studentFeeRepository.findByStudent(student);
				 System.out.println("=====srudentFees========="+srudentFees.toString());
				 for(StudentFee stdFee : srudentFees){
					 if(stdFee.isActive()){
						System.out.println("=====stdFee========="+stdFee.toString());
						 return new ResponseEntity<StudentFee>(studentFeeRepository.save(stdFee), HttpStatus.OK);
					 }
//					 else{
//						 return new ResponseEntity<StudentFee>(studentFeeRepository.save(stdFee), HttpStatus.OK);
//					 }
				 }
			}
		}
		 
		 return new ResponseEntity<StudentFee>(new StudentFee(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/studentfees/{id}/payment", method=RequestMethod.POST)
	public ResponseEntity<StudentFee>  updatePayment(@PathVariable Long id,@RequestBody StudentFee studentFee){
		 System.out.println("=============UpdatePayment==============="+id);
		 
		 List<StudentPaymentHistory> studentPaymentHistories = new ArrayList<>();
		 
		 Optional<StudentFee> studentFee1 = studentFeeRepository.findById(id);
		 studentFee1.get().setStudentPaidFeeAmt(studentFee.getStudentPaidFeeAmt());
		 if(studentFee.getStudentPaidFeeAmt() !=null && studentFee.getStudentFeeAmt() !=null){
			 studentFee1.get().setStudentBalanceFeeAmt(studentFee.getStudentFeeAmt() - studentFee.getStudentBalanceFeeAmt());
		 }
		 
		 studentFee1.get().setActive(studentFee.isActive());
		 studentFee1.get().setEndDate(new Date());
		 			
		 StudentPaymentHistory stuPayHist = new StudentPaymentHistory();
		 stuPayHist.setStudent(studentFee.getStudent());
		 stuPayHist.setStudentFee(studentFee);
		 stuPayHist.setStartDate(new Date());
		 stuPayHist.setPayamentStatus("SUCCESS");
		 stuPayHist.setStudentFeePaymentAmt(studentFee.getStudentPaidFeeAmt());
		 studentFeePaymentRepository.save(stuPayHist);
		 studentPaymentHistories.add(stuPayHist);
		 studentFee1.get().setStudentPaymentHistories(studentPaymentHistories);
		 
		 return new ResponseEntity<StudentFee>(studentFeeRepository.save(studentFee1.get()),HttpStatus.OK);
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
