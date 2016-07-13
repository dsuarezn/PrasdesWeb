package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GRDMVD_RAWDATA database table.
 * 
 */
@Entity
@Table(name="GRDMVD_RAWDATA")
@NamedQueries({
	@NamedQuery(name="Rawdata.findAll", query="SELECT r FROM Rawdata r"),
	@NamedQuery(name="Rawdata.findByParametersToConsulta", 
	query="SELECT NEW co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO(rd.id.nIdstation, rd.id.nIdvar, rd.id.dDatadate, rd.id.nIdsource, rd.nData, rd.nIdqc, rd.nIdflag, rd.nIduser, rd.dDateadd, rd.id.nIdperiod) "
			+ "FROM Rawdata rd, Customerwebserv cws, Customerstationvar csv "
			+ "WHERE cws.vIdcustomer = :pCodCliente "
			+ "and cws.vIdcustomer = csv.id.vIdcustomer "
			+ "and (rd.id.nIdstation = :pIdEstacion or :pIdEstacion is null) "
			+ "and rd.id.nIdstation = csv.id.nIdstation "
			+ "and (rd.id.nIdvar = :pIdVariable or :pIdVariable is null) "
			+ "and rd.id.nIdvar = csv.id.nIdvar "
			+ "and rd.id.nIdperiod = :pIdperiod "
			+ "and ("
			+ "(rd.id.dDatadate between :pFechaIni and :pFechaFin and :pFechaIni is not null and :pFechaFin is not null) "
			+ "or (:pFechaIni is null and rd.id.dDatadate <= :pFechaFin and :pFechaFin is not null) "			
			+ "or (:pFechaFin is null and rd.id.dDatadate >= :pFechaIni and :pFechaIni is not null) "
			+ "or (:pFechaFin is null and :pFechaIni is null)) "
			+ "and rd.id.dDatadate <= CURRENT_DATE")
})

public class Rawdata implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RawdataPK id;

	@Temporal(TemporalType.DATE)
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

	public Rawdata() {
	}

	public RawdataPK getId() {
		return this.id;
	}

	public void setId(RawdataPK id) {
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