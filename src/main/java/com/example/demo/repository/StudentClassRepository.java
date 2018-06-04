package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentClass;

@Repository
@RepositoryRestController
public interface StudentClassRepository extends CrudRepository<StudentClass, Long> {
	StudentClass findByName(String name);
}
