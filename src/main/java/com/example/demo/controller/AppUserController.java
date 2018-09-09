package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AppUser;
import com.example.demo.model.Student;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class AppUserController {

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
//	@RequestMapping(value="/users/login", method=RequestMethod.POST)
//	public ResponseEntity<AppUser> getAppUser(@RequestBody AppUser appUser){
//		AppUser appUser1= appUserRepository.findByUsername(appUser.getUsername());
//		if(!appUser.getPassword().equals(appUser1.getPassword()) || !appUser.getUsername().equals(appUser1.getUsername())){
//			return new ResponseEntity<AppUser>(appUser1,HttpStatus.BAD_REQUEST);
//		}
//		System.out.println(appUser.getUsername() + "============" + appUser.getPassword());
//		return new ResponseEntity<AppUser>(appUser1, HttpStatus.OK);
//	}
	
	@RequestMapping(value="/users/login", method=RequestMethod.POST)
	public ResponseEntity<AppUser> getAppUser(@RequestBody AppUser appUser){
		System.out.println("=============getAppUser=============="+appUser.toString());
		AppUser appUser1= appUserRepository.findByEmail(appUser.getEmail());
		System.out.println("=============appUser1 email=============="+appUser1.toString());
		if(!appUser.getPassword().equals(appUser1.getPassword())){
			System.out.println("=============Inside Bad Request=============="+appUser1.toString());
			return new ResponseEntity<AppUser>(appUser1,HttpStatus.BAD_REQUEST);
		}
		System.out.println(appUser.getEmail() + "============" + appUser.getPassword());
		//return new ResponseEntity<AppUser>(appUser1,headers, HttpStatus.OK);
		return new ResponseEntity<AppUser>(appUser1,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public ResponseEntity<AppUser> addStudent(@RequestBody AppUser appUser) {
		return new ResponseEntity<AppUser>(appUserRepository.save(appUser), HttpStatus.OK);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<AppUser> getAppUsers(){
		return (List<AppUser>) appUserRepository.findAll();
	}
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.GET)
	public ResponseEntity<Optional<AppUser>> getAppUsers(@PathVariable String userId){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Allow", "OPTIONS,HEAD,GET,POST,PUT");
		
		Optional<AppUser> appUser1 =  appUserRepository.findByUserId(userId);
		return new ResponseEntity<Optional<AppUser>>(appUser1, headers,HttpStatus.OK);
	}
	
	@RequestMapping(value="/overview", method=RequestMethod.GET)
	public  ResponseEntity<Map<String, Integer>>  getCounts(){
		Map<String,Integer> countsMap = new HashMap<>();
		Integer activeStudents = 0;
		Integer inactivesStudents =0;
		Integer newStudents =0;
		List<Student> totalStudents = (List<Student>) studentRepository.findAll();
		
		for(Student student : totalStudents){
			if(student.isActive()){
				activeStudents++;
			}else{
				inactivesStudents++;
			}
			if(student.isNew()){
				newStudents++;
			}
		}
		
		countsMap.put("TOTAL_STUDENTS", activeStudents + inactivesStudents);
		countsMap.put("ACTIVE_STUDENTS", activeStudents);
		countsMap.put("INACTIVE_STUDENTS", inactivesStudents);
		countsMap.put("NEW_STUDENTS", newStudents);
//		countsMap.put("TOTAL_PROJECTED_FEES", arg1);
//		countsMap.put("TOTAL_COLLECTED_FEES", arg1);
//		countsMap.put("TOTAL_REMAINING_FEES", arg1);
		
		return new ResponseEntity<Map<String, Integer>>(countsMap,HttpStatus.OK);
	}
}
