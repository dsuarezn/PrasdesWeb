package co.gov.ideam.sshm.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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
	
	public final static String DATE_PATTERN_MATCHER="(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";	
	public final static String TIMESTAMP_PATTERN_MATCHER = "(^(((0[1-9]|[12]\\d|3[01])[\\/\\.-](0[13578]|1[02])[\\/\\.-]((19|[2-9]\\d)\\d{2})\\s(0[0-9]|1[0-2]):(0[0-9]|[1-59]\\d):(0[0-9]|[1-59]\\d)\\s(AM|am|PM|pm))|((0[1-9]|[12]\\d|30)[\\/\\.-](0[13456789]|1[012])[\\/\\.-]((19|[2-9]\\d)\\d{2})\\s(0[0-9]|1[0-2]):(0[0-9]|[1-59]\\d):(0[0-9]|[1-59]\\d)\\s(AM|am|PM|pm))|((0[1-9]|1\\d|2[0-8])[\\/\\.-](02)[\\/\\.-]((19|[2-9]\\d)\\d{2})\\s(0[0-9]|1[0-2]):(0[0-9]|[1-59]\\d):(0[0-9]|[1-59]\\d)\\s(AM|am|PM|pm))|((29)[\\/\\.-](02)[\\/\\.-]((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))\\s(0[0-9]|1[0-2]):(0[0-9]|[1-59]\\d):(0[0-9]|[1-59]\\d)\\s(AM|am|PM|pm)))$)";
	
//	@Value("${appconfig.defaultTimeStampPattern}")
	public final static String TIMESTAMP_PATTERN="dd/MM/yyyy hh:mm:ss";
	
	private final static SimpleDateFormat dateformatter = new SimpleDateFormat(DATE_PATTERN);
	private final static SimpleDateFormat timeStampformatter = new SimpleDateFormat(TIMESTAMP_PATTERN);
		
	public final static String formatearFecha(Date fecha){
		return dateformatter.format(fecha);
	}
	
	public final static String formatearMarcaTiempo(Date fecha){
		return timeStampformatter.format(fecha);
	}
	
	public final static Date parsearFecha(String fechastr){
		try {
			return dateformatter.parse(fechastr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public final static Date parsearMarcaTiempo(String fechastr){
		try {
			return timeStampformatter.parse(fechastr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
