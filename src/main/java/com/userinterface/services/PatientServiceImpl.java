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
	
}
