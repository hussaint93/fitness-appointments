package com.tcs.fitnessappointment;

public interface IAppointmentService {
	void save(Appointment app);
	Appointment view(Integer id);
}
