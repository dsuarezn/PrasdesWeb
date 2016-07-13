package co.gov.ideam.prasdes.web.dto;

public class ScheduledMigTaskDTO extends ConnectionDTO{

	private String expresion;
	
	private Long idStation;
	
	private Long idCountry;
	
	private Long idPeriod;
	
	private String idCustomer;
	
	private Long idVariable;
	
	private String mensajeError;

	private String serviceUrl;
	
	private Long noDays;
	
	
	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public Long getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Long idCountry) {
		this.idCountry = idCountry;
	}

	public String getExpresion() {
		return expresion;
	}

	public void setExpresion(String expresion) {
		this.expresion = expresion;
	}

	

	public Long getIdPeriod() {
		return idPeriod;
	}

	public void setIdPeriod(Long idPeriod) {
		this.idPeriod = idPeriod;
	}

	public Long getIdStation() {
		return idStation;
	}

	public void setIdStation(Long idStation) {
		this.idStation = idStation;
	}

	public String getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Long getIdVariable() {
		return idVariable;
	}

	public void setIdVariable(Long idVariable) {
		this.idVariable = idVariable;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public Long getNoDays() {
		return noDays;
	}

	public void setNoDays(Long noDays) {
		this.noDays = noDays;
	}


	
	
}
