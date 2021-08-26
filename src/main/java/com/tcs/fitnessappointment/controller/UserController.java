package com.tcs.fitnessappointment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.fitnessappointment.Appointment;
import com.tcs.fitnessappointment.User;
import com.tcs.fitnessappointment.service.IUserService;

@RestController
@ControllerAdvice
public class UserController {

	@Autowired
	IUserService userService;
	
	@PostMapping("/user")
	public User savedUser(@Valid @RequestBody User user) {
		return userService.saveUser(user);	
	}
	@GetMapping("/user")
	public Iterable<User> getAllUser() {
		return userService.getAll();
	}
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable Integer id,@RequestBody User user) {
		return userService.updateUser(id,user);
	}
	
}
