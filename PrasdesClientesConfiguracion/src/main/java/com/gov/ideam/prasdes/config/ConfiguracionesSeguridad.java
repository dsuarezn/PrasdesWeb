package com.gov.ideam.prasdes.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ConfiguracionesSeguridad extends WebSecurityConfigurerAdapter
{

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// TODO Auto-generated method stub
		httpSecurity.authorizeRequests().antMatchers("/").permitAll();
//		super.configure(httpSecurity);
		httpSecurity.csrf().disable();
	}
}
