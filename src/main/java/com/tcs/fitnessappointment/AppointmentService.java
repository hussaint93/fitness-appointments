package com.tcs.fitnessappointment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
