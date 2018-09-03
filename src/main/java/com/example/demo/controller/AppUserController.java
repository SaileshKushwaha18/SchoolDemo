package com.example.demo.controller;

import java.util.List;
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
import com.example.demo.repository.AppUserRepository;

@RestController
@RequestMapping("/api")
public class AppUserController {

	@Autowired
	private AppUserRepository appUserRepository;
	
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
}
