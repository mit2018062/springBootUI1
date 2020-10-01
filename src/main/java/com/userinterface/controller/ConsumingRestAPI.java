package com.userinterface.controller;

//import java.awt.PageAttributes.MediaType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
//import javax.ws.rs.core.MediaType;
import com.fasterxml.jackson.databind.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userinterface.services.PatientService;
import com.userinterface.Domain.PageHandlers;
import com.userinterface.Domain.Patient;
import com.userinterface.Domain.PatientForm;

@Controller
public class ConsumingRestAPI {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private PatientService patientService;
	
	//private static String URL = "http://localhost:8080/patient/list";
	//private static String URL1 ="http://localhost:8071/patient?name";
	private static String URL3 = "https://8081-a2f39654-8660-4baa-bb3f-eac747e3a583.ws-us02.gitpod.io/patient/";
	/*@GetMapping("/patient/list")
	public Patient getPatients() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Patient> entity = new HttpEntity<Patient>(headers);
		restTemplate.exchange(URL, HttpMethod.GET, entity, Patient.class).getBody();
	}*/
	

	/*@GetMapping("/patient/list")
	 public String listPatient(Model model) {
			ObjectMapper mapper = new ObjectMapper();
			//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			//mapper.setDateFormat(df);
			String json1 ="[{ \"firstname\" : \"shan\", \"lastname\" : \"rahu\",\"gender\" : \"male\" }]"; 
			          
			
			try {
				
				 List<Patient> ppl2 = Arrays.asList(mapper.readValue(restTemplate.getForObject(URL, String.class), Patient[].class));

		         System.out.println("\nJSON array to List of objectsss");
		           //.stream().forEach(x -> System.out.println(x.getFirstname(),x.getLastName()));
		           ppl2.stream().forEach(x ->System.out.printf("First Name: %s\nLast Name: %s",x.getFirstname(), x.getLastname()));
				/*Patient p = mapper.readValue(json1,Patient.class);
				System.out.println(p.getFirstname());
				
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
	        return ppl2;
	        //return restTemplate.getForObject(URL, String.class);
	   }*/
	
   @RequestMapping("/")
    public String redirToList(){
    	System.out.println("Inside Controller /");
        return "redirect:/patient/list/0";
    } 
       
	/*@GetMapping("/patient/list")
	 public String listPatient(Model model) {
             //System.out.println(restTemplate.getForObject(URL, String.class));

	        model.addAttribute("patients", patientService.listAll());
	        return "patient/list";
	        //return restTemplate.getForObject(URL, String.class);
     }*/
     
     @GetMapping("/patient/list/{pageno}" )
	 public String listPatient(Model model, @PathVariable String pageno ) {
             //System.out.println(restTemplate.getForObject(URL, String.class));
            
            PageHandlers page = patientService.listAll(pageno) ; 
            int i = Integer.parseInt(pageno); 
            int currentPage = 1; 
            System.out.println(i);
            long totalItems = page.getNumberOfElements();
            int totalPages = page.getTotalPages();
            model.addAttribute("currentPage",currentPage);
            model.addAttribute("totalItems",totalItems);
            model.addAttribute("totalPages",totalPages); 
	        model.addAttribute("patients", page.getContent());
	        return "patient/list";
	        //return restTemplate.getForObject(URL, String.class);
     }
	   
        

	@RequestMapping(value = "/patient/search")
    public String searchName() {
        System.out.println("Hi search");

        return "/patient/search";

    }

    /*@GetMapping(value = "/Search")
    public String search(@RequestParam(value = "name") String name, Model model) {
        System.out.println(name);
        model.addAttribute("patients", patientService.getByFnameAndLname(name));
        System.out.println("8");
        return "/patient/searchlist";
    }*/

    
    @GetMapping(value = "/Search")
    public String search(@RequestParam(value = "name") String name, Model model,Pageable p) {
        System.out.println(name);
        model.addAttribute("patients", patientService.getByFnameAndLname(name));
        System.out.println("8");
        return "/patient/searchlist";
    }
	  @RequestMapping("/patient/new")
	    public String newPatient(Model model) {
	        System.out.println("1");
	        model.addAttribute("patient", new PatientForm());
	        System.out.println("after");
	        return "patient/patientform";
	  }
	  
