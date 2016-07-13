package com.gov.ideam.prasdes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;


@SpringBootApplication
public class PrasdesClientesConfiguracionApplicationJboss extends SpringBootServletInitializer 
{

	public static void main(String[] args) {
		SpringApplication.run(PrasdesClientesConfiguracionApplicationJboss.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PrasdesClientesConfiguracionApplication.class);
    }
	

	    
	
	
}
