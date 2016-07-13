package co.gov.ideam.prasdes.web.dto;

import co.gov.ideam.prasdes.dataservices.entidades.Customerstationvar;
import co.gov.ideam.prasdes.dataservices.entidades.CustomerstationvarPK;

public class CustomerStationVarDTO {
		
	private String vIdcustomer;

	private Long nIdstation;

	private Long nIdvar;
	
	private String nombreEstacion;
	
	private String nombreVariable;
	
	private String nombreCustomer;


	
	

	public CustomerStationVarDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerStationVarDTO(String vIdcustomer, Long nIdstation, Long nIdvar, String nombreEstacion,
			String nombreVariable, String nombreCustomer) {
		super();
		this.vIdcustomer = vIdcustomer;
		this.nIdstation = nIdstation;
		this.nIdvar = nIdvar;
		this.nombreEstacion = nombreEstacion;
		this.nombreVariable = nombreVariable;
		this.nombreCustomer = nombreCustomer;
	}

	public String getNombreCustomer() {
		return nombreCustomer;
	}

	public void setNombreCustomer(String nombreCustomer) {
		this.nombreCustomer = nombreCustomer;
	}

	public String getvIdcustomer() {
		return vIdcustomer;
	}

	public void setvIdcustomer(String vIdcustomer) {
		this.vIdcustomer = vIdcustomer;
	}

	public Long getnIdstation() {
		return nIdstation;
	}

	public void setnIdstation(Long nIdstation) {
		this.nIdstation = nIdstation;
	}

	public Long getnIdvar() {
		return nIdvar;
	}

	public void setnIdvar(Long nIdvar) {
		this.nIdvar = nIdvar;
	}

	public String getNombreEstacion() {
		return nombreEstacion;
	}

	public void setNombreEstacion(String nombreEstacion) {
		this.nombreEstacion = nombreEstacion;
	}

	public String getNombreVariable() {
		return nombreVariable;
	}

	public void setNombreVariable(String nombreVariable) {
		this.nombreVariable = nombreVariable;
	}
	
	public Customerstationvar getCustomerStationVar(){
		CustomerstationvarPK pk = new CustomerstationvarPK();
		pk.setNIdstation(nIdstation);
		pk.setNIdvar(nIdvar);
		pk.setVIdcustomer(vIdcustomer);
		Customerstationvar cstationvar=new Customerstationvar();
		cstationvar.setId(pk);
		return cstationvar;
	}
	
	
	
}
