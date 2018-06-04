package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentFee;

@Repository
@RepositoryRestController
public interface StudentFeeRepository extends CrudRepository<StudentFee, Long> {
	//StudentFee findByName(String name);
}
