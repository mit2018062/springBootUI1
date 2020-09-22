package com.userinterface.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.userinterface.Domain.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	private List<Patient> list;
	
	
	public PatientServiceImpl() {
		list = new ArrayList<>(); 
		list.add(new Patient("14", "Saket","Lakhpati",26,"male",LocalDate.parse("1994-03-17")));
		list.add(new Patient("115", "Sat","Lakhti",24,"male",LocalDate.parse("1998-03-18")));
		list.add(new Patient("104", "Aryan","Singh",26,"male",LocalDate.parse("1994-07-02")));
		
	}


	@Override
	public List<Patient> listAll() {
		return list;
	}


	@Override
	public Patient getById(String id) {
		Patient p = null;
		for(Patient patients:list){
			if(patients.getPid() == id) {
				p = patients;
				break;
			}
		}
		return p;
	}


	@Override
	public Patient saveOrUpdatePatient(Patient patient) {
		list.add(new Patient(patient.getPid(),patient.getFirstname(),patient.getLastname(),patient.getAge(),patient.getGender(),patient.getDob()));
		return patient;
	}


	@Override
	public List<Patient> getByFnameAndLname(String name) {
		
		List<Patient> p = new ArrayList<>();
		//Patient p = new Patient();
		for(Patient patients:list){
			if(patients.getFirstname().equals(name)|| patients.getLastname().equals(name)) {
				//return patients;
				p.add(patients);
			}
		}
		return p;
	}
	
	
	
}