	  /* @RequestMapping(value = "/patient", method = RequestMethod.POST)
	    public String saveOrUpdatePatient(@Valid PatientForm patientForm, BindingResult bindingResult) {
	        System.out.println("5");
	      
	        //System.out.println(patientForm.getDob());
	        restTemplate.postForObject(URL3, patientForm, PatientForm.class);
	        //Patient savedPatient = patientService.saveOrUpdatePatientForm(patientForm);
	        //return "redirect:/patient/show/" + savedPatient.getPid();
	        return "redirect:/patient/list/";
	    }*/
	  /*@RequestMapping(value = "/patient", method = RequestMethod.POST)
	  public String saveOrUpdatePatient(@Valid PatientForm patientForm, BindingResult bindingResult) {
	        System.out.println("5");
	        HttpHeaders headers = new HttpHeaders();
	        System.out.println("6");
			headers.setContentType(MediaType.APPLICATION_JSON);
			System.out.println("7");
			//URI uri = new URI("http://localhost:8080/employee");
			//Patient objEmp = new Employee();
			//objEmp.setName("Krishna");
			//objEmp.setCity("Noida");

			HttpEntity<PatientForm> httpEntity = new HttpEntity<>(patientForm, headers);
			System.out.println("8");
			//RestTemplate restTemplate = new RestTemplate();
			System.out.println("9");
			//System.out.println(restTemplate.postForObject(URL3, httpEntity, PatientForm.class));
			restTemplate.postForObject(URL3, httpEntity, PatientForm.class);
			System.out.println("10");
			//System.out.println("Name: " + p.getFirstname());
			System.out.println("11");
	        //System.out.println(patientForm.getDob());
	        //restTemplate.postForObject(URL3, patientForm, PatientForm.class);
	        //Patient savedPatient = patientService.saveOrUpdatePatientForm(patientForm);
	        //return "redirect:/patient/show/" + savedPatient.getPid();
	        return "redirect:/patient/list/";
	    }*/
	

	  @RequestMapping(value = "/patient", method = RequestMethod.POST)
	  public String saveOrUpdatePatient(@Valid PatientForm patientForm, BindingResult bindingResult) {
	        System.out.println("5");
	        HttpHeaders headers = new HttpHeaders();
	        System.out.println("6");
			headers.setContentType(MediaType.APPLICATION_JSON);
			System.out.println("7");
			ObjectMapper mapper = new ObjectMapper();
			HttpEntity<PatientForm> httpEntity = new HttpEntity<>(patientForm, headers);
			System.out.println("8");
			
			System.out.println("9");
			//System.out.println(restTemplate.postForObject(URL3, httpEntity, PatientForm.class));
			try {
				String jsonstring = mapper.writeValueAsString(restTemplate.postForObject(URL3, httpEntity, PatientForm.class));
				System.out.println(jsonstring);
				System.out.println("\nJSON object daata gone");
			} catch (RestClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("10");
			//System.out.println("Name: " + p.getFirstname());
			System.out.println("11");
	        //System.out.println(patientForm.getDob());
	        //restTemplate.postForObject(URL3, patientForm, PatientForm.class);
	        //Patient savedPatient = patientService.saveOrUpdatePatientForm(patientForm);
	        //return "redirect:/patient/show/" + savedPatient.getPid();
	        return "redirect:/patient/list/";
	    }  
	/*
	//Running one
	/*@GetMapping("/patient/list")
	 public String listPatient(Model model) {
		 	System.out.println(restTemplate.getForObject(URL, String.class));
			
			//ResponseEntity<Patient> p= restTemplate.getForEntity(URL, Patient.class);
	        //model.addAttribute("patients", p.getBody());
	        //System.out.println(p);
	        //return "patient/list";
	        return restTemplate.getForObject(URL, String.class);
	 }*/
	
	
	/*@GetMapping("/patient/list")
	public Patient listAllPatients(Model model) {
		 
		final Patient responseBody = restTemplate.getForObject(URL, Patient.class);
		model.addAttribute("patients", responseBody);
		return "patient/list";
		//return responseBody;
	}
	/*@GetMapping("/patient/list")
	public Object getPatients() {
		System.out.println(restTemplate.getForEntity(URL, Object.class));
		return restTemplate.getForEntity(URL, Object.class);
	}

	@GetMapping("/patient/{id}")
	public Object getEmployeesById(@PathVariable Integer id) {
		return restTemplate.getForEntity(URL + "/" + id, Object.class).getBody();
	}
	*/
	/*@PostMapping("/patient")
	public PatientForm createEmployees(@RequestBody PatientForm patient) {
		System.out.println("2");
		System.out.println(restTemplate.postForEntity(URL3, patient, PatientForm.class).getBody().getFirstname());
		System.out.println(restTemplate.postForEntity(URL3, patient, PatientForm.class).getBody());
		
		return restTemplate.postForEntity(URL3, patient, PatientForm.class).getBody();
	}*/

	
	
}
