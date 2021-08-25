package com.tcs.fitnessappointment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.fitnessappointment.Appointment;
import com.tcs.fitnessappointment.exception.UserNotFoundException;
import com.tcs.fitnessappointment.service.IAppointmentService;



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
@ControllerAdvice
public class AppointmentController {

	@Autowired
	IAppointmentService appointmentService;
	
	//to get appointment based on the user id 
	@GetMapping("/view/{appointment_id}")
	private Appointment getAppointment(@PathVariable Integer appointment_id) {
		
		return appointmentService.view(appointment_id);
	}
	
	@GetMapping("/view")
	private Iterable<Appointment> getAllAppointments() {
		return appointmentService.getAll();
	}
	
	@PostMapping("/place")
	public ResponseEntity<Appointment> saveAppointment( @Valid @RequestBody Appointment app) {
		app.setAmount(app.getNoOfWeeks()*app.getPackageSelected());
		appointmentService.save(app);
		return new ResponseEntity<Appointment>(app,HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{id}")
	public void deleteAppointment(@PathVariable Integer id) {
		appointmentService.deleteUser(id);
	}
	
	@PutMapping("/place/{id}")
	public void updateAppointment(@PathVariable Integer id,@RequestBody Appointment app) {
		appointmentService.updateAppointment(id,app);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolationException(MethodArgumentNotValidException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = UserNotFoundException.class)
	   public ResponseEntity<Appointment> exception(RuntimeException runTimeException) {
	      return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
	   }
}

