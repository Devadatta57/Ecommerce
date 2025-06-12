package com.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
 private int id;
 private String name;
 private int weight;
 private int age;
 private String gender;
 private String disease;
 @ManyToOne
 @JoinColumn(name="doctor_id")
 private Doctor doctor;
 public Patient() {
	// TODO Auto-generated constructor stub
}
public Patient(int id, String name, int weight, int age, String gender, String disease, Doctor doctor) {
	super();
	this.id = id;
	this.name = name;
	this.weight = weight;
	this.age = age;
	this.gender = gender;
	this.disease = disease;
	this.doctor = doctor;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getWeight() {
	return weight;
}
public void setWeight(int weight) {
	this.weight = weight;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDisease() {
	return disease;
}
public void setDisease(String disease) {
	this.disease = disease;
}
public Doctor getDoctor() {
	return doctor;
}
public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}
  
}
