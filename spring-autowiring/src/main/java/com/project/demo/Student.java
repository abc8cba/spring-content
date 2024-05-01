package com.project.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("student")
@Scope("singleton")
public class Student extends Person{

	public Student() {
		System.out.println("Student object created...");
	}

	@Override
	public void doProcess() {
		System.out.println("Student class is doing its own operations ");
		
	}

}
