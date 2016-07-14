package co.gov.ideam.sshm.web.dto;


import java.math.BigDecimal;
import java.util.Date;

import org.dozer.Mapping;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

import co.gov.ideam.sshm.utilidades.Utilidades;



//@JsonFormat(shape=JsonFormat.Shape.ARRAY)
//@JsonPropertyOrder({ "nIdstation", "nIdvar", "dDatadate", "nIdsource", "nData", "nIdqc", "nIdflag", "nIduser", "dDateadd" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaResponseDTO {
	
	public ConsultaResponseDTO(Long idStation, String idVariable, Date datadate, Long idSource, String data,
			Long idFlag, Long idqc, Long user, Date date, Long idSec) {
		super();	
		this.id = idSec;
		this.idStation = idStation;
		this.idVariable = idVariable;
		this.datadate = datadate;
		this.idSource = idSource;
		this.data = data;
		this.idFlag = idFlag;
		this.idqc = idqc;
		this.user = user;
		this.date = date;
	}
	
	public ConsultaResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Mapping("idSec")	
	private Long id;
	
	@Mapping("id.idstation")	
	private Long idStation;
	
	@Mapping("id.idvariable")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String idVariable;
	
	@Mapping("id.datadate")
	private Date datadate;
		
	@Mapping("id.idsource")	
	private Long idSource;	
	
	@Mapping("data")
	private String data;
	
	@Mapping("idflag")
	private Long idFlag;
	
	@Mapping("idqc")
	private Long idqc;
	
	@Mapping("user")
	private Long user;
	
	@Mapping("date")
	private Date date;
	
	
	
	@JsonGetter("id")
	public Long getId() {
		return id;
	}

	@JsonSetter("id")	
	public void setId(Long id) {
		this.id = id;
	}

	@JsonGetter("idStation")
	public Long getIdStation() {
		return idStation;
	}

	@JsonSetter("idStation")
	public void setIdStation(Long idStation) {
		this.idStation = idStation;
	}

	@JsonGetter("idVariable")
	public String getIdVariable() {
		return idVariable;
	}

	@JsonSetter("idVariable")
	public void setIdVariable(String idVariable) {
		this.idVariable = idVariable;
	}

	@JsonGetter("idSource")
	public Long getIdSource() {
		return idSource;
	}
	
	@JsonSetter("idSource")
	public void setIdSource(Long idSource) {
		this.idSource = idSource;
	}

	@JsonGetter("data")
	public String getData() {
		return data;
	}

	@JsonSetter("data")
	public void setData(String data) {
		this.data = data;
	}

	@JsonGetter("idFlag")
	public Long getIdFlag() {
		return idFlag;
	}

	@JsonSetter("idFlag")
	public void setIdFlag(Long idFlag) {
		this.idFlag = idFlag;
	}

	@JsonGetter("idqc")
	public Long getIdqc() {
		return idqc;
	}

	@JsonSetter("idqc")
	public void setIdqc(Long idqc) {
		this.idqc = idqc;
	}

	@JsonGetter("user")
	public Long getUser() {
		return user;
	}

	@JsonSetter("user")
	public void setUser(Long user) {
		this.user = user;
	}

	@JsonGetter("datadate")
	public String getDatadate() {		
		return (datadate!=null ? Utilidades.formatearFecha(datadate) : null) ;
	}
	
	public Date getDateDatadate() {		
		return datadate;
	}
	
	@JsonSetter("datadate")
	public void setDatadate(String fechastr) {		
		boolean estime=fechastr.matches(Utilidades.TIMESTAMP_PATTERN_MATCHER);
		boolean esdate=fechastr.matches(Utilidades.DATE_PATTERN_MATCHER);
		if(estime){
			this.datadate = (StringUtils.isEmpty(fechastr) ? null : Utilidades.parsearMarcaTiempo(fechastr));
		}
		else if(esdate){
			this.datadate = (StringUtils.isEmpty(fechastr) ? null : Utilidades.parsearFecha(fechastr));	
		}			
	}
	
	@JsonGetter("date")
	public String getDate() {		
		return (date!=null ? Utilidades.formatearFecha(date) : null) ;
	}
	
	@JsonSetter("date")
	public void setDate(String fechastr) {						
		boolean estime=fechastr.matches(Utilidades.TIMESTAMP_PATTERN_MATCHER);
		boolean esdate=fechastr.matches(Utilidades.DATE_PATTERN_MATCHER);
		if(estime){
			this.date = (StringUtils.isEmpty(fechastr) ? null : Utilidades.parsearMarcaTiempo(fechastr));
		}
		else if(esdate){
			this.date = (StringUtils.isEmpty(fechastr) ? null : Utilidades.parsearFecha(fechastr));	
		}		
		
	}

		
	
}
