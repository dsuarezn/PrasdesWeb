package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GRDMVD_CUSTOMERSTATIONVAR database table.
 * 
 */
@Entity
@Table(name="GRDMVD_CUSTOMERSTATIONVAR")
//@NamedQuery(name="Customerstationvar.findAll", query="SELECT g FROM Customerstationvar g")
@NamedQuery(name="Customerstationvar.findAll", query="SELECT NEW co.gov.ideam.prasdes.web.dto.CustomerStationVarDTO(g.id.vIdcustomer, g.id.nIdstation, g.id.nIdvar, s.vNameStation, v.vNameVar, w.vNameCustomer) "
		+ "FROM Customerstationvar g, Station s, Variable v, Customerwebserv w "
		+ "WHERE g.id.nIdstation = s.nIdstation AND g.id.nIdvar = v.nIdvar AND g.id.vIdcustomer = w.vIdcustomer")
public class Customerstationvar implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	
	@EmbeddedId
	private CustomerstationvarPK id;

	public Customerstationvar() {
	}

	public CustomerstationvarPK getId() {
		return this.id;
	}

	public void setId(CustomerstationvarPK id) {
		this.id = id;
	}

}