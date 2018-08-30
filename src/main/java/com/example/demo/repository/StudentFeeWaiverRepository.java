package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;
import com.example.demo.model.StudentFeeWaiver;

@Repository
@RepositoryRestController
public interface StudentFeeWaiverRepository extends CrudRepository<StudentFeeWaiver, Long> {
	
	List<StudentFeeWaiver> findByStudent(Student student);
}
