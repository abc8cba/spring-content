package com.project.demo.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DSConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {
			JdbcTemplateConfig.class,
			HibernateConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Config file loaded...");
		return new Class[] {
				WebConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Mapping has been configured...");
		return new String[] {"/"};
	}

}
