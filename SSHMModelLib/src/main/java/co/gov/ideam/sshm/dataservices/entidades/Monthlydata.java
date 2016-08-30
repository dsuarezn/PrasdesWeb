package co.gov.ideam.sshm.dataservices.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the HMST_MONTHLYDATA database table.
 * 
 */
@Entity
@Table(name="HMST_MONTHLYDATA")
@NamedQueries({
	@NamedQuery(name="Monthlydata.findAll", query="SELECT m FROM Monthlydata m"),
	@NamedQuery(name="Monthlydata.findByParameters", 
	query="SELECT NEW co.gov.ideam.sshm.web.dto.ConsultaResponseDTO(m.id.idstation, m.id.idvariable, m.id.datadate, m.id.idsource, m.data, m.idflag, m.idqc, m.user, m.date, m.idSec) "
			+ "FROM Monthlydata m "
			+ "WHERE (m.id.idvariable = :pIdVariable or :pIdVariable is null) "
			+ "AND (m.id.idstation = :pIdStation or :pIdStation is null) "
			+ "AND ("
			+ "(m.id.datadate between :pfechaIni and :pfechafin and :pfechaIni is not null and :pfechafin is not null) "
			+ "OR (:pfechaIni is null and m.id.datadate <= :pfechafin and :pfechafin is not null) "
			+ "OR (:pfechafin is null and m.id.datadate >= :pfechaIni and :pfechaIni is not null) "
			+ "OR (:pfechafin is null and :pfechaIni is null))"),
	@NamedQuery(name="Monthlydata.findByParametersPrasdes", 
	query="SELECT NEW co.gov.ideam.sshm.web.dto.ConsultaResponseDTO(m.id.idstation, m.id.idvariable, m.id.datadate, m.id.idsource, m.data, m.idflag, m.idqc, m.user, m.date, m.idSec) "
			+ "FROM Monthlydata m, PrasdesEquiv pe, PrasdesEquiv pv, PrasdesEquiv pq " 
			+ "WHERE (m.id.idvariable = :pIdVariable or :pIdVariable is null) "
			+ "AND m.id.idstation = cast(pe.id.ideamVal as long) "
			+ "AND m.idqc = cast(pe.id.ideamVal as long) "
			+ "AND m.id.idvariable = pv.id.ideamVal "
			+ "AND pe.id.tipoVal = 'station' "
			+ "AND pv.id.tipoVal = 'variable' "
			+ "AND pq.id.tipoVal = 'quality' "
			+ "AND (m.id.idstation = :pIdStation or :pIdStation is null) "
			+ "AND ("
			+ "(m.id.datadate between :pfechaIni and :pfechafin and :pfechaIni is not null and :pfechafin is not null) "
			+ "OR (:pfechaIni is null and m.id.datadate <= :pfechafin and :pfechafin is not null) "
			+ "OR (:pfechafin is null and m.id.datadate >= :pfechaIni and :pfechaIni is not null) "
			+ "OR (:pfechafin is null and :pfechaIni is null))")
})
public class Monthlydata implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MonthlydataPK id;
	
	@Column(name="MNDT_ID", updatable=false, insertable=false)
	private long idSec;

	@Column(name="MNDT_DATA")
	private BigDecimal data;
	
	@Temporal(TemporalType.DATE)
	@Column(name="MNDT_DATE")
	private Date date;

	@Column(name="MNDT_IDFLAG")
	private Long idflag;

	@Column(name="MNDT_IDQC")
	private Long idqc;

	@Column(name="MNDT_USER")
	private Long user;

	public Monthlydata() {
	}

	

	public long getIdSec() {
		return idSec;
	}



	public void setIdSec(long idSec) {
		this.idSec = idSec;
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



	public MonthlydataPK getId() {
		return id;
	}



	public void setId(MonthlydataPK id) {
		this.id = id;
	}

	

}