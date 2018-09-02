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

import com.example.demo.model.PayStudentFee;
import com.example.demo.model.Student;
import com.example.demo.model.StudentFee;
import com.example.demo.model.StudentFeeParams;
import com.example.demo.model.StudentFeeWaiverHistory;
import com.example.demo.model.StudentFine;
import com.example.demo.model.StudentPaymentHistory;
import com.example.demo.model.StudentWaiver;
import com.example.demo.repository.StudentFeePaymentRepository;
import com.example.demo.repository.StudentFeeRepository;
import com.example.demo.repository.StudentFeeWaiverHistoryRepository;
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

	@Autowired
	StudentFeeWaiverHistoryRepository studentFeeWaiverHistoryRepository;
	
	@RequestMapping(value = "/studentfees", method = RequestMethod.GET)
	public List<StudentFee> getStudentFees() {
		return (List<StudentFee>) studentFeeRepository.findAll();
	}

	// @RequestMapping(value="/studentfees/{id}", method=RequestMethod.GET)
	// public Optional<StudentFee> getStudentFeesById(@PathVariable Long id){
	// System.out.println("=============StudentId==============="+id);
	// Optional<StudentFee> class1 = studentFeeRepository.findById(id);
	// if( class1 == null){
	// throw new RuntimeException("Student Fee do not exist");
	// }
	// return class1;
	// }

	@RequestMapping(value = "/studentfees/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentFee> getStudentFeesByStudentId1(@PathVariable Long id) {
		System.out.println("=============getStudentFeesByStudentId1===============" + id);

		List<StudentPaymentHistory> studentPaymentHistories = new ArrayList<>();
		List<StudentPaymentHistory> studentPaymentHistories1 = (List<StudentPaymentHistory>) studentFeePaymentRepository.findAll();
		
		
		
		for(StudentPaymentHistory studentPayHistory : studentPaymentHistories1){
			if(studentPayHistory.getStudent().getStudentId() == id){
				studentPaymentHistories.add(studentPayHistory);
			}
		}

		
		// implemented to show the latest studentFee when generated.
		for (Student student : studentRepository.findAll()) {
			if (student.getStudentId().equals(id)) {
//				if(studentFeeWaiverRepository.findByStudent(student) !=null) {
//					student.setStudentFeeWaivers(studentFeeWaiverRepository.findByStudent(student));
//				}
				
				List<StudentFee> srudentFees = studentFeeRepository.findByStudent(student);
				System.out.println("=====srudentFees=========" + srudentFees.toString());
				for (StudentFee stdFee : srudentFees) {
					if (stdFee.isActive()) {
						System.out.println("=====stdFee=========" + stdFee.toString());
						stdFee.setStudentPaymentHistories(studentPaymentHistories);
						return new ResponseEntity<StudentFee>(stdFee, HttpStatus.OK);
					}
					// else{
					// return new
					// ResponseEntity<StudentFee>(studentFeeRepository.save(stdFee),
					// HttpStatus.OK);
					// }
				}
			}
		}

		return new ResponseEntity<StudentFee>(new StudentFee(), HttpStatus.OK);
	}

	
	@RequestMapping(value = "/studentfees/{id}/payment", method = RequestMethod.POST)
	public ResponseEntity<StudentFee>  updatePayment(@RequestBody PayStudentFee payStudentFee){
		
		 if(payStudentFee !=null && payStudentFee.getStudentFee() !=null ){
			 Integer remainingBalance= Integer.valueOf(payStudentFee.getStudentFee().getStudentBalanceFeeAmt());
			 Integer PaidAmount = (null == payStudentFee.getStudentFee().getStudentPaidFeeAmt()) ? 0 : Integer.valueOf(payStudentFee.getStudentFee().getStudentPaidFeeAmt());
					
			
			 boolean feeActiveFlag = payStudentFee.getStudentFee().isActive();
			 
			 PaidAmount = PaidAmount + Integer.valueOf(payStudentFee.getPaymentAmount());
			 remainingBalance  = remainingBalance - Integer.valueOf(payStudentFee.getPaymentAmount());
			
			// List<StudentPaymentHistory> studentPaymentHistories = new ArrayList<>();
			 Optional<StudentFee> studentFee1 = studentFeeRepository.findById(payStudentFee.getStudentFee().getStudentFeeId());
	
			 if(PaidAmount == Integer.valueOf(payStudentFee.getStudentFee().getStudentFeeAmt())){
				 feeActiveFlag = false;
			}
	
			 
			studentFee1.get().setStudentPaidFeeAmt(PaidAmount);
			studentFee1.get().setStudentBalanceFeeAmt(remainingBalance);
			studentFee1.get().setActive(feeActiveFlag);
			studentFee1.get().setEndDate(new Date());
			studentFee1.get().getStudent().setNew(false);
			
			StudentPaymentHistory stuPayHist = new StudentPaymentHistory();
			 stuPayHist.setStudent(payStudentFee.getStudentFee().getStudent());
			 stuPayHist.setStudentFee(payStudentFee.getStudentFee());
			stuPayHist.setStartDate(new Date());
			stuPayHist.setPayamentStatus("SUCCESS");
			 stuPayHist.setStudentFeePaymentAmt(Integer.valueOf(payStudentFee.getPaymentAmount()));
			 stuPayHist.setStudentFeePaymentCmt(payStudentFee.getPaymentComments());
			studentFeePaymentRepository.save(stuPayHist);
			
			List<StudentPaymentHistory> oldStudentPaymentHistories =   payStudentFee.getStudentFee().getStudentPaymentHistories();
//			
//			if(oldStudentPaymentHistories == null){
//				oldStudentPaymentHistories =  studentFeePaymentRepository.findByStudentFee(payStudentFee.getStudentFee());
//			}
			oldStudentPaymentHistories.add(stuPayHist);
			studentFee1.get().setStudentPaymentHistories(oldStudentPaymentHistories);
			//studentPaymentHistories.add(stuPayHist);
			//studentFee1.get().setStudentPaymentHistories(studentPaymentHistories);
	//		
	//		for(StudentPaymentHistory studentPayHistory : studentPaymentHistories1){
	//			if(studentPayHistory.getStudent().getStudentId() == studentFee.getStudentFeeId()){
	//				studentPaymentHistories.add(studentPayHistory);
	//			}
	//		}
	//		
	//		studentFee1.get().setStudentPaymentHistories(studentPaymentHistories);
			
			return new ResponseEntity<StudentFee>(studentFeeRepository.save (studentFee1.get()), HttpStatus.OK);
		 }else{
			 return new ResponseEntity<StudentFee>(HttpStatus.OK);
		 }
	}
	
	@RequestMapping(value = "/studentfees/{id}/addfine", method = RequestMethod.POST)
	public ResponseEntity<StudentFee>  addStudentFine(@RequestBody StudentFine studentFine){
		
		 if(studentFine !=null && studentFine.getStudentFee() !=null ){
			 Integer remainingBalance= Integer.valueOf(studentFine.getStudentFee().getStudentBalanceFeeAmt());
			 Integer totalFeeAmount = 	Integer.valueOf(studentFine.getStudentFee().getStudentFeeAmt());	
			 List<StudentFeeParams> studentFeeParams = new ArrayList<>();
			
			 remainingBalance  = remainingBalance + Integer.valueOf(studentFine.getFineAmount());
			 totalFeeAmount = totalFeeAmount + Integer.valueOf(studentFine.getFineAmount());
			
			 Optional<StudentFee> studentFee1 = studentFeeRepository.findById(studentFine.getStudentFee().getStudentFeeId());
			 studentFeeParams.addAll(studentFee1.get().getStudentFeeParams());
	
			
			StudentFeeParams studentFeeParams2 = new StudentFeeParams();
			studentFeeParams2.setName(studentFine.getFineComments());
			studentFeeParams2.setValue(studentFine.getFineAmount() == null ? "" : studentFine.getFineAmount().toString());
			studentFeeParams2.setParamType("M");
			studentFeeParams2.setClassFee(studentFee1.get().getClassFee());
			studentFeeParams.add(studentFeeParams2);
			
			studentFee1.get().setStudentBalanceFeeAmt(remainingBalance);
			studentFee1.get().setStudentFeeAmt(totalFeeAmount);
			studentFee1.get().getStudent().setNew(false);
			studentFee1.get().setStudentFeeParams(studentFeeParams);
			
			
			return new ResponseEntity<StudentFee>(studentFeeRepository.save (studentFee1.get()), HttpStatus.OK);
		 }else{
			 return new ResponseEntity<StudentFee>(HttpStatus.OK);
		 }
	}

	@RequestMapping(value = "/studentfees/{id}/addwaiver", method = RequestMethod.POST)
	public ResponseEntity<StudentWaiver>  addStudentWaiver(@RequestBody StudentWaiver studentWaiver){
		
		System.out.println("Inside add Fee Waiver Service " + studentWaiver);
		
		 if(studentWaiver !=null && studentWaiver.getStudentFee() !=null ){
			 Integer remainingBalance= Integer.valueOf(studentWaiver.getStudentFee().getStudentBalanceFeeAmt());
			 Integer waiverAmount= (null == studentWaiver.getStudentFee().getStudentWaiverFeeAmt() ) ? 0 : Integer.valueOf(studentWaiver.getStudentFee().getStudentBalanceFeeAmt());
			 
			 
			 waiverAmount  = waiverAmount + Integer.valueOf(null == studentWaiver.getWaiverAmount() ? "0" : studentWaiver.getWaiverAmount());
			 remainingBalance  = remainingBalance - Integer.valueOf(waiverAmount);
			
			// List<StudentPaymentHistory> studentPaymentHistories = new ArrayList<>();
			 Optional<StudentFee> studentFee1 = studentFeeRepository.findById(studentWaiver.getStudentFee().getStudentFeeId());
			 studentFee1.get().setStudentBalanceFeeAmt(remainingBalance);
			 studentFee1.get().setStudentWaiverFeeAmt(waiverAmount);
			
			StudentFeeWaiverHistory stuWaiverHist = new StudentFeeWaiverHistory();
			stuWaiverHist.setStudentFee(studentWaiver.getStudentFee());
			stuWaiverHist.setWaiverDate(new Date());
			stuWaiverHist.setStudentFeeWaiverAmt(Integer.valueOf(studentWaiver.getWaiverAmount()));
			stuWaiverHist.setStudentFeeWaiverCmt(studentWaiver.getWaiverComments());
			studentFeeWaiverHistoryRepository.save(stuWaiverHist);
			
			studentFeeRepository.save (studentFee1.get());
			
			return new ResponseEntity<StudentWaiver>(studentWaiver, HttpStatus.OK);
		 }else{
			 return new ResponseEntity<StudentWaiver>(HttpStatus.OK);
		 }
	}
	
	@RequestMapping(value = "/studentfees/{id}/payment", method = RequestMethod.GET)
	public ResponseEntity<StudentFee> getPayments(@PathVariable Long id) {

		List<StudentPaymentHistory> studentPaymentHistories = new ArrayList<>();

		List<StudentPaymentHistory> studentPaymentHistories1 = (List<StudentPaymentHistory>) studentFeePaymentRepository.findAll();
	
		Optional<StudentFee> studentFee1 = studentFeeRepository.findById(id);
		
		for(StudentPaymentHistory studentPayHistory : studentPaymentHistories1){
			if(studentPayHistory.getStudent().getStudentId() == studentFee1.get().getStudent().getStudentId()){
				studentPaymentHistories.add(studentPayHistory);
			}
		}
		
		studentFee1.get().setStudentPaymentHistories(studentPaymentHistories);
		
		return new ResponseEntity<StudentFee>(studentFee1.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/studentfees/{id}/waiver", method = RequestMethod.GET)
	public ResponseEntity<StudentFee> getWaivers(@PathVariable Long id) {

		List<StudentFeeWaiverHistory> studentFeeWaiverHistories1 = new ArrayList<>();

		List<StudentFeeWaiverHistory> studentFeeWaiverHistories = (List<StudentFeeWaiverHistory>) studentFeeWaiverHistoryRepository.findAll();
	
		Optional<StudentFee> studentFee1 = studentFeeRepository.findById(id);
		
		for(StudentFeeWaiverHistory studentFeeWaiverHistory : studentFeeWaiverHistories){
			if(studentFeeWaiverHistory.getStudentFee().getStudentFeeId() == studentFee1.get().getStudent().getStudentId()){
				studentFeeWaiverHistories1.add(studentFeeWaiverHistory);
			}
		}
		
		studentFee1.get().setStudentFeeWaiverHistories(studentFeeWaiverHistories1);
		
		return new ResponseEntity<StudentFee>(studentFee1.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/studentfees", method = RequestMethod.POST)
	public ResponseEntity<StudentFee> addStudentFee(@RequestBody StudentFee studentFee) {
		// if(studentFee !=null &&
		// studentFeeRepository.findByName(studentFee.getName()) !=null) {
		// throw new RuntimeException("Student Fee already exist");
		// //return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
		// }

		return new ResponseEntity<StudentFee>(studentFeeRepository.save(studentFee), HttpStatus.OK);
	}

	@RequestMapping(value = "/studentfees", method = RequestMethod.PUT)
	public ResponseEntity<StudentFee> updateStudentFee(@RequestBody StudentFee studentFee) {
		return new ResponseEntity<StudentFee>(studentFeeRepository.save(studentFee), HttpStatus.OK);
	}

	@RequestMapping(value = "/studentfeesList", method = RequestMethod.POST)
	public ResponseEntity<StudentFee> addFees(@RequestBody List<StudentFee> studentFees) {
		studentFeeRepository.saveAll(studentFees);
		return new ResponseEntity<StudentFee>(HttpStatus.OK);
	}

	@RequestMapping(value = "/studentfees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StudentFee> deleteFees(@PathVariable Long id) {
		if (studentFeeRepository.findById(id) == null) {
			throw new RuntimeException("Student Fee do not exist");
		}
		studentFeeRepository.deleteById(id);
		return new ResponseEntity<StudentFee>(HttpStatus.OK);
	}
}