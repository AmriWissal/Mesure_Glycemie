package com.example.mesure_glycmie.Controller;

import com.example.mesure_glycmie.Model.Patient ;

public class Controller {

    private static Patient patient;
    public Controller()
    {
        super();
    }
    public void createPatient(int age,float valeur,boolean jen)
    {
        patient=new Patient(age,valeur,jen);
    }
    public String getResult()
    {
        return patient.getResult();
    }
}

