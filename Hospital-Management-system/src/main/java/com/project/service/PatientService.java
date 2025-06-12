package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Doctor;
import com.project.entity.Patient;
import com.project.repository.DoctorRepository;
import com.project.repository.PatientRepository;

@Service
public class PatientService {

	PatientRepository repository;
	DoctorRepository repo;
	
	
	

	public PatientService(PatientRepository repository, DoctorRepository repo) {
		super();
		this.repository = repository;
		this.repo = repo;
	}

	public Patient savePatient(Patient patient) {
	    if (patient.getDoctor() != null && patient.getDoctor().getId() != 0) {
	        // Fetch the Doctor from the database
	        Doctor doctor = repo.findById(patient.getDoctor().getId()).orElse(null);
	        
	        if (doctor != null) {
	            // Set the found doctor in the patient
	            patient.setDoctor(doctor);
	        } else {
	            // Handle the case where doctor is not found, e.g., throw an exception
	            throw new RuntimeException("Doctor not found with id " + patient.getDoctor().getId());
	        }
	    }
	    // Save and return the patient
	    return repository.save(patient);
	}

	public List<Patient> findPatients() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Patient findById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(new Patient());
	}

	public void deletePatient(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}



	


}
