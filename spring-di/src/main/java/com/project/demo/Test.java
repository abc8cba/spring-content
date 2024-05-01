package com.project.demo;

import com.project.demo.model.Employee;
import com.project.demo.model.Name;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.demo.config.WebConfig;
import com.project.demo.model.Address;

public class Test {

	public static void main(String[] args) {
		//manualWay();
		//springWayUsingXMLBasedConfiguration();
		springWayUsingJavaBasedConfiguration();

	}

	private static void springWayUsingJavaBasedConfiguration() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(WebConfig.class);
		Employee emp = ac.getBean("e1", Employee.class);
		System.out.println(emp);
		System.out.println("Name = "+emp.getName());
		System.out.println("Name = "+emp.getName().toString());
		
	}

	private static void springWayUsingXMLBasedConfiguration() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/project/demo/model/beans.xml");
		Employee emp = ac.getBean("e1", Employee.class);
		System.out.println(emp);
		System.out.println("Name = "+emp.getName());
		System.out.println("Name = "+emp.getName().toString());
//		ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) ac;
//		context.close();
		
		((ClassPathXmlApplicationContext)ac).close();
		
	}

	private static void manualWay() {
		Name name1 = new Name("Ravi","Keshav","Jain");
		Address address1 = new Address("India", "West Bengal", "Kolkata", "333222", "Near Indian oil petrol pump");
		Employee e1 = new Employee(101, name1, address1);
		
		System.out.println(e1);
		
	}

}
