package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ClassFeeParams;

@Repository
@RepositoryRestController
public interface ClassFeeParamsRepository extends CrudRepository<ClassFeeParams, Long> {
	ClassFeeParams findByName(String name);
}
