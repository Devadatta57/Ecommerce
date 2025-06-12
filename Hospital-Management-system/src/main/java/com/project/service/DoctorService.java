package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Doctor;
import com.project.repository.DoctorRepository;
@Service
public class DoctorService {

	DoctorRepository repository;
	
	
	
	public DoctorService(DoctorRepository repository) {
		super();
		this.repository = repository;
	}



	public Doctor saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return repository.save(doctor);
	}



	public List<Doctor> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}



	public Doctor findById(int id) {
		return repository.findById(id).orElse(new Doctor());
	}



	public Doctor editDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return repository.save(doctor);
	}



	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	

}
