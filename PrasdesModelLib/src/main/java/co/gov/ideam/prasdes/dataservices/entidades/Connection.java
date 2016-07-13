package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GRDTBP_CONNECTION database table.
 * 
 */
@Entity
@Table(name="GRDTBP_CONNECTION")
@NamedQuery(name="Connection.findActiveConnections", query="SELECT NEW co.gov.ideam.prasdes.web.dto.ConnectionDTO(cn.id.vIdcustomer,c.nIdcountry,c.vNameCountry,p.nIdperiod,p.vNamePeriod,cn.vTablesource,cn.vUrl, cl.vNameCustomer, cl.vNameResponsible) "
		+ "FROM Connection cn, Period p, Country c, Customerwebserv cl "
		+ "WHERE cn.id.nIdcountry = c.nIdcountry and cn.id.nIdperiod = p.nIdperiod and cn.id.vIdcustomer = cl.vIdcustomer")
public class Connection implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConnectionPK id;

	@Column(name="V_TABLESTORE")
	private String vTablesource;

	@Column(name="V_URL")
	private String vUrl;

	public Connection() {
	}

	public ConnectionPK getId() {
		return this.id;
	}

	public void setId(ConnectionPK id) {
		this.id = id;
	}

	public String getVTablesource() {
		return this.vTablesource;
	}

	public void setVTablesource(String vTablesource) {
		this.vTablesource = vTablesource;
	}

	public String getVUrl() {
		return this.vUrl;
	}

	public void setVUrl(String vUrl) {
		this.vUrl = vUrl;
	}

}