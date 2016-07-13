package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GRDMVD_CUSTOMERSTATIONVAR database table.
 * 
 */
@Embeddable
public class CustomerstationvarPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="V_IDCUSTOMER")
	private String vIdcustomer;

	@Column(name="N_IDSTATION")
	private Long nIdstation;

	@Column(name="N_IDVAR")
	private long nIdvar;

	public CustomerstationvarPK() {
	}
	public String getVIdcustomer() {
		return this.vIdcustomer;
	}
	public void setVIdcustomer(String vIdcustomer) {
		this.vIdcustomer = vIdcustomer;
	}
	public Long getNIdstation() {
		return this.nIdstation;
	}
	public void setNIdstation(Long nIdstation) {
		this.nIdstation = nIdstation;
	}
	public long getNIdvar() {
		return this.nIdvar;
	}
	public void setNIdvar(long nIdvar) {
		this.nIdvar = nIdvar;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CustomerstationvarPK)) {
			return false;
		}
		CustomerstationvarPK castOther = (CustomerstationvarPK)other;
		return 
			this.vIdcustomer.equals(castOther.vIdcustomer)
			&& (this.nIdstation == castOther.nIdstation)
			&& (this.nIdvar == castOther.nIdvar);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.vIdcustomer.hashCode();
		hash = hash * prime + ((int) (this.nIdstation ^ (this.nIdstation >>> 32)));
		hash = hash * prime + ((int) (this.nIdvar ^ (this.nIdvar >>> 32)));
		
		return hash;
	}
}