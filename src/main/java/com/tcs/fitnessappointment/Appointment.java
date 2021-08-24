package com.tcs.fitnessappointment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointment_id;
	private String name;
	private String email;
	private String address;
	private String traineePreference;
	private boolean physiotherapist;
	private int packageSelected;
	private int noOfWeeks;
	private Long number;
	private int amount= packageSelected*noOfWeeks;
	
	
	public Integer getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(Integer appointment_id) {
		this.appointment_id = appointment_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTraineePreference() {
		return traineePreference;
	}
	public void setTraineePreference(String traineePreference) {
		this.traineePreference = traineePreference;
	}
	public boolean isPhysiotherapist() {
		return physiotherapist;
	}
	public void setPhysiotherapist(boolean physiotherapist) {
		this.physiotherapist = physiotherapist;
	}
	public int getPackageSelected() {
		return packageSelected;
	}
	public void setPackageSelected(int packageSelected) {
		this.packageSelected = packageSelected;
	}
	public int getNoOfWeeks() {
		return noOfWeeks;
	}
	public void setNoOfWeeks(int noOfWeeks) {
		this.noOfWeeks = noOfWeeks;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointment_id + ", name=" + name + ", email=" + email + ", address="
				+ address + ", traineePreference=" + traineePreference + ", physiotherapist=" + physiotherapist
				+ ", packageSelected=" + packageSelected + ", noOfWeeks=" + noOfWeeks + ", number=" + number
				+ ", amount=" + amount + "]";
	}
}


