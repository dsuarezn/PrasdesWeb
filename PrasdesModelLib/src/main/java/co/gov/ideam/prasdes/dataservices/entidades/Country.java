package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GRDTBP_COUNTRY database table.
 * 
 */
@Entity
@Table(name="GRDTBP_COUNTRY")
@NamedQuery(name="Country.findAll", query="SELECT g FROM Country g")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="N_IDCOUNTRY")
	private Long nIdcountry;

	@Column(name="V_NAME_COUNTRY")
	private String vNameCountry;

	public Country() {

	}	
	public Country(Long nIdcountry, String vNameCountry) {
		super();
		this.nIdcountry = nIdcountry;
		this.vNameCountry = vNameCountry;
	}



	public Long getNIdcountry() {
		return this.nIdcountry;
	}

	public void setNIdcountry(Long nIdcountry) {
		this.nIdcountry = nIdcountry;
	}

	public String getVNameCountry() {
		return this.vNameCountry;
	}

	public void setVNameCountry(String vNameCountry) {
		this.vNameCountry = vNameCountry;
	}

}