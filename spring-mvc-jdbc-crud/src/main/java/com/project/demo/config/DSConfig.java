package com.project.demo.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DSConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] configs = {WebConfig.class, JdbcConfig.class};
		System.out.println("Config file loaded...");
		return configs;
	}

	@Override
	protected String[] getServletMappings() {
		String[] mappings = {"/","/myapp/*"};
		System.out.println("Mapping has been configured...");
		return mappings;
	}

}
