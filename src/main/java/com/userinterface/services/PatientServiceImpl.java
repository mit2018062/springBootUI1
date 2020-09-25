package com.userinterface.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userinterface.Domain.Patient;
import com.userinterface.Domain.PatientForm;

@Service
public class PatientServiceImpl implements PatientService {

	private List<Patient> list;
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*public PatientServiceImpl() {
		list = new ArrayList<>(); 
		list.add(new Patient("14", "Saket","Lakhpati",26,"male",LocalDate.parse("1994-03-17")));
		list.add(new Patient("115", "Sat","Lakhti",24,"male",LocalDate.parse("1998-03-18")));
		list.add(new Patient("104", "Aryan","Singh",26,"male",LocalDate.parse("1994-07-02")));
		
	}*/

	private static String URL = "http://localhost:8077/patient/list";
	private static String URL1 ="http://localhost:8077/patient?name=";
	//private static String URL1 ="http://localhost:8080/patient?firstname=annu";
	
	 /*@Override
	public List<Patient> listAll() {
		   List<Patient> patients = new ArrayList<>();
		   restTemplate.getForObject(URL, Patient.class).forEach(patients::add); // fun with Java 8
		   return patients;
	}*/
	@Override
	public List<Patient> listAll() {
		System.out.println("inside service imp");
		List<Patient> patients = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//mapper.setDateFormat(df);
		//String json1 ="[{ \"firstname\" : \"shan\", \"lastname\" : \"rahu\",\"gender\" : \"male\" }]";
		try {
			
			 List<Patient> ppl2 = Arrays.asList(mapper.readValue(restTemplate.getForObject(URL, String.class), Patient[].class));
	         System.out.println("\nJSON array to List of objectsss");
	         
	           //.stream().forEach(x -> System.out.println(x.getFirstname(),x.getLastName()));
	          // ppl2.stream().forEach(x ->System.out.printf("First Name: %s\nLast Name: %s",x.getFirstname(), x.getLastname()));
	         ppl2.stream().forEach(patients::add);
			/*Patient p = mapper.readValue(json1,Patient.class);
			System.out.println(p.getFirstname());*/
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 	//System.out.println(restTemplate.getForObject(URL, String.class));
		//String p = restTemplate.getForObject(URL, String.class);
        //model.addAttribute("patients", list);
        //System.out.println(p);
        //return "patient/list";
        return patients;
        //return restTemplate.getForObject(URL, String.class);

	}
	

	
	/*public String listAll(){
		return restTemplate.getForObject(URL, String.class);
	}*/
	
	/*@Override
	public List<Patient> listAll() {
		List<Patient> p = restTemplate.getForObject(URL, List.class);;
		//String URL = "http://localhost:8080/patient/list";
		System.out.println(Arrays.asList(list));
		return p;
	}*/

	
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
		//list.add(new Patient(patient.getPid(),patient.getFirstname(),patient.getLastname(),patient.getAge(),patient.getGender(),patient.getDob()));
		return patient;
	}


	@Override
    public List<Patient> getByFnameAndLname(String name) {
        //List<Patient> patients = new ArrayList<>();
        //patientRepository.getByFnameAndLname(name).forEach(patients::add);
        //return patients;
        System.out.println("inside service imp");
        System.out.println(name);
		 List<Patient> patients = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println("inside try");
			 List<Patient> ppl3 = Arrays.asList(mapper.readValue(restTemplate.getForObject(URL1+name , String.class), Patient[].class));
	         System.out.println("\nJSON array to List of objectsssearch");
	         System.out.println(URL1+"name");
	  
	         ppl3.stream().forEach(patients::add);
			
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
       return patients;

    }



	@Override
	public Patient saveOrUpdatePatientForm(PatientForm patientForm) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
