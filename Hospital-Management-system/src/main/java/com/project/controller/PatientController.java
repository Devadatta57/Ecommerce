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

import com.project.entity.Patient;
import com.project.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {	
	PatientService service;	
	public PatientController(PatientService service) {
		super();
		this.service = service;
	}


	@PostMapping
	public ResponseEntity<?> savePatient(@RequestBody Patient patient){
		
		 patient=service.savePatient(patient);
		 if(patient!=null) {
			 return new ResponseEntity<>(patient,HttpStatus.ACCEPTED);
		 }
		 else {
			 return new ResponseEntity<>("not saved",HttpStatus.BAD_REQUEST);
		 }
		
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<Patient> patients=service.findPatients();
		if(patients.size()!=0) {
			 return new ResponseEntity<>(patients,HttpStatus.ACCEPTED);
		}
		else {
			 return new ResponseEntity<>("no patients",HttpStatus.BAD_REQUEST);

		}
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		    Patient p= service.findById(id);
		    if(p.getId()!=0) {
				 return new ResponseEntity<>(p,HttpStatus.ACCEPTED);
		    }
		    else {
				 return new ResponseEntity<>("invalid id",HttpStatus.BAD_REQUEST);

		    }
	}
	
	@PutMapping
	public ResponseEntity<?> editPatient(@RequestBody Patient p){
		  service.savePatient(p);
		  return new ResponseEntity<>(p,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletePatient(@PathVariable int id){
	 Patient p=	service.findById(id);
	 if(p.getId()!=0) {
		 service.deletePatient(id);
		  return new ResponseEntity<>("deleted",HttpStatus.ACCEPTED);

	 }
	 else {
		  return new ResponseEntity<>("invalid id",HttpStatus.BAD_REQUEST);

	 }
	}
	
	

}
