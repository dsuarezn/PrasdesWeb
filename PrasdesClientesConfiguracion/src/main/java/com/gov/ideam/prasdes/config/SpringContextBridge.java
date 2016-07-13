package com.gov.ideam.prasdes.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.gov.ideam.prasdes.rest.RestAdapterImpl;

@Component 
public class SpringContextBridge implements ApplicationContextAware {

	@Autowired
	private AppConfigInfo appConfigInfo;
	
	@Autowired
	private RestAdapterImpl restAdapterImpl;
	
	private static ApplicationContext applicationContext;

	 @Override
	    public void setApplicationContext(ApplicationContext applicationContext) 
	            throws BeansException {
	        this.applicationContext = applicationContext;
	    }
	
	 public static RestAdapterImpl getRestAdapterInstance() {
	        return applicationContext.getBean(RestAdapterImpl.class);
	 }
	 
	 public static AppConfigInfo getAppConfigInfoInstance() {
	        return applicationContext.getBean(AppConfigInfo.class);
	 }
	 
}
