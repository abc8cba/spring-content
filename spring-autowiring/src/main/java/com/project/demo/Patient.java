package com.project.demo;

import org.springframework.stereotype.Component;

@Component("patient")
public class Patient extends Person{

	public Patient() {
		System.out.println("Patient object created...");
	}
	
	@Override
	public void doProcess() {
		System.out.println("Patient class is doing its own operations ");
		
	}

	
}
