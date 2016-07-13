package co.gov.ideam.prasdes.web.dto;

import co.gov.ideam.prasdes.dataservices.entidades.MigTask;

public class MigTaskDTO {
	
	public MigTaskDTO() {
		
	}
	
	public MigTaskDTO(Long nTaskId, Long nIdperiod, long nUrlIdCountry, String vUrl, String vExpresion,
			String vNamePeriod, String vNameCountry, String vIdcustomer, 
			String vNameStation, String vNameVar, Long nCantidadDias, MigTask innerTask) {
		super();
		this.nTaskId = nTaskId;
		this.nIdperiod = nIdperiod;
		this.nUrlIdCountry = nUrlIdCountry;
		this.vUrl = vUrl;
		this.vExpresion = vExpresion;
		this.vNamePeriod = vNamePeriod;
		this.vNameCountry = vNameCountry;
		this.vIdcustomer = vIdcustomer;
		this.nCantidadDias=nCantidadDias;
		this.innerTask = innerTask;
	}

	private MigTask innerTask;
	
	private Long nCantidadDias;
	
	private String vNameStation; 
	
	private String vNameVar;
	
	private Long nTaskId;
		
	private Long nIdperiod;
		
	private long nUrlIdCountry;
	
	private String vUrl;
	
	private String vExpresion;
	
	private String vNamePeriod;
	
	private String vNameCountry;
	
	private String vIdcustomer;
	
	

	public MigTask getInnerTask() {
		return innerTask;
	}

	public void setInnerTask(MigTask innerTask) {
		this.innerTask = innerTask;
	}

	public Long getnCantidadDias() {
		return nCantidadDias;
	}

	public void setnCantidadDias(Long nCantidadDias) {
		this.nCantidadDias = nCantidadDias;
	}

	public String getvIdcustomer() {
		return vIdcustomer;
	}

	public void setvIdcustomer(String vIdcustomer) {
		this.vIdcustomer = vIdcustomer;
	}

	public Long getnTaskId() {
		return nTaskId;
	}

	public void setnTaskId(Long nTaskId) {
		this.nTaskId = nTaskId;
	}

	public Long getnIdperiod() {
		return nIdperiod;
	}

	public void setnIdperiod(Long nIdperiod) {
		this.nIdperiod = nIdperiod;
	}

	public long getnUrlIdCountry() {
		return nUrlIdCountry;
	}

	public void setnUrlIdCountry(long nUrlIdCountry) {
		this.nUrlIdCountry = nUrlIdCountry;
	}

	public String getvUrl() {
		return vUrl;
	}

	public void setvUrl(String vUrl) {
		this.vUrl = vUrl;
	}

	public String getvExpresion() {
		return vExpresion;
	}

	public void setvExpresion(String vExpresion) {
		this.vExpresion = vExpresion;
	}

	public String getvNamePeriod() {
		return vNamePeriod;
	}

	public void setvNamePeriod(String vNamePeriod) {
		this.vNamePeriod = vNamePeriod;
	}

	public String getvNameCountry() {
		return vNameCountry;
	}

	public void setvNameCountry(String vNameCountry) {
		this.vNameCountry = vNameCountry;
	}
	
	

	public String getvNameStation() {
		return vNameStation;
	}

	public void setvNameStation(String vNameStation) {
		this.vNameStation = vNameStation;
	}

	public String getvNameVar() {
		return vNameVar;
	}

	public void setvNameVar(String vNameVar) {
		this.vNameVar = vNameVar;
	}
	
	
	
	
}
