package com.gov.ideam.prasdes.config;

import java.util.HashMap;
import java.util.Map;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.ExceptionClassifierRetryPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
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
	
	@Bean
	  public FixedBackOffPolicy getBackOffPolicy( final Environment env ) {

	    final FixedBackOffPolicy policy = new FixedBackOffPolicy();
	    policy.setBackOffPeriod( Long.valueOf( env.getRequiredProperty( "retry.interval" ) ) );

	    return policy;
	  }

	  @Bean
	  public ExceptionClassifierRetryPolicy getRetryPolicy( final Environment env ) {

	    final Map< Class< ? extends Throwable >, RetryPolicy > policyMap =
	      new HashMap< Class< ? extends Throwable >, RetryPolicy >();

	    final SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
	    simpleRetryPolicy.setMaxAttempts( Integer.valueOf( env.getRequiredProperty( "retry.count" ) ) );

	    // Determine the policy per exception
	    policyMap.put( Exception.class, simpleRetryPolicy );

	    final ExceptionClassifierRetryPolicy retryPolicy = new ExceptionClassifierRetryPolicy();
	    retryPolicy.setPolicyMap( policyMap );

	    return retryPolicy;
	  }
	
}
