package co.gov.ideam.prasdes.config;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

	@Value("${appconfig.defaultTimeZone}")
	private String DefaultTimeZone;
	
	@PostConstruct
	public void onAppCreate(){
		setDefaultTimeZone();		
	}
	
	private void setDefaultTimeZone(){		
		TimeZone.setDefault(TimeZone.getTimeZone(DefaultTimeZone));
//		TimeZone.setDefault(TimeZone.getDefault());
		
	}
	
}
