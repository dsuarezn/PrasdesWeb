package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the GRDMAP_CUSTOMERWEBSERV database table.
 * 
 */
@Entity
@Table(name="GRDMAP_CUSTOMERWEBSERV")
@NamedQuery(name="Customerwebserv.findAll", query="SELECT g FROM Customerwebserv g")
public class Customerwebserv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="V_IDCUSTOMER")
	private String vIdcustomer;

	@Column(name="N_IDCOUNTRY")
	private BigDecimal nIdcountry;



	@Column(name="V_EMAIL_RESPONSIBLE")
	private String vEmailResponsible;

	@Column(name="V_IP_CUSTOMER")
	private String vIpCustomer;

	@Column(name="V_NAME_CUSTOMER")
	private String vNameCustomer;

	@Column(name="V_NAME_CUSTOMERS")
	private String vNameCustomers;

	@Column(name="V_NAME_RESPONSIBLE")
	private String vNameResponsible;

	@Column(name="V_PHONE_RESPONSIBLE")
	private String vPhoneResponsible;

	public Customerwebserv() {
	}

	public String getVIdcustomer() {
		return this.vIdcustomer;
	}

	public void setVIdcustomer(String vIdcustomer) {
		this.vIdcustomer = vIdcustomer;
	}

	public BigDecimal getNIdcountry() {
		return this.nIdcountry;
	}

	public void setNIdcountry(BigDecimal nIdcountry) {
		this.nIdcountry = nIdcountry;
	}

	
	public String getVEmailResponsible() {
		return this.vEmailResponsible;
	}

	public void setVEmailResponsible(String vEmailResponsible) {
		this.vEmailResponsible = vEmailResponsible;
	}

	public String getVIpCustomer() {
		return this.vIpCustomer;
	}

	public void setVIpCustomer(String vIpCustomer) {
		this.vIpCustomer = vIpCustomer;
	}

	public String getVNameCustomer() {
		return this.vNameCustomer;
	}

	public void setVNameCustomer(String vNameCustomer) {
		this.vNameCustomer = vNameCustomer;
	}

	public String getVNameCustomers() {
		return this.vNameCustomers;
	}

	public void setVNameCustomers(String vNameCustomers) {
		this.vNameCustomers = vNameCustomers;
	}

	public String getVNameResponsible() {
		return this.vNameResponsible;
	}

	public void setVNameResponsible(String vNameResponsible) {
		this.vNameResponsible = vNameResponsible;
	}

	public String getVPhoneResponsible() {
		return this.vPhoneResponsible;
	}

	public void setVPhoneResponsible(String vPhoneResponsible) {
		this.vPhoneResponsible = vPhoneResponsible;
	}

}