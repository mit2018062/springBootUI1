package com.userinterface.converters;



//import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.userinterface.Domain.Patient;
import com.userinterface.Domain.PatientForm;

/**
 * Created by jt on 1/10/17.
 */
@Component
public abstract class PatientFormToPatient implements Converter<PatientForm, Patient> {

    @Override
    public Patient convert(PatientForm patientForm) {
        Patient patient = new Patient();
        
        patient.setFirstname(patientForm.getFirstname());
        patient.setLastname(patientForm.getLastname());
        //patient.setAge(patientForm.getAge());
        //patient.setDob(patientForm.getDob());
        patient.setGender(patientForm.getGender());
        return patient;
    }
}
