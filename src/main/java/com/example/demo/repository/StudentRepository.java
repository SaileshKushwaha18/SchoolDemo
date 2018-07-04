package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
@RepositoryRestController
public interface StudentRepository extends CrudRepository<Student, Long> {

	Student findByAdmissionno(String admissionno);
	
	//Student newStudentId();
}
