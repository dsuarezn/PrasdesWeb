package co.gov.ideam.sshm.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GRDTBP_PRASDES_EQUIV database table.
 * 
 */
@Embeddable
public class PrasdesEquivPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="V_TIPO_VAL")
	private String tipoVal;

	@Column(name="V_IDEAM_VAL")
	private String ideamVal;

	@Column(name="V_PRASDES_VAL")
	private String prasdesVal;

	public PrasdesEquivPK() {
	}

	public String getTipoVal() {
		return tipoVal;
	}

	public void setTipoVal(String tipoVal) {
		this.tipoVal = tipoVal;
	}

	public String getIdeamVal() {
		return ideamVal;
	}

	public void setIdeamVal(String ideamVal) {
		this.ideamVal = ideamVal;
	}

	public String getPrasdesVal() {
		return prasdesVal;
	}

	public void setPrasdesVal(String prasdesVal) {
		this.prasdesVal = prasdesVal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ideamVal == null) ? 0 : ideamVal.hashCode());
		result = prime * result + ((prasdesVal == null) ? 0 : prasdesVal.hashCode());
		result = prime * result + ((tipoVal == null) ? 0 : tipoVal.hashCode());
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
		PrasdesEquivPK other = (PrasdesEquivPK) obj;
		if (ideamVal == null) {
			if (other.ideamVal != null)
				return false;
		} else if (!ideamVal.equals(other.ideamVal))
			return false;
		if (prasdesVal == null) {
			if (other.prasdesVal != null)
				return false;
		} else if (!prasdesVal.equals(other.prasdesVal))
			return false;
		if (tipoVal == null) {
			if (other.tipoVal != null)
				return false;
		} else if (!tipoVal.equals(other.tipoVal))
			return false;
		return true;
	}

	
	
}