package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GRDMVD_RAWDATA database table.
 * 
 */
@Embeddable
public class RawdataPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="N_IDPERIOD", insertable=false, updatable=false)
	private long nIdperiod;

	@Column(name="N_IDSTATION")
	private long nIdstation;

	@Column(name="N_IDVAR", insertable=false, updatable=false)
	private long nIdvar;

	@Temporal(TemporalType.DATE)
	@Column(name="D_DATADATE")
	private java.util.Date dDatadate;

	@Column(name="N_IDSOURCE", insertable=false, updatable=false)
	private long nIdsource;

	public RawdataPK() {
	}
	public long getNIdperiod() {
		return this.nIdperiod;
	}
	public void setNIdperiod(long nIdperiod) {
		this.nIdperiod = nIdperiod;
	}
	public long getNIdstation() {
		return this.nIdstation;
	}
	public void setNIdstation(long nIdstation) {
		this.nIdstation = nIdstation;
	}
	public long getNIdvar() {
		return this.nIdvar;
	}
	public void setNIdvar(long nIdvar) {
		this.nIdvar = nIdvar;
	}
	public java.util.Date getDDatadate() {
		return this.dDatadate;
	}
	public void setDDatadate(java.util.Date dDatadate) {
		this.dDatadate = dDatadate;
	}
	public long getNIdsource() {
		return this.nIdsource;
	}
	public void setNIdsource(long nIdsource) {
		this.nIdsource = nIdsource;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RawdataPK)) {
			return false;
		}
		RawdataPK castOther = (RawdataPK)other;
		return 
			(this.nIdperiod == castOther.nIdperiod)
			&& (this.nIdstation == castOther.nIdstation)
			&& (this.nIdvar == castOther.nIdvar)
			&& this.dDatadate.equals(castOther.dDatadate)
			&& (this.nIdsource == castOther.nIdsource);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.nIdperiod ^ (this.nIdperiod >>> 32)));
		hash = hash * prime + ((int) (this.nIdstation ^ (this.nIdstation >>> 32)));
		hash = hash * prime + ((int) (this.nIdvar ^ (this.nIdvar >>> 32)));
		hash = hash * prime + this.dDatadate.hashCode();
		hash = hash * prime + ((int) (this.nIdsource ^ (this.nIdsource >>> 32)));
		
		return hash;
	}
}