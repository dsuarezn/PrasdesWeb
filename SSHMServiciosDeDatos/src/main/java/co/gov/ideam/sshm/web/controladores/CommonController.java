package co.gov.ideam.sshm.web.controladores;

import java.util.Locale;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.ideam.sshm.dataservices.services.DailydataService;
import co.gov.ideam.sshm.dataservices.services.InstantdataService;
import co.gov.ideam.sshm.dataservices.services.MonthlydataService;




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
