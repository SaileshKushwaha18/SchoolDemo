package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<AppUser> getAppUser(@RequestBody AppUser appUser){
		AppUser appUser1= appUserRepository.findByUsername(appUser.getUsername());
		if(!appUser.getPassword().equals(appUser1.getPassword()) || !appUser.getUsername().equals(appUser1.getUsername())){
			return new ResponseEntity<AppUser>(HttpStatus.BAD_REQUEST);
		}
		System.out.println(appUser.getUsername() + "============" + appUser.getPassword());
		return new ResponseEntity<AppUser>(appUser1, HttpStatus.OK);
	}
	
	@RequestMapping(value="/appUser", method=RequestMethod.POST)
	public ResponseEntity<AppUser> addStudent(@RequestBody AppUser appUser) {
		return new ResponseEntity<AppUser>(appUserRepository.save(appUser), HttpStatus.OK);
	}
	
	@RequestMapping(value="/appUser", method=RequestMethod.GET)
	public List<AppUser> getAppUsers(){
		return (List<AppUser>) appUserRepository.findAll();
	}
}
