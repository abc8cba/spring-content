package com.project.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.project.demo.model.Address;
import com.project.demo.model.Employee;
import com.project.demo.model.Name;

@Configuration
@ComponentScan(basePackages = {"com.project.demo"})
public class WebConfig {
	
	@Bean("name1")
	public Name getName() {
		Name name = new Name("Ganga", "Keshari", "Singh");
		return name;
	}
	
	@Bean("address1")
	public Address getAddress() {
		Address address = new Address("India", "West Bengal", "Kolkata", "333222", "Near Indian oil petrol pump");
	    return address;
	}
	
	@Bean("e1")
	public Employee getEmployee() {
		Employee employee = new Employee(101, getName(), getAddress());
		return employee;
	}

}
