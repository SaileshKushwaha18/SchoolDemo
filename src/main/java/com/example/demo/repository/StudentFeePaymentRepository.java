package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;
import com.example.demo.model.StudentFee;
import com.example.demo.model.StudentPaymentHistory;

@Repository
@RepositoryRestController
public interface StudentFeePaymentRepository extends CrudRepository<StudentPaymentHistory, Long> {
	
	StudentPaymentHistory findByStudent(Student student);
	
	List<StudentPaymentHistory> findByStudentFee(StudentFee studentFee);
}
