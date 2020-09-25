/*package com.userinterface.controller;

import java.util.List;
import java.awt.PageAttributes.MediaType;
import java.net.http.*;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.userinterface.Domain.Patient;
import com.userinterface.services.PatientService;


@RestController
public class PatientWebController {
		
		
		@Autowired
		private PatientService patientService;
		private RestTemplate restTemplate;
		
		@RequestMapping("/") 
	    public String redirToList(){ 
	        return "redirect:/patient/list"; 
	    }
	    
		
		   
		   @RequestMapping(value = "/patient/list")
		   public String getProductList() {
		      HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity <String> entity = new HttpEntity<String>(headers);
		      
		      return restTemplate.exchange("http://localhost:8080/patient/list", HttpMethod.GET, entity, String.class).getBody();
		   }
		
		
		/*@GetMapping("/patient")
		public List<Patient> getPatientlist(){
			String URL = "http://localhost:8080/patient/list";
			Patient[] patient = restTemplate.getForObject(URL, Patient[].class);
			return Arrays.asList(patient);
		}*/
	    /*@RequestMapping({ "/patient/list", "/patient" })
	    public String listPatient(Model model) {
	    	
	        System.out.println("Submit form 1");
	        System.out.println(patientService.getById("14").getFirstname());
	        model.addAttribute("patients", patientService.listAll());
	        System.out.println("Submit form 2");
	        System.out.println(patientService.getById("14").getDob());
	    	
	        return "patient/list";
	        
	    }
	    
	   @RequestMapping("/patient/new")
	    public String newPatient() {
	        System.out.println("1");
	        //Patient patient = new Patient();
	        //model.addAttribute("patientForm", patient);
	        
	        return "patient/patientform";
	    }
	    
	    
	    @RequestMapping(value = "/patient/save", method = RequestMethod.POST)
	    public String saveOrUpdatePatient(@RequestBody Patient patient) {
	        System.out.println("5");
	        
	    
	        Patient savedPatient = patientService.saveOrUpdatePatient(patient);
	        return "redirect:/patient/show/" + savedPatient.getPid();
	    }
	  
	    @RequestMapping(value = "/patient/search")
	    public String searchName() {
	        System.out.println("Hi search");

	        return "/patient/search";
	    }


	    @GetMapping(value = "/Search")
	    public String search(@RequestParam(value = "Name") String name, Model model) {
	        System.out.println(name);
	        model.addAttribute("patients", patientService.getByFnameAndLname(name));
	        System.out.println("8");
	        return "/patient/searchlist";
	    }
	    
	   /* @RequestMapping(value = "/patient", method = RequestMethod.POST)
	    public String saveOrUpdatePatient(@Valid PatientForm patientForm, BindingResult bindingResult) {
	        System.out.println("5");
	        if(bindingResult.hasErrors()){
	            return "patient/patientform";
	        }
	        Patient savedPatient = patientService.saveOrUpdatePatientForm(patientForm);
	        return "redirect:/patient/show/" + savedPatient.getId();
	    }
	    
	    @RequestMapping("/patient/show/{id}")
	    public String getPatient(@PathVariable String id, Model model) {
	        Patient p = patientService.getById(id);
	        //model.addAttribute("age",Period.between(patientService.getById(id).getDob(), LocalDate.now()).getYears());
	        model.addAttribute("patient", p);
	        //Patient xyz = patientService.getById(id);
	        //System.out.println(Period.between(patientService.getById(id).getDob(), LocalDate.now()).getYears());
	        return "patient/show";
	    }
	    
}*/
