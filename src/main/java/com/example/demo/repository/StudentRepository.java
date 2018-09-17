package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;
import com.example.demo.model.StudentClass;

@Repository
@RepositoryRestController
public interface StudentRepository extends CrudRepository<Student, Long> {

	Student findByAdmissionno(String admissionno);
	
	List<Student> findByStudentClass(StudentClass studentClass);
	
	Student findByStudentId(Long studentId);
	
}
