package com.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

}
