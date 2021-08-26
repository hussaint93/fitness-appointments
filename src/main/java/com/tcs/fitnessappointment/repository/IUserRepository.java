package com.tcs.fitnessappointment.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcs.fitnessappointment.User;

public interface IUserRepository extends CrudRepository<User, Integer> {

}
