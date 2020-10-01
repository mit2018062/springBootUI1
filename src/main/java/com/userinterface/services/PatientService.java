package com.userinterface.services;

import java.util.List;

import com.userinterface.Domain.PageHandlers;
import com.userinterface.Domain.Patient;
import com.userinterface.Domain.PatientForm;

public interface PatientService {
	//public List<Patient> listAll();
	public Patient getById(String id);
	public Patient saveOrUpdatePatient(Patient patient);
	//public Patient getByFnameAndLname(String name);
	List<Patient> getByFnameAndLname(String name);
	Patient saveOrUpdatePatientForm(PatientForm patientForm);
	public PageHandlers listAll(String pageno);
}
