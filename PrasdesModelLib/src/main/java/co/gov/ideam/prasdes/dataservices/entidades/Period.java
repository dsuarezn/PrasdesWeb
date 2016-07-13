package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GRDTBP_PERIOD database table.
 * 
 */
@Entity
@Table(name="GRDTBP_PERIOD")
@NamedQuery(name="Period.findAll", query="SELECT g FROM Period g")
public class Period implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="N_IDPERIOD")
	private Long nIdperiod;

	@Column(name="V_NAME_PERIOD")
	private String vNamePeriod;

	public Period() {
	}

	public Long getNIdperiod() {
		return this.nIdperiod;
	}

	public void setNIdperiod(Long nIdperiod) {
		this.nIdperiod = nIdperiod;
	}

	public String getVNamePeriod() {
		return this.vNamePeriod;
	}

	public void setVNamePeriod(String vNamePeriod) {
		this.vNamePeriod = vNamePeriod;
	}

}