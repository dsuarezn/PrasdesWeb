package co.gov.ideam.sshm.web.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaRestFormDTO {

	private Long idEstacion;
	private String idVariable;
	private String idCustomer;
	private String sfechaInicio;
	private String sfechaFin;
	private Date fechaInicio;
	private Date fechaFin;
	private Long idPeriod;
	
		
	static final Logger logger = LogManager.getLogger(ConsultaRestFormDTO.class.getName());
	
	
	
	public ConsultaRestFormDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ConsultaRestFormDTO(Long idEstacion, String idVariable, String idCustomer, String sfechaInicio,
			String sfechaFin, Long idPeriod) {
		super();
		this.setIdEstacion(idEstacion);
		this.setIdVariable(idVariable);
		this.setIdCustomer(idCustomer);
		this.setSfechaInicio(sfechaInicio);
		this.setSfechaFin(sfechaFin);
		this.setIdPeriod(idPeriod);
	}


	public Long getIdPeriod() {
		return idPeriod;
	}


	public void setIdPeriod(Long idPeriod) {
		this.idPeriod = idPeriod;
	}


	public Long getIdEstacion() {
		return idEstacion;
	}


	public void setIdEstacion(Long idEstacion) {
		this.idEstacion = idEstacion;
	}


	public String getIdVariable() {
		return idVariable;
	}


	public void setIdVariable(String idVariable) {
		this.idVariable = idVariable;
	}


	public String getIdCustomer() {
		return idCustomer;
	}


	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
		
	}


	public String getSfechaInicio() {
		return sfechaInicio;
	}


	public void setSfechaInicio(String sfechaInicio){
		this.sfechaInicio = sfechaInicio;
		fechaInicio = parseFecha(sfechaInicio);
	}


	public String getSfechaFin() {
		return sfechaFin;
	}


	public void setSfechaFin(String sfechaFin){
		this.sfechaFin = sfechaFin;
		fechaFin = parseFecha(sfechaFin);
	}


	
	
	private Date parseFecha(String fecha) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			if(StringUtils.isEmpty(fecha)){
				return null;
			}
			else {
				return format.parse(fecha);
			}
		} catch (ParseException e) {
			logger.error("Error al intentar parsear fecha");
			e.printStackTrace();
			return null;
		}	
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}


	
	
	
}
