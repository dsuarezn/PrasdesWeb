package co.gov.ideam.sshm.dataservices.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import co.gov.ideam.sshm.dataservices.entidades.DailydataPK;

import java.util.Date;


/**
 * The persistent class for the HMST_DAILYDATA database table.
 * 
 */
@Entity
@Table(name="HMST_DAILYDATA")
@NamedQueries({
		@NamedQuery(name="Dailydata.findAll", query="SELECT d FROM Dailydata d"),
		@NamedQuery(name="Dailydata.findByParameters",  
		query="SELECT NEW co.gov.ideam.sshm.web.dto.ConsultaResponseDTO(dd.id.idstation,dd.id.idvariable,dd.id.datadate,dd.id.idsource,dd.data,dd.idflag,dd.idqc,dd.user,dd.date,dd.idSec) "
				+ "FROM Dailydata dd "
				+ "WHERE (dd.id.idvariable = :pIdVariable or :pIdVariable is null) "
				+ "AND (dd.id.idstation = :pIdStation or :pIdStation is null) "
				+ "AND ("
				+ "(dd.id.datadate between :pfechaIni and :pfechafin and :pfechaIni is not null and :pfechafin is not null) "
				+ "OR (:pfechaIni is null and dd.id.datadate <= :pfechafin and :pfechafin is not null) "
				+ "OR (:pfechafin is null and dd.id.datadate >= :pfechaIni and :pfechaIni is not null) "
				+ "OR (:pfechafin is null and :pfechaIni is null))"),
		@NamedQuery(name="Dailydata.findByParametersPrasdes",  
		query="SELECT NEW co.gov.ideam.sshm.web.dto.ConsultaResponseDTO(dd.id.idstation,dd.id.idvariable,dd.id.datadate,dd.id.idsource,dd.data,dd.idflag,dd.idqc,dd.user,dd.date,dd.idSec) "
				+ "FROM Dailydata dd, PrasdesEquiv pe, PrasdesEquiv pv, PrasdesEquiv pq "
				+ "WHERE (dd.id.idvariable = :pIdVariable or :pIdVariable is null) "
				+ "AND dd.id.idstation = cast(pe.id.ideamVal as long) "
				+ "AND dd.idqc = cast(pq.id.ideamVal as long) "
				+ "AND dd.id.idvariable = pv.id.ideamVal "
				+ "AND pe.id.tipoVal = 'station' "
				+ "AND pv.id.tipoVal = 'variable' "
				+ "AND pq.id.tipoVal = 'quality' "
				+ "AND (dd.id.idstation = :pIdStation or :pIdStation is null) "
				+ "AND ("
				+ "(dd.id.datadate between :pfechaIni and :pfechafin and :pfechaIni is not null and :pfechafin is not null) "
				+ "OR (:pfechaIni is null and dd.id.datadate <= :pfechafin and :pfechafin is not null) "
				+ "OR (:pfechafin is null and dd.id.datadate >= :pfechaIni and :pfechaIni is not null) "
				+ "OR (:pfechafin is null and :pfechaIni is null))")
})
public class Dailydata implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="DLDT_ID", updatable=false, insertable=false)
	private Long idSec;
	
	@EmbeddedId
	private DailydataPK id;

	@Column(name="DLDT_DATA")
	private BigDecimal data;


	@Temporal(TemporalType.DATE)
	@Column(name="DLDT_DATE")
	private Date date;
	@Column(name="DLDT_IDFLAG")
	private Long idflag;

	@Column(name="DLDT_IDQC")
	private Long idqc;


	@Column(name="DLDT_USER")
	private Long user;

	public Dailydata() {
	}

	public Long getIdSec() {
		return idSec;
	}

	public void setIdSec(Long idSec) {
		this.idSec = idSec;
	}

	public DailydataPK getId() {
		return id;
	}

	public void setId(DailydataPK id) {
		this.id = id;
	}

	public BigDecimal getData() {
		return data;
	}

	public void setData(BigDecimal data) {
		this.data = data;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getIdflag() {
		return idflag;
	}

	public void setIdflag(Long idflag) {
		this.idflag = idflag;
	}

	public Long getIdqc() {
		return idqc;
	}

	public void setIdqc(Long idqc) {
		this.idqc = idqc;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	




}