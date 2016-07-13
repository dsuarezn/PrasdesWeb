package co.gov.ideam.prasdes.dataservices.web.controladores;

import java.util.Locale;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.ideam.prasdes.dataservices.services.ConnectionService;
import co.gov.ideam.prasdes.dataservices.services.CountryService;
import co.gov.ideam.prasdes.dataservices.services.CustomerStationVarService;
import co.gov.ideam.prasdes.dataservices.services.CustomerWebServService;
import co.gov.ideam.prasdes.dataservices.services.MigTaskService;
import co.gov.ideam.prasdes.dataservices.services.PeriodService;
import co.gov.ideam.prasdes.dataservices.services.PrasdesEquivService;
import co.gov.ideam.prasdes.dataservices.services.StationService;
import co.gov.ideam.prasdes.dataservices.services.VariableService;


public class CommonController {

	@Autowired 
	protected ApplicationContext appContext;
	
	@Autowired
	protected ServletContext servletContext;

	@Autowired
	protected ConnectionService connectionServiceImpl;	
	
	@Autowired
	protected PrasdesEquivService prasdesEquivServiceImpl;
	
	@Autowired
	protected MigTaskService migTaskServiceImpl;
	
	@Autowired
	protected StationService stationServiceImpl;
	
	@Autowired
	protected VariableService variableServiceImpl;
	
	@Autowired
	protected CustomerStationVarService customerStationVarServiceImpl;
	
	@Autowired
	protected CustomerWebServService customerWebServServiceImpl;
	
	@Autowired
	protected CountryService countryServiceImpl;
	
	@Autowired
	protected PeriodService periodServiceImpl;
	
	@Value("${appconfig.serviciosConsultaHabilitados}")
	public String serviciosConsultaHabilitados;
	
	@Value("${appconfig.serviciosPersistenciaHabilitados}")
	public String serviciosPersistenciaHabilitados;
	
	
	
	protected Locale locale;	
	public CommonController() {
		super();
		locale = LocaleContextHolder.getLocale();
	}

	public <T> T listFromJSON(final TypeReference<T> type,
  	      final String jsonPacket) {
  	   T data = null;

  	   try {
  	      data = new ObjectMapper().readValue(jsonPacket, type);
  	   } catch (Exception e) {
  	      // Handle the problem
  	   }
  	   return data;
  	}

	
}
