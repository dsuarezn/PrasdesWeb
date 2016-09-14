package co.gov.ideam.prasdes.utilidades;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import co.gov.ideam.prasdes.web.dto.MigracionFormWebDTO;



//@Configurable
//@Qualifier("utilidades")
public class Utilidades {	
	
	static final Logger logger = LogManager.getLogger(Utilidades.class.getName());
	
//	@PostConstruct
//	private void inicializarUtilidades() {
//		dateformatter = new SimpleDateFormat(DATE_PATTERN);
//		timeStampformatter = new SimpleDateFormat(TIMESTAMP_PATTERN);
//	}
	
	

//	@Value("${appconfig.defaultDatePattern}")
	public final static String DATE_PATTERN="dd/MM/yyyy";
		
	public final static String DATE_PATTERN_MATCHER="(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";	
	public final static String TIMESTAMP_PATTERN_MATCHER = "(^(((0[1-9]|[12]\\d|3[01])[\\/\\.-](0[13578]|1[02])[\\/\\.-]((19|[2-9]\\d)\\d{2})\\s(0[0-9]|1[0-2]):(0[0-9]|[1-59]\\d):(0[0-9]|[1-59]\\d)\\s(AM|am|PM|pm))|((0[1-9]|[12]\\d|30)[\\/\\.-](0[13456789]|1[012])[\\/\\.-]((19|[2-9]\\d)\\d{2})\\s(0[0-9]|1[0-2]):(0[0-9]|[1-59]\\d):(0[0-9]|[1-59]\\d)\\s(AM|am|PM|pm))|((0[1-9]|1\\d|2[0-8])[\\/\\.-](02)[\\/\\.-]((19|[2-9]\\d)\\d{2})\\s(0[0-9]|1[0-2]):(0[0-9]|[1-59]\\d):(0[0-9]|[1-59]\\d)\\s(AM|am|PM|pm))|((29)[\\/\\.-](02)[\\/\\.-]((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))\\s(0[0-9]|1[0-2]):(0[0-9]|[1-59]\\d):(0[0-9]|[1-59]\\d)\\s(AM|am|PM|pm)))$)";
	public final static String TIMESTAMP_PATTERN_HHMATCHER = "(^([1-9]|([012][0-9])|(3[01]))\\/([0]{0,1}[1-9]|1[012])\\/\\d\\d\\d\\d [012]{0,1}[0-9]:[0-6][0-9]:[0-6][0-9]$)";
//	@Value("${appconfig.defaultTimeStampPattern}")
	public final static String TIMESTAMP_PATTERN="dd/MM/yyyy hh:mm:ss a";
	public final static String TIMESTAMP_PATTERN_HH="dd/MM/yyyy HH:mm:ss";
	
	private final static SimpleDateFormat dateformatter = new SimpleDateFormat(DATE_PATTERN);
	private final static SimpleDateFormat timeStampformatter = new SimpleDateFormat(TIMESTAMP_PATTERN);
	private final static SimpleDateFormat timeStampformatterHh = new SimpleDateFormat(TIMESTAMP_PATTERN_HH);
		
	public final static String formatearTimestampOFecha(Date fecha){
		try {
			String data= formatearMarcaTiempo(fecha);
			return data;
		} catch (Exception e) {
			String data2 = formatearFecha(fecha);
			return data2;
		}
	}
	
	public final static String formatearFecha(Date fecha){
		return dateformatter.format(fecha);
	}
	
	public final static String formatearMarcaTiempo(Date fecha){
		return timeStampformatterHh.format(fecha);
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
	
	public final static Date parsearMarcaTiempoHh(String fechastr) throws ParseException{		
			return timeStampformatterHh.parse(fechastr);
		
	}
	
	public Date getFormatedDate(String fechastr) throws ParseException {		
		boolean estime=fechastr.matches(Utilidades.TIMESTAMP_PATTERN_MATCHER);
		boolean esdate=fechastr.matches(Utilidades.DATE_PATTERN_MATCHER);
		boolean estimehh=fechastr.matches(Utilidades.TIMESTAMP_PATTERN_HHMATCHER);
		if(estime){
			return (StringUtils.isEmpty(fechastr) ? null : parsearMarcaTiempo(fechastr));
		}
		else if(esdate){
			return (StringUtils.isEmpty(fechastr) ? null : parsearFecha(fechastr));	
		}			
		else if(estimehh){
			return (StringUtils.isEmpty(fechastr) ? null : parsearMarcaTiempoHh(fechastr));	
		}
		return null;
	}
	
	
	public final static Date parsearFechaNoThrow(String fechastr){	
		try {
			boolean estime=fechastr.matches(Utilidades.TIMESTAMP_PATTERN_MATCHER);
			boolean esdate=fechastr.matches(Utilidades.DATE_PATTERN_MATCHER);
			boolean estimehh=fechastr.matches(Utilidades.TIMESTAMP_PATTERN_HHMATCHER);
			if(estime){
				return (StringUtils.isEmpty(fechastr) ? null : parsearMarcaTiempo(fechastr));
			}
			else if(esdate){
				return (StringUtils.isEmpty(fechastr) ? null : parsearFecha(fechastr));	
			}			
			else if(estimehh){
				return (StringUtils.isEmpty(fechastr) ? null : parsearMarcaTiempoHh(fechastr));	
			}
		} catch (ParseException e) {
			return null;
		}
		return null;			
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
		System.out.println("serviceUri:"+dto.getServiceUrl());
		return dto;
	}
	
	
		
	
	
}
