package co.gov.ideam.sshm.dataservices.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The primary key class for the GRDMVD_DAILYDATA database table.
 * 
 */
@Embeddable
public class InstantdataPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="INDT_IDSTATION")
	private Long idstation;

	@Column(name="INDT_IDVARIABLE")
	private String idvariable;

	@Temporal(TemporalType.DATE)
	@Column(name="INDT_DATADATE")
	private Date datadate;

	@Column(name="INDT_IDSOURCE")
	private Long idsource;

	public InstantdataPK() {
	}

	public long getIdstation() {
		return idstation;
	}

	public void setIdstation(long idstation) {
		this.idstation = idstation;
	}

	
	public Date getDatadate() {
		return datadate;
	}

	public void setDatadate(Date datadate) {
		this.datadate = datadate;
	}

	public Long getIdsource() {
		return idsource;
	}

	public void setIdsource(Long idsource) {
		this.idsource = idsource;
	}

	public String getIdvariable() {
		return idvariable;
	}

	public void setIdvariable(String idvariable) {
		this.idvariable = idvariable;
	}

	public void setIdstation(Long idstation) {
		this.idstation = idstation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datadate == null) ? 0 : datadate.hashCode());
		result = prime * result + ((idsource == null) ? 0 : idsource.hashCode());
		result = prime * result + ((idstation == null) ? 0 : idstation.hashCode());
		result = prime * result + ((idvariable == null) ? 0 : idvariable.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstantdataPK other = (InstantdataPK) obj;
		if (datadate == null) {
			if (other.datadate != null)
				return false;
		} else if (!datadate.equals(other.datadate))
			return false;
		if (idsource == null) {
			if (other.idsource != null)
				return false;
		} else if (!idsource.equals(other.idsource))
			return false;
		if (idstation == null) {
			if (other.idstation != null)
				return false;
		} else if (!idstation.equals(other.idstation))
			return false;
		if (idvariable == null) {
			if (other.idvariable != null)
				return false;
		} else if (!idvariable.equals(other.idvariable))
			return false;
		return true;
	}


	
	
	
}