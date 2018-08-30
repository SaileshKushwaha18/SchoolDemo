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

import com.example.demo.model.ClassFee;
import com.example.demo.model.ClassFeeParams;
import com.example.demo.model.GenerateFee;
import com.example.demo.model.Student;
import com.example.demo.model.StudentClass;
import com.example.demo.model.StudentFee;
import com.example.demo.model.StudentFeeParams;
import com.example.demo.model.StudentFeeWaiver;
import com.example.demo.repository.ClassFeeParamsRepository;
import com.example.demo.repository.ClassFeeRepository;
import com.example.demo.repository.StudentFeeParamsRepository;
import com.example.demo.repository.StudentFeeRepository;
import com.example.demo.repository.StudentFeeWaiverRepository;

@RestController
@RequestMapping("/api")
public class ClassFeeController {
	@Autowired
	private ClassFeeRepository classFeeRepository;
	
	@Autowired
	private StudentFeeRepository studentFeeRepository;
	
	@Autowired
	private StudentFeeParamsRepository studentFeeParamsRepository;
	
	@Autowired
	private StudentFeeWaiverRepository studentFeeWaiverRepository;
	
	@Autowired
	private ClassFeeParamsRepository classFeeParamsRepository;
	
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
		System.out.println("===========AddClassFee============="+classFee);
		if(classFee !=null && classFeeRepository.findByName(classFee.getName()) !=null) {
			throw new RuntimeException("Class Fee already exist");
			//return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
		}
		System.out.println("===========UpdateclassFee classFee.getClassFeeParams()============="+classFee);
		classFeeParamsRepository.saveAll(classFee.getClassFeeParams());
		
