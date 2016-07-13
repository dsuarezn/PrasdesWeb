package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GRDTBP_CONNECTION database table.
 * 
 */
@Embeddable
public class ConnectionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="V_IDCUSTOMER")
	private String vIdcustomer;

	@Column(name="N_IDCOUNTRY")
	private long nIdcountry;

	@Column(name="N_IDPERIOD")
	private long nIdperiod;

	public ConnectionPK() {
	}
	public String getVIdcustomer() {
		return this.vIdcustomer;
	}
	public void setVIdcustomer(String vIdcustomer) {
		this.vIdcustomer = vIdcustomer;
	}
	public long getNIdcountry() {
		return this.nIdcountry;
	}
	public void setNIdcountry(long nIdcountry) {
		this.nIdcountry = nIdcountry;
	}
	public long getNIdperiod() {
		return this.nIdperiod;
	}
	public void setNIdperiod(long nIdperiod) {
		this.nIdperiod = nIdperiod;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConnectionPK)) {
			return false;
		}
		ConnectionPK castOther = (ConnectionPK)other;
		return 
			this.vIdcustomer.equals(castOther.vIdcustomer)
			&& (this.nIdcountry == castOther.nIdcountry)
			&& (this.nIdperiod == castOther.nIdperiod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.vIdcustomer.hashCode();
		hash = hash * prime + ((int) (this.nIdcountry ^ (this.nIdcountry >>> 32)));
		hash = hash * prime + ((int) (this.nIdperiod ^ (this.nIdperiod >>> 32)));
		
		return hash;
	}
}