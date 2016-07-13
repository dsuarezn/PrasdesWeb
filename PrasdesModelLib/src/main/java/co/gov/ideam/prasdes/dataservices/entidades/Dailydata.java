package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GRDMVD_DAILYDATA database table.
 * 
 */
@Entity
@Table(name="GRDMVD_DAILYDATA")
@NamedQueries({
	@NamedQuery(name="Dailydata.findAll", query="SELECT g FROM Dailydata g"),
	@NamedQuery(name="Dailydata.findByParametersToConsulta", 
			query="SELECT NEW co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO(dd.id.nIdstation, dd.id.nIdvar, dd.id.dDatadate, dd.id.nIdsource, dd.nData, dd.nIdqc, dd.nIdflag, dd.nIduser, dd.dDateadd) "
			+ "FROM Dailydata dd, Customerwebserv cws, Customerstationvar csv "
			+ "WHERE cws.vIdcustomer = :pCodCliente "					
			+ "and cws.vIdcustomer = csv.id.vIdcustomer "
			+ "and (dd.id.nIdstation = :pIdEstacion or :pIdEstacion is null) "
			+ "and dd.id.nIdstation = csv.id.nIdstation "
			+ "and (dd.id.nIdvar = :pIdVariable or :pIdVariable is null) "
			+ "and dd.id.nIdvar = csv.id.nIdvar "
			+ "and ("
			+ "(dd.id.dDatadate between :pFechaIni and :pFechaFin and :pFechaIni is not null and :pFechaFin is not null) "
			+ "or (:pFechaIni is null and dd.id.dDatadate <= :pFechaFin and :pFechaFin is not null) "
			+ "or (:pFechaFin is null and dd.id.dDatadate >= :pFechaIni and :pFechaIni is not null) "
			+ "or (:pFechaFin is null and :pFechaIni is null)) "
			+ "and dd.id.dDatadate <= CURRENT_DATE")
})
public class Dailydata implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DailydataPK id;

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

	public Dailydata() {
	}

	public DailydataPK getId() {
		return this.id;
	}

	public void setId(DailydataPK id) {
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

	@Override
	public String toString() {
		return "Dailydata [id=" + id + ", dDateadd=" + dDateadd + ", nData=" + nData + ", nIdflag=" + nIdflag
				+ ", nIdqc=" + nIdqc + ", nIduser=" + nIduser + "]";
	}

	
	
}