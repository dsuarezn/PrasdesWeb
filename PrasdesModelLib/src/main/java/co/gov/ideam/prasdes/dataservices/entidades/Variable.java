package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the GRDMAP_VARIABLE database table.
 * 
 */
@Entity
@Table(name="GRDMAP_VARIABLE")
@NamedQuery(name="Variable.findAll", query="SELECT g FROM Variable g")
public class Variable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="N_IDVAR")
	private Long nIdvar;

	@Column(name="N_DECIMAL")
	private BigDecimal nDecimal;

	@Column(name="N_IDGROUPVAR")
	private BigDecimal nIdgroupvar;

	@Column(name="N_IDUNIT")
	private BigDecimal nIdunit;

	@Column(name="N_PRESICION")
	private BigDecimal nPresicion;

	@Column(name="V_FORMULA")
	private String vFormula;

	@Column(name="V_NAME_VAR")
	private String vNameVar;

	@Column(name="V_NAME_VARS")
	private String vNameVars;

	public Variable() {
	}

	public long getNIdvar() {
		return this.nIdvar;
	}

	public void setNIdvar(long nIdvar) {
		this.nIdvar = nIdvar;
	}

	public BigDecimal getNDecimal() {
		return this.nDecimal;
	}

	public void setNDecimal(BigDecimal nDecimal) {
		this.nDecimal = nDecimal;
	}

	public BigDecimal getNIdgroupvar() {
		return this.nIdgroupvar;
	}

	public void setNIdgroupvar(BigDecimal nIdgroupvar) {
		this.nIdgroupvar = nIdgroupvar;
	}

	public BigDecimal getNIdunit() {
		return this.nIdunit;
	}

	public void setNIdunit(BigDecimal nIdunit) {
		this.nIdunit = nIdunit;
	}

	public BigDecimal getNPresicion() {
		return this.nPresicion;
	}

	public void setNPresicion(BigDecimal nPresicion) {
		this.nPresicion = nPresicion;
	}

	public String getVFormula() {
		return this.vFormula;
	}

	public void setVFormula(String vFormula) {
		this.vFormula = vFormula;
	}

	public String getVNameVar() {
		return this.vNameVar;
	}

	public void setVNameVar(String vNameVar) {
		this.vNameVar = vNameVar;
	}

	public String getVNameVars() {
		return this.vNameVars;
	}

	public void setVNameVars(String vNameVars) {
		this.vNameVars = vNameVars;
	}

}