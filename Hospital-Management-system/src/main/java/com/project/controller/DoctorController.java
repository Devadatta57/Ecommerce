package com.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Doctor;
import com.project.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	
	DoctorService service;
	
       
	public DoctorController(DoctorService service) {
		super();
		this.service = service;
	}


	@PostMapping
	public ResponseEntity<?> saveDoctor(@RequestBody Doctor doctor){
		Doctor result=service.saveDoctor(doctor);
		if(result!=null) {
			return new ResponseEntity<>(doctor,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<>(doctor,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<Doctor> doctors=service.findAll();
		if(doctors.size()!=0) {
			return new ResponseEntity<>(doctors,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<>(doctors,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<?> findDoctorByID(@PathVariable int id){
		  Doctor doctor=service.findById(id);
		  if(doctor.getId()!=0) {
			  return new ResponseEntity<>(doctor,HttpStatus.FOUND);
		  }
		  else {
			  return new ResponseEntity<>(doctor,HttpStatus.BAD_REQUEST);
		  }
	}
	
	
	@PutMapping
	public ResponseEntity<?> editDoctor(@RequestBody Doctor doctor){
	  doctor=service.editDoctor(doctor);
	  if(doctor.getId()!=0) {
		  return new ResponseEntity<>(doctor,HttpStatus.ACCEPTED);
	  }
	  else {
		  return new ResponseEntity<>(doctor,HttpStatus.BAD_REQUEST);
	  }
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteDoctor(@PathVariable int id){
		Doctor doctor=service.findById(id);
		if(doctor.getId()!=0) {
			service.deleteEmployee(id);
			  return new ResponseEntity<>("deleted",HttpStatus.ACCEPTED);
		}
		else {
			  return new ResponseEntity<>("invalid id",HttpStatus.BAD_REQUEST);
	
		}
		
	}
}
