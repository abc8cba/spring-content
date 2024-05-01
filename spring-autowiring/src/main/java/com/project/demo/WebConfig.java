package com.project.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.project.demo"})
public class WebConfig {
	
	@Autowired
	@Qualifier("student")
	private Person person;
	
	@Bean("person")
	@Scope("prototype")
	public Person getPerson() {
		
		return person;
	}

}
