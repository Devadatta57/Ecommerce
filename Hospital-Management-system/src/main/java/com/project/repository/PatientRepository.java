package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Patient;

@Repository
public interface PatientRepository  extends JpaRepository<Patient, Integer>{

}
