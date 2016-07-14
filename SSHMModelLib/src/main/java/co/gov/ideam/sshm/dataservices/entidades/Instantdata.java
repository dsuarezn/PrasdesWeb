package co.gov.ideam.sshm.dataservices.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the HMST_INSTANTDATA database table.
 * 
 */
@Entity
@Table(name="HMST_INSTANTDATA")
@NamedQueries({
	@NamedQuery(name="Instantdata.findAll", query="SELECT i FROM Instantdata i"),
	@NamedQuery(name="Instantdata.findByParameters", 
	query="SELECT NEW co.gov.ideam.sshm.web.dto.ConsultaResponseDTO(i.id.idstation,i.id.idvariable,i.id.datadate,i.id.idsource,i.data,i.idflag,i.idqc,i.user,i.date, i.idSec) "
			+ "FROM Instantdata i "
			+ "WHERE (i.id.idvariable = :pIdVariable or :pIdVariable is null) "
			+ "AND (i.id.idstation = :pIdStation or :pIdStation is null) "
			+ "AND ("
			+ "(i.id.datadate between :pfechaIni and :pfechafin  and :pfechaIni is not null and :pfechafin is not null) "
			+ "OR (:pfechaIni is null and i.id.datadate <= :pfechafin and :pfechafin is not null) "
			+ "OR (:pfechafin is null and i.id.datadate >= :pfechaIni and :pfechaIni is not null) "
			+ "OR (:pfechafin is null and :pfechaIni is null))")
})
public class Instantdata implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InstantdataPK id;
		
	@Column(name="INDT_ID", updatable=false, insertable=false)
	private Long idSec;

	@Column(name="INDT_DATA")
	private String data;	

	@Temporal(TemporalType.DATE)
	@Column(name="INDT_DATE")
	private Date date;

	@Column(name="INDT_IDFLAG")
	private Long idflag;

	@Column(name="INDT_IDQC")
	private Long idqc;

	@Column(name="INDT_USER")
	private Long user;

	public Instantdata() {
	}

	public InstantdataPK getId() {
		return id;
	}

	public void setId(InstantdataPK id) {
		this.id = id;
	}

	public Long getIdSec() {
		return idSec;
	}

	public void setIdSec(Long idSec) {
		this.idSec = idSec;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
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