package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;
import com.example.demo.model.StudentFee;

@Repository
@RepositoryRestController
public interface StudentFeeRepository extends CrudRepository<StudentFee, Long> {
	List<StudentFee> findByStudent(Student id);
}
