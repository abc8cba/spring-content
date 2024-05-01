package com.project.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		//usingManually();
		usingContainer();

	}

	private static void usingManually() {
		Person student = new Student();
		Person employee = new Employee();
		Person patient = new Patient();
		
		//Person person = patient;
		//Person person = employee;
		Person person = student;
		person.doProcess();
		
	}

	private static void usingContainer() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
		
//		Person person = context.getBean("person",Person.class);
//		person.doProcess();
		
		Student obj1 = context.getBean("student",Student.class);
		Student obj2 = context.getBean("student",Student.class);
		Student obj3 = context.getBean("student",Student.class);
		
		
		context.close();
		
	}

}
