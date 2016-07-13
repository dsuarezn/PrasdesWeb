package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GRDMVD_MONTHLYDATA database table.
 * 
 */
@Entity
@Table(name="GRDMVD_MONTHLYDATA")
@NamedQueries({
	@NamedQuery(name="Monthlydata.findAll", query="SELECT g FROM Monthlydata g"),	
	@NamedQuery(name="Monthlydata.findByParametersToConsulta", 
	query="SELECT NEW co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO(md.id.nIdstation, md.id.nIdvar, md.id.dDatadate, md.id.nIdsource, md.nData, md.nIdqc, md.nIdflag, md.nIduser, md.dDateadd) "
			+ "FROM Monthlydata md, Customerwebserv cws, Customerstationvar csv "
			+ "WHERE cws.vIdcustomer = :pCodCliente "					
			+ "and cws.vIdcustomer = csv.id.vIdcustomer "
			+ "and (md.id.nIdstation = :pIdEstacion or :pIdEstacion is null) "
			+ "and md.id.nIdstation = csv.id.nIdstation "
			+ "and (md.id.nIdvar = :pIdVariable or :pIdVariable is null) "
			+ "and md.id.nIdvar = csv.id.nIdvar "
			+ "and ("
			+ "(md.id.dDatadate between :pFechaIni and :pFechaFin and :pFechaIni is not null and :pFechaFin is not null) "
			+ "or (:pFechaIni is null and md.id.dDatadate <= :pFechaFin and :pFechaFin is not null) "
			+ "or (:pFechaFin is null and md.id.dDatadate >= :pFechaIni and :pFechaIni is not null) "
			+ "or (:pFechaFin is null and :pFechaIni is null)) "
			+ "and md.id.dDatadate <= CURRENT_DATE")
})
public class Monthlydata implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MonthlydataPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="D_DATEADD")
	private Date dDateadd;

	@Column(name="N_DATA")
	private BigDecimal nData;

	@Column(name="N_IDFLAG")
	private Long nIdflag;

	@Column(name="N_IDQC")
	private Long nIdqc;

	@Column(name="N_IDUSER")
	private Long nIduser;

	public Monthlydata() {
	}

	public MonthlydataPK getId() {
		return this.id;
	}

	public void setId(MonthlydataPK id) {
		this.id = id;
	}

	public Date getDDateadd() {
		return this.dDateadd;
	}

	public void setDDateadd(Date dDateadd) {
		this.dDateadd = dDateadd;
	}

	public BigDecimal getNData() {
		return this.nData;
	}

	public void setNData(BigDecimal nData) {
		this.nData = nData;
	}

	public Long getNIdflag() {
		return this.nIdflag;
	}

	public void setNIdflag(Long nIdflag) {
		this.nIdflag = nIdflag;
	}

	public Long getNIdqc() {
		return this.nIdqc;
	}

	public void setNIdqc(Long nIdqc) {
		this.nIdqc = nIdqc;
	}

	public Long getNIduser() {
		return this.nIduser;
	}

	public void setNIduser(Long nIduser) {
		this.nIduser = nIduser;
	}

}