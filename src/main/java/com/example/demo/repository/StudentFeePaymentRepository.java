package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentPaymentHistory;

@Repository
@RepositoryRestController
public interface StudentFeePaymentRepository extends CrudRepository<StudentPaymentHistory, Long> {
	
}
