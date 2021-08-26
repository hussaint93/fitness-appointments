package com.tcs.fitnessappointment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tcs.fitnessappointment.Appointment;
import com.tcs.fitnessappointment.exception.UserNotFoundException;
import com.tcs.fitnessappointment.repository.IAppointmentRepository;



@Service
public class AppointmentService implements IAppointmentService{

	@Autowired
	IAppointmentRepository appointmentRepository;
	@Override
	public void save(Appointment app) {
		appointmentRepository.save(app);
		System.out.println("saved");
	}
	@Override
	public Appointment view(Integer id) {
		Optional<Appointment> ap1=appointmentRepository.findById(id);
		return ap1.get();
	}
	@Override
	public Iterable<Appointment> getAll() {
	
		return appointmentRepository.findAll();
	}
	@Override
	public void deleteUser(Integer id) {
		Optional<Appointment> ap1=appointmentRepository.findById(id);
		if(!ap1.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		appointmentRepository.deleteById(id);
	}
	@Override
	public void updateAppointment(Integer id, Appointment app) {
		Optional<Appointment> appointmentFromDB=appointmentRepository.findById(id);
		Appointment appointment1= appointmentFromDB.get();
		
		if(StringUtils.hasText(app.getName())) {
			appointment1.setName(app.getName());
		}
		if(StringUtils.hasText(app.getEmail())) {
			appointment1.setEmail(app.getEmail());
		}
		if(StringUtils.hasText(app.getAddress())) {
			appointment1.setAddress(app.getAddress());
		}
		if(StringUtils.hasText(app.getTraineePreference())) {
			appointment1.setAddress(app.getAddress());
		}
		if((Boolean)app.isPhysiotherapist()!=null) {
			appointment1.setPhysiotherapist(app.isPhysiotherapist());
		}
		
		appointmentRepository.save(appointment1);
	}

}
