package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentFeeParams;

@Repository
@RepositoryRestController
public interface StudentFeeParamsRepository extends CrudRepository<StudentFeeParams, Long> {
	StudentFeeParams findByName(String name);
}
