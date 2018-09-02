package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentFeeWaiverHistory;

@Repository
@RepositoryRestController
public interface StudentFeeWaiverHistoryRepository extends CrudRepository<StudentFeeWaiverHistory, Long> {
	
}
