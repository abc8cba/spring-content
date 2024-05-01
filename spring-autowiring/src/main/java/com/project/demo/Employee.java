package com.project.demo;

import org.springframework.stereotype.Component;

@Component("employee")
public class Employee extends Person {

	public Employee() {
		System.out.println("Employee object created...");
	}
	
	@Override
	public void doProcess() {
		System.out.println("Employee class is doing its own operations ");
		
	}
	
	

}
