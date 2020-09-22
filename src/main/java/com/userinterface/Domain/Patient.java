package com.userinterface.Domain;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;

public class Patient {
    
    private String pid;
    private String firstname;
    private String lastname;
    private int age;
    private String gender;
 
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    
    public Patient(String pid, String firstname, String lastname, int age, String gender,LocalDate dob) {
		super();
		this.pid = pid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
	}

    public Patient() {
    	super();
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        
        this.age = Period.between(dob, LocalDate.now()).getYears();
        this.dob = dob;
    }
}
