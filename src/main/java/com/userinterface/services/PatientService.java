package com.userinterface.services;

import java.util.List;

import com.userinterface.Domain.Patient;

public interface PatientService {
	public List<Patient> listAll();
	public Patient getById(String id);
}
