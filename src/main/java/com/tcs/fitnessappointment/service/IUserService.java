package com.tcs.fitnessappointment.service;

import javax.validation.Valid;

import com.tcs.fitnessappointment.User;

public interface IUserService {

	User saveUser( User user);

	Iterable<User> getAll();

}