		//System.out.println("===========classFee============="+classFee);
		return new ResponseEntity<ClassFee>(classFeeRepository.save(classFee), HttpStatus.OK);
	}
	
	@RequestMapping(value="/classfee", method=RequestMethod.PUT)
	public ResponseEntity<ClassFee>  updateClassFee(@RequestBody ClassFee classFee) {	
		System.out.println("===========UpdateclassFee classFee.getClassFeeParams()============="+classFee);
		classFeeParamsRepository.saveAll(classFee.getClassFeeParams());
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
	
	@RequestMapping(value="/generatestudentfee" , method=RequestMethod.POST)
	public ResponseEntity<GenerateFee>  generateStudentFee(@RequestBody GenerateFee generateFee) {

		List<StudentFee> studentFees = new ArrayList<>();
		
		List<StudentFeeParams> studentFeeParamsClass = new ArrayList<>();
		
		// Copying ClassFee Params to StudentFee Params.
		ClassFee classFee = generateFee.getClassFee();
		for(ClassFeeParams classFeeParam : classFee.getClassFeeParams()){
			StudentFeeParams studentFeeParams1 = new StudentFeeParams();
			studentFeeParams1.setName(classFeeParam.getClassFeeType().getName());
			studentFeeParams1.setValue(classFeeParam.getFeeAmount());
			studentFeeParams1.setParamType(classFeeParam.getClassFeeType().getFrequency());
			studentFeeParams1.setClassFee(classFee);
			
			//System.out.println("============studentFeeParams1=================" + studentFeeParams1.toString());
			studentFeeParamsClass.add(studentFeeParams1);
			
		}
		
		//System.out.println("========studentFeeParamsClass========="+studentFeeParamsClass.toString());
		
		//adding the copied studentFeeParams to StudentFee
		// calculating StudentFeeAmt based on the studentFeeParams total value.
		List<StudentClass> studentClasses= generateFee.getStudentClass();
		
		for(StudentClass studentClass : studentClasses){
			List<Student> students = studentClass.getStudents();
			
			//System.out.println("=======students ============"+students.toString());
			for(Student student : students){
				List<StudentFeeParams> studentFeeParams = new ArrayList<>();
				//System.out.println("=======Student ID ============"+student.getStudentId());
				StudentFee studentFee = new StudentFee();
				studentFee.setClassFee(classFee);
				studentFee.setStudent(student);
				studentFee.setStartDate(new Date());
				studentFee.setEndDate(null);
				
				//System.out.println("========Student.isnew========="+student.isNew());
				
				if(!student.isNew()){
					for(StudentFeeParams studFeeParams : studentFeeParamsClass){
						if(studFeeParams.getParamType().equalsIgnoreCase("M")){
							studentFeeParams.add(studFeeParams);
						}						
					}
					//System.out.println("============>>>>>>>>>>>>>>>>>>>>>>> NOT IS NEW ================= "+ student.isNew());
				}else{
					//System.out.println("============>>>>>>>>>>>>>>>>>>>>>>> IS NEW ================= "+ student.isNew());
					studentFeeParams.addAll(studentFeeParamsClass);
				}

				//System.out.println("========studentFeeParamsTest1========="+studentFeeParams.toString());
				
				//adding student previous Fees / dues to student params.
				List<StudentFee> studentsFees = (List<StudentFee>) studentFeeRepository.findAll();
				for(StudentFee stdFee : studentsFees){
					if(stdFee.getStudent().getStudentId().equals(student.getStudentId())){
						if(stdFee.isActive()){
							StudentFeeParams studentFeeParams2 = new StudentFeeParams();
							studentFeeParams2.setName("Dues");
							studentFeeParams2.setValue(stdFee.getStudentBalanceFeeAmt() == null ? "" : stdFee.getStudentBalanceFeeAmt().toString());
							studentFeeParams2.setParamType("M");
							studentFeeParams2.setClassFee(classFee);
							studentFeeParams.add(studentFeeParams2);
							stdFee.setActive(false);
							studentFeeRepository.save(stdFee); // inactive the old fee as we used in new fee as Due
						}
					}
				}
				
//
//				List<StudentFeeWaiver> studentFeeWaivers = (List<StudentFeeWaiver>) studentFeeWaiverRepository.findAll();
//				//getting student Fee Waivers.
//				for(StudentFeeWaiver studentFeeWaiver : studentFeeWaivers){
//					if(studentFeeWaiver !=null && studentFeeWaiver.isActive() && studentFeeWaiver.getStudent().getStudentId() == student.getStudentId()){
//						System.out.println("===studentFeeWaiver====="+studentFeeWaiver.toString());
//						// TODO feewaivers will be added subtracted when we work on Waiver part.0
//						
//						StudentFeeParams studentFeeParams3 = new StudentFeeParams();
//						studentFeeParams3.setName(studentFeeWaiver.getFeeWaiverType());
//						studentFeeParams3.setValue(studentFeeWaiver.getFeeWaiverAmt() == null ? "" : studentFeeWaiver.getFeeWaiverAmt().toString());
//						studentFeeParams3.setParamType("M");
//						studentFeeParams3.setClassFee(classFee);
//						studentFeeParams.add(studentFeeParams3);
//						//stdFee.setActive(false);
//						//studentFeeRepository.save(stdFee);
//					}else{
//						System.out.println("===studentFeeWaiver null=============== ");
//						// TODO feewaivers will be added subtracted when we work on Waiver part.
//					}
//					
//				}
				
				//System.out.println("========studentFeeParamsTest2========="+studentFeeParams.toString());
				studentFee.setStudentFeeParams(studentFeeParams);
				studentFee.setStudentClass(studentClass);
				
				Integer studentTotalAmt =0 ;
				//setting StudentFeeAmount.
				for(StudentFeeParams studentFeeParam : studentFeeParams){
					if(!studentFeeParam.getValue().isEmpty()){
						studentTotalAmt = studentTotalAmt + Integer.parseInt(studentFeeParam.getValue());
					}
				}
				
				studentFee.setStudentFeeAmt(studentTotalAmt);
				studentFee.setStudentBalanceFeeAmt(studentTotalAmt);
				
				studentFees.add(studentFee);
			}
			//System.out.println("===========generateStudentFee============="+studentClasses.toString());
			
			//studentFeeParamsRepository.saveAll(studentFeeParams);
			studentFeeRepository.saveAll(studentFees);
		}


		return new ResponseEntity<GenerateFee>(generateFee, HttpStatus.OK);
	}
}