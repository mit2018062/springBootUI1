package com.userinterface.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.userinterface.Domain.Patient;
import com.userinterface.services.PatientService;

@Controller
public class PatientWebController {
		@Autowired
		private PatientService patientService;   
		
		@RequestMapping("/") 
	    public String redirToList(){ 
	        return "redirect:/patient/list"; 
	    }
	    
		

	    @RequestMapping({ "/patient/list", "/patient" })
	    public String listPatient(Model model) {
	   
	        System.out.println("Submit form 1");
	        System.out.println(patientService.getById("14").getFirstname());
	        model.addAttribute("patients", patientService.listAll());
	        System.out.println("Submit form 2");
	        System.out.println(patientService.getById("14").getDob());
	        return "patient/list";
	        
	    }
	    @RequestMapping({ "/patient/new", "/patient" })
	    public String newPatient(Model model) {
	   
	        System.out.println("Submit form 1");
	        System.out.println(patientService.getById("14").getFirstname());
	        model.addAttribute("patients", patientService.listAll());
	        System.out.println("Submit form 2");
	        System.out.println(patientService.getById("14").getDob());
	        return "patient/patientform";
	        
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
	    
}
