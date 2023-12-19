package com.example.mesure_glycmie.controller;

import com.example.mesure_glycmie.model.Patient ;

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

