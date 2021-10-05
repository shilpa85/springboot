package com.mobile.app.ws.ui.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.mobile.app.ws.ui.model.response.UserRest;

//to building RESTful web services, HTTP requests are handled by a controller with @RestController annotation
@RestController  
@RequestMapping("/users")   
public class UserController {
	
	@GetMapping
	public String getUser(@RequestParam(value="page", defaultValue="1") int page,  
			@RequestParam(value="limit", defaultValue="50") int limit) {
		return "test get page =" + page + "limit = " + limit;
	}
	
	@GetMapping(path="/{userId}")
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		UserRest returnValue = new UserRest();
		returnValue.setFirstName("shilpa");
		returnValue.setLastName("singh");
		returnValue.setEmail("shilpa@gmail.com");
		returnValue.setUserId("1");
		
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK) ;
	}


	@PostMapping
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());
		//returnValue.setPassword(userDetails.getPassword());
		
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK) ;
		
	}
	
	@PutMapping
	public String updateUser() {
		return "test udpdate";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "test delete";
	}
}
