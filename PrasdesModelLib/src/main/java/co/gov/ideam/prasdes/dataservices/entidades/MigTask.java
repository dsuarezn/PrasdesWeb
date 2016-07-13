package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the GRDTBP_MIG_TASKS database table.
 * 
 */
@Entity
@Table(name="GRDTBP_MIG_TASKS")
@NamedQuery(name="MigTask.findAll", query="SELECT NEW co.gov.ideam.prasdes.web.dto.MigTaskDTO(g.nTaskId, g.nIdperiod, g.nUrlIdCountry, g.vUrl, g.vExpresion, p.vNamePeriod, c.vNameCountry, g.vIdcustomer, (SELECT s.vNameStation FROM Station s WHERE s.nIdstation = g.nIdstation), (SELECT v.vNameVar FROM Variable v WHERE v.nIdvar = g.nIdvar), g.nCantidadDias, g) "
		+ "FROM MigTask g, Country c, Period p "
		+ "WHERE g.nIdperiod = p.nIdperiod and g.nUrlIdCountry = c.nIdcountry ")
public class MigTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@SequenceGenerator(name="SEQ_GEN", sequenceName="MIG_TASK_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
	@Column(name="N_TASK_ID")
	private Long nTaskId;
	
	@Column(name="N_IDPERIOD")
	private Long nIdperiod;
	
	@Column(name="N_URL_IDCOUNTRY")
	private long nUrlIdCountry;

	
	@Column(name="V_URL")
	private String vUrl;

	@Column(name="V_EXPRESION")
	private String vExpresion;
	
	@Column(name="V_IDCUSTOMER")
	private String vIdcustomer;
	
	@Column(name="N_IDSTATION")
	private Long nIdstation;
	
	@Column(name="N_IDVAR")
	private Long nIdvar;
	
	@Column(name="N_CANTIDAD_DIAS")
	private Long nCantidadDias;
	
	
	public MigTask(Long nTaskId, Long nIdperiod, long nUrlIdCountry, String vUrl, String vExpresion) {
		super();
		this.nTaskId = nTaskId;
		this.nIdperiod = nIdperiod;
		this.nUrlIdCountry = nUrlIdCountry;
		this.vUrl = vUrl;
		this.vExpresion = vExpresion;
	}

	
	
	public MigTask() {
	}
		
	public MigTask(String expresion) {
		this.vExpresion = expresion;
		
	}
	
	public MigTask(Long keyid) {
		this.nTaskId=keyid;
	}

	
	



	public Long getnTaskId() {
		return nTaskId;
	}



	public void setnTaskId(Long nTaskId) {
		this.nTaskId = nTaskId;
	}



	public String getVExpresion() {
		return this.vExpresion;
	}

	public void setVExpresion(String vExpresion) {
		this.vExpresion = vExpresion;
	}

	public Long getnIdperiod() {
		return nIdperiod;
	}

	public void setnIdperiod(Long nIdperiod) {
		this.nIdperiod = nIdperiod;
	}

	public String getVUrl() {
		return vUrl;
	}

	public void setVUrl(String vUrl) {
		this.vUrl = vUrl;
	}

	public long getnUrlIdCountry() {
		return nUrlIdCountry;
	}

	public void setnUrlIdCountry(long nUrlIdCountry) {
		this.nUrlIdCountry = nUrlIdCountry;
	}

	public String getvIdcustomer() {
		return vIdcustomer;
	}

	public void setvIdcustomer(String vIdcustomer) {
		this.vIdcustomer = vIdcustomer;
	}

	public Long getnIdstation() {
		return nIdstation;
	}

	public void setnIdstation(Long nIdstation) {
		this.nIdstation = nIdstation;
	}

	public Long getnIdvar() {
		return nIdvar;
	}

	public void setnIdvar(Long nIdvar) {
		this.nIdvar = nIdvar;
	}

	public Long getnCantidadDias() {
		return nCantidadDias;
	}

	public void setnCantidadDias(Long nCantidadDias) {
		this.nCantidadDias = nCantidadDias;
	}
	
	
	
	

}