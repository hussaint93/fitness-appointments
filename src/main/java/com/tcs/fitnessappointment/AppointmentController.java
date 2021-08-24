package com.tcs.fitnessappointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//{
//    "name":"moha",
//    "email":"huss@gmail.com",
//    "address":"mumbai",
//    "traineePreference":"male",
//    "physiotherapist":false,
//    "packageSelected":300,
//    "noOfWeeks":5,
//    "number":123456780
//}

@RestController
public class AppointmentController {

	@Autowired
	IAppointmentService appointmentService;
	
	//to get appointment based on the user id 
	@GetMapping("/view/{appointment_id}")
	private Appointment getAppointment(@PathVariable Integer appointment_id) {
		
		return appointmentService.view(appointment_id);
	}
	@PostMapping("/place")
	private void saveAppointment(@RequestBody Appointment app) {
		app.setAmount(app.getNoOfWeeks()*app.getPackageSelected());
		appointmentService.save(app);
		//System.out.println(user.getFirstName());
	}
}
