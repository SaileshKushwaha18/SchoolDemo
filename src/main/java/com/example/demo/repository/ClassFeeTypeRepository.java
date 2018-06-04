package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ClassFeeType;

@Repository
@RepositoryRestController
public interface ClassFeeTypeRepository extends CrudRepository<ClassFeeType, Long> {
	ClassFeeType findByName(String name);
}
