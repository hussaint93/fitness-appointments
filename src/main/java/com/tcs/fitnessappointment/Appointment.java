package com.tcs.fitnessappointment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointment_id;
	
	@NotEmpty(message = "first name must not be empty")
	@Size(min=2,message="name should be gretaer the 2 characters")
	private String name;
	
	@Email(message="proper email format required")
	private String email;
	
	
	
	@NotEmpty(message="address must not be empty ")
	@Size(min=5,message="address should be gretaer then 5 characters")
	private String address;
	
	@NotEmpty(message="trainee shoul be selected or no should be selected")
	private String traineePreference;
	
	//@NotEmpty(message="trainee shoul be selected or no should be selected")
	@Value("${some.key:false}")
	private boolean physiotherapist;
	
	@Min(300)
	@Max(500)
	private int packageSelected;
	
	@Min(1)
	private int noOfWeeks;
	
	@NotNull(message="number must not be null")
	private Long number;
	
	private int amount= packageSelected*noOfWeeks;
	
	private int u_id;
	
	
	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointment_id + ", name=" + name + ", email=" + email + ", address="
				+ address + ", traineePreference=" + traineePreference + ", physiotherapist=" + physiotherapist
				+ ", packageSelected=" + packageSelected + ", noOfWeeks=" + noOfWeeks + ", number=" + number
				+ ", amount=" + amount + "]";
	}
}


