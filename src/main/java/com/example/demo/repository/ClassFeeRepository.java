package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ClassFee;

@Repository
@RepositoryRestController
public interface ClassFeeRepository extends CrudRepository<ClassFee, Long> {
	ClassFee findByName(String name);
}
