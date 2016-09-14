package co.gov.ideam.prasdes.dataservices.web.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.ideam.prasdes.dataservices.services.DailydataService;
import co.gov.ideam.prasdes.dataservices.services.InstantdataService;
import co.gov.ideam.prasdes.dataservices.services.MonthlydataService;
import co.gov.ideam.prasdes.dataservices.services.RawdataService;



public class CommonController {

	@Autowired
	protected MessageSource messageSource;
	
	@Autowired 
	protected ApplicationContext appContext;
	
	@Autowired
	protected ServletContext servletContext;
	
	@Autowired
	protected DailydataService dailydataServiceImpl;
	
	@Autowired
	protected MonthlydataService monthlydataServiceImpl;

	@Autowired
	protected InstantdataService instantdataServiceImpl;
	
	@Autowired
	protected RawdataService rawdataServiceImpl;
	
	@Value("${appconfig.serviciosConsultaHabilitados}")
	public String serviciosConsultaHabilitados;
	
	@Value("${appconfig.serviciosPersistenciaHabilitados}")
	public String serviciosPersistenciaHabilitados;
	
	
	@Value("${prasdes.aceptarNulos}")
	public boolean aceptarNulos;
	
	@Value("${prasdes.flagDefaultNullValue}")
	public Long flagNulosValues;
	
	@Value("${prasdes.idqcDefaultNullValue}")
	public Long idqcNulosValues;
	
	protected Locale locale;	
	public CommonController() {
		super();
		locale = LocaleContextHolder.getLocale();
	}

	public <T> T listFromJSON(final TypeReference<T> type,
  	      final String jsonPacket) {
  	   T data = null;
  	   ObjectMapper mapper =null;
//  	   DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  	   try {
  		 mapper = new ObjectMapper();
//  	     mapper.setDateFormat(df);
  		 data = mapper.readValue(jsonPacket, type);
  	   } catch (Exception e) {
  	      e.printStackTrace();
  	      
  	   }
  	   return data;
  	}
	/***
	 * Este metodo se genera para limpiar el json obtenido de formatos de fecha 
	 * incorrectos que se visualizaron en la generacion de la aplicacion 
	 * por parte de los otros paises '\/'
	 * @return
	 */
	public String cleanJsonIncorrectFormat(String json){
		return json.replace("\\/", "/");
	}

	public boolean isServiciosConsultaHabilitados() {
		return Boolean.parseBoolean(serviciosConsultaHabilitados);
	}



	public boolean isServiciosPersistenciaHabilitados() {
		return Boolean.parseBoolean(serviciosPersistenciaHabilitados);
	}

	
	
	
	
}
