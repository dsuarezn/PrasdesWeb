package co.gov.ideam.prasdes.utilidades;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.springframework.util.StringUtils;

import co.gov.ideam.prasdes.web.dto.MigracionFormWebDTO;


//@Configurable
//@Qualifier("utilidades")
public class Utilidades {	
	
//	@PostConstruct
//	private void inicializarUtilidades() {
//		dateformatter = new SimpleDateFormat(DATE_PATTERN);
//		timeStampformatter = new SimpleDateFormat(TIMESTAMP_PATTERN);
//	}
	
	

//	@Value("${appconfig.defaultDatePattern}")
	public final static String DATE_PATTERN="dd/MM/yyyy";
		
//	@Value("${appconfig.defaultTimeStampPattern}")
	public final static String TIMESTAMP_PATTERN="dd/MM/yyyy hh:mm:ss";
	
	private final static SimpleDateFormat dateformatter = new SimpleDateFormat(DATE_PATTERN);
	private final static SimpleDateFormat timeStampformatter = new SimpleDateFormat(TIMESTAMP_PATTERN);
		
	public final static String formatearTimestampOFecha(Date fecha){
		try {
			return formatearMarcaTiempo(fecha);
		} catch (Exception e) {
			return formatearFecha(fecha);
		}
	}
	
	public final static String formatearFecha(Date fecha){
		return dateformatter.format(fecha);
	}
	
	public final static String formatearMarcaTiempo(Date fecha){
		return timeStampformatter.format(fecha);
	}
	
	public final static Date parsearTimestampOFecha(String fechastr){
		try {
			return parsearMarcaTiempo(fechastr);
		} catch (ParseException e) {
			try {
				return parsearFecha(fechastr);
			} catch (Exception e2) {
				return null;
			}
		}
	}
	
	public final static Date parsearFechaNoThrow(String fechastr){
		try {
			if(checkHoursOk(fechastr)){
				return parsearMarcaTiempo(fechastr);
			}
			else{
				return parsearFecha(fechastr);
			}			
		} catch (ParseException e) {
			return null;
		}
	}
//	@Test
//	public void testMethod(){
//		assertTrue("ok",checkHoursOk("01:12:55"));
//		assertFalse("ok",checkHoursOk("12/12/2016"));
//		assertTrue("ok",checkHoursOk("12/12/2016 23:12:55"));		
//	}

	
	public final static boolean checkHoursOk(String valor){
		 String regex = "((?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$)";		    
		    try {
		    	Pattern pattern=Pattern.compile(regex);		         
		        Matcher matcher = pattern.matcher(valor);
		           return matcher.find();		        
		    } catch (PatternSyntaxException e) {
		        return false;
		    }		    
	}
	
	public final static Date parsearFecha(String fechastr) throws ParseException{	
			return dateformatter.parse(fechastr);
	}
	
	public final static Date parsearMarcaTiempo(String fechastr)throws ParseException{		
			return timeStampformatter.parse(fechastr);		
	}
	
	public static URI getUri(String serviceUrl){
		URI serviceUri = null;
		try {
			serviceUri = new URI(serviceUrl);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return serviceUri;			
	}
	
	public static MigracionFormWebDTO constructValidUrl(MigracionFormWebDTO dto) throws URISyntaxException{
		if(StringUtils.isEmpty(dto.getServiceUrl())){
			return dto;
		}
		dto.setServiceUrl(dto.getServiceUrl().replace("%", ""));
		URI uri = new URI(dto.getServiceUrl());
		UrlEncodedQueryString queryString = UrlEncodedQueryString.parse(uri);					
		String periodval="";
		if(queryString.contains("r")){	
			if(dto.getIdPeriod()==null){
				queryString.remove("r");				
			}else{
				String idcustomer = queryString.get("r");
				if(("v_r").equalsIgnoreCase(idcustomer)){
					
					switch(dto.getIdPeriod().intValue()){
					case 1: periodval = "i"; break;
					case 2: periodval = "h"; break;
					case 3: periodval = "d"; break;
					case 4: periodval = "m"; break;			
					}			
					if(!periodval.equals("")){
						queryString.set("r", periodval);
					}
					
				}						
			}			
		}
		if(queryString.contains("c")){
			if(dto.getIdCustomer()==null){							
				queryString.remove("c");	
			}else{
				String idcustomer = queryString.get("c");
				if(("v_c").equalsIgnoreCase(idcustomer)){
					queryString.set("c", dto.getIdCustomer());
				}	
			}
		}
		if(queryString.contains("fi")){
			if(dto.getSfechaInicio()==null){
				queryString.remove("fi");	
			}else{
				queryString.set("fi", dto.getSfechaInicio());
			}
		}
		if(queryString.contains("fi")){
			if(dto.getSfechaInicio()==null){
				queryString.remove("fi");	
			}else{
				queryString.set("fi", dto.getSfechaInicio());
			}
		}
		if(queryString.contains("ff")){
			if(dto.getSfechaFin()==null){
				queryString.remove("ff");	
			}else{
				queryString.set("ff", dto.getSfechaFin());
			}
		}
		if(queryString.contains("e")){
			if(dto.getIdEstacion()==null){
				queryString.remove("e");	
			}else{
				queryString.set("e", dto.getIdEstacion());
			}
		}
		if(queryString.contains("v")){
			if(dto.getIdVariable()==null){
				if(dto.getIdStrVariable()==null){
					queryString.remove("v");	
				}
				else{
					queryString.set("v", dto.getIdStrVariable());
				}
			}else{
				queryString.set("v", dto.getIdVariable());
			}
		}		
		uri = queryString.apply(uri);		
		dto.setServiceUrl(uri.toString());
//		System.out.println("serviceUri:"+dto.getServiceUrl());
		return dto;
	}
	
	
		
	
	
}
