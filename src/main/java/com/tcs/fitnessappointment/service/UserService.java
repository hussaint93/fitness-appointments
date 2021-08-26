package com.tcs.fitnessappointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.fitnessappointment.User;
import com.tcs.fitnessappointment.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepo;

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public Iterable<User> getAll() {
	return userRepo.findAll();
	}

	
}
