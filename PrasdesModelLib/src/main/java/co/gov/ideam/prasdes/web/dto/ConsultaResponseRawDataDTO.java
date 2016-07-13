package co.gov.ideam.prasdes.web.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.dozer.Mapping;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

import co.gov.ideam.prasdes.utilidades.Utilidades;



//@JsonFormat(shape=JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({ "N_IDSTATION", "N_IDVAR", "D_DATADATE", "N_IDSOURCE" , "N_DATA", "N_IDQC", "N_IDFLAG", "N_IDUSER", "D_DATEADD" , "N_IDPERIOD" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaResponseRawDataDTO {

	
	public ConsultaResponseRawDataDTO(long nIdstation, long nIdvar, Date dDatadate, long nIdsource, BigDecimal nData,
			Long nIdqc, Long nIdflag, Long nIduser, Date dDateadd) {
		super();
		this.nIdstation = nIdstation;
		this.nIdvar = nIdvar;
		this.dDatadate = dDatadate;
		this.nIdsource = nIdsource;
		this.nData = nData;
		this.nIdqc = nIdqc;
		this.nIdflag = nIdflag;
		this.nIduser = nIduser;
		this.dDateadd = dDateadd;
	}

	
	public ConsultaResponseRawDataDTO(long nIdstation, long nIdvar, Date dDatadate, long nIdsource, BigDecimal nData,
			Long nIdqc, Long nIdflag, Long nIduser, Date dDateadd, long nIdperiod) {
		super();
		this.nIdstation = nIdstation;
		this.nIdvar = nIdvar;
		this.dDatadate = dDatadate;
		this.nIdsource = nIdsource;
		this.nData = nData;
		this.nIdqc = nIdqc;
		this.nIdflag = nIdflag;
		this.nIduser = nIduser;
		this.dDateadd = dDateadd;
		this.nIdperiod = nIdperiod;
	}

	
	public ConsultaResponseRawDataDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Mapping("id.nIdstation")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private long nIdstation;
	
	@Mapping("id.nIdvar")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private long nIdvar;
	
	@Mapping("id.nIdperiod")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private long nIdperiod;
	
	@Mapping("id.dDatadate")
	private Date dDatadate;
		
	@Mapping("id.nIdsource")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private long nIdsource;	
	
		
	private BigDecimal nData;
	
		
	private Long nIdqc;	
	
		
	private Long nIdflag;
	
	
	private Long nIduser;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Utilidades.TIMESTAMP_PATTERN)
	private Date dDateadd;


	@JsonGetter("0")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	public long getnIdstationByIndex() {
		return nIdstation;
	}
	
	@JsonGetter("N_IDSTATION")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	public long getnIdstation() {
		return nIdstation;
	}		
	
	@JsonSetter("nIdstation")
	public void setnIdstation(long nIdstation) {
		this.nIdstation = nIdstation;
	}
	
	@JsonSetter("N_IDSTATION")
	public void setnIdstationEx1(long nIdstation) {
		this.nIdstation = nIdstation;
	}


	@JsonGetter("1")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	public long getnIdvarByIndex() {
		return nIdvar;
	}
	
	@JsonGetter("N_IDVAR")
	public long getnIdvar() {
		return nIdvar;
	}

	@JsonSetter("nIdvar")
	public void setnIdvar(long nIdvar) {
		this.nIdvar = nIdvar;
	}
	
	@JsonSetter("N_IDVAR")
	public void setnIdvarEx1(long nIdvar) {
		this.nIdvar = nIdvar;
	}

//	public Date getdDatadate() {
//		return dDatadate;
//	}
	
//	@JsonGetter("dDatadate")
//	public String getsdDatadate() {		
//		return (dDatadate!=null ? Utilidades.formatearFecha(dDatadate) : null) ;
//	}
	
	@JsonGetter("2")
	public String getsdDatadateByIndex() {		
		return (dDatadate!=null ? Utilidades.formatearTimestampOFecha(dDatadate) : null) ;
	}
	
	@JsonGetter("D_DATADATE")
	public String getsdDatadate() {		
		return (dDatadate!=null ? Utilidades.formatearTimestampOFecha(dDatadate) : null) ;
	}
	
	@JsonSetter("dDatadate")
	public void setsdDatadate(String fechastr) {				
		this.dDatadate = (StringUtils.isEmpty(fechastr) ? null : Utilidades.parsearTimestampOFecha(fechastr));
	}
	
	@JsonSetter("D_DATADATE")
	public void setsdDatadateEx1(String fechastr) {				
		this.dDatadate = (StringUtils.isEmpty(fechastr) ? null : Utilidades.parsearTimestampOFecha(fechastr));
	}

	public void setdDatadate(Date dDatadate) {
		this.dDatadate = dDatadate;
	}
	
//	@JsonGetter("nIdsource")
//	public long getnIdsource() {
//		return nIdsource;
//	}
	
	@JsonGetter("3")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	public long getnIdsourceByIndex() {
		return nIdsource;
	}
	
	@JsonGetter("N_IDSOURCE")
	public long getnIdsource() {
		return nIdsource;
	}

	@JsonSetter("nIdsource")
	public void setnIdsource(long nIdsource) {
		this.nIdsource = nIdsource;
	}
	
	@JsonSetter("N_IDSOURCE")
	public void setnIdsourceEx1(long nIdsource) {
		this.nIdsource = nIdsource;
	}

//	public BigDecimal getnData() {
//		return nData;
//	}
	
//	@JsonGetter("nData")
//	public String getsnData() {		
//		return (nData!=null ? nData.toString() : null) ;
//	}
	
	@JsonGetter("4")
	public String getsnDataByIndex() {		
		return (nData!=null ? nData.toString() : null) ;
	}
	
	@JsonGetter("N_DATA")
	public String getsnData() {		
		return (nData!=null ? nData.toString() : null) ;
	}
	
	@JsonSetter("nData")
	public void setsnData(String ndatos) {		
		this.nData = (ndatos!=null?new BigDecimal(ndatos):null);
	}
	
	@JsonSetter("N_DATA")
	public void setsnDataEx1(String ndatos) {		
		this.nData = (ndatos!=null? new BigDecimal(ndatos):null);
	}
	

	public void setnData(BigDecimal nData) {
		this.nData = nData;
	}

//	public BigDecimal getnIdqc() {
//		return nIdqc;
//	}
	
//	@JsonGetter("nIdqc")
//	public String getsnIdqc() {		
//		return (nIdqc!=null ? nIdqc.toString() : null) ;
//	}
	
	@JsonGetter("5")
	public String getsnIdqcByIndex() {		
		return (nIdqc!=null ? nIdqc.toString() : null) ;
	}
	
	@JsonGetter("N_IDQC")
	public String getsnIdqc() {		
		return (nIdqc!=null ? nIdqc.toString() : null) ;
	}
	
	@JsonSetter("nIdqc")
	public void setsnIdqc(String nIdqct) {		
		nIdqc = (nIdqct!=null ? new Long(nIdqct) : null);
	}
	
	@JsonSetter("N_IDQC") 
	public void setsnIdqcEx1(String nIdqct) {		
		nIdqc = (nIdqct!=null ? new Long(nIdqct):null);
	}

	public void setnIdqc(Long nIdqc) {
		this.nIdqc = nIdqc;
	}

//	public BigDecimal getnIdflag() {
//		return nIdflag;
//	}
	
//	@JsonGetter("nIdflag")
//	public String getsnIdflag() {
//		return (nIdflag!=null ? nIdflag.toString() : null) ;		
//	}
	
	@JsonGetter("6")
	public String getsnIdflagByIndex() {
		return (nIdflag!=null ? nIdflag.toString() : null) ;		
	}
	
	@JsonGetter("N_IDFLAG")
	public String getsnIdflag() {
		return (nIdflag!=null ? nIdflag.toString() : null) ;		
	}
	
	@JsonSetter("nIdflag")
	public void setsnIdflag(String idflag) {		
		nIdflag = (idflag!=null ? new Long(idflag) : null );
	}
	
	@JsonSetter("N_IDFLAG")
	public void setsnIdflagEx1(String idflag) {		
		nIdflag = (idflag!=null ? new Long(idflag) : null );
	}

	public void setnIdflag(Long nIdflag) {
		this.nIdflag = nIdflag;
	}

//	public BigDecimal getnIduser() {
//		return nIduser;
//	}	

//	@JsonGetter("nIduser")
//	public String getsnIduser() {		
//		return (nIduser!=null ? nIduser.toString() : null) ;
//	}
	
	@JsonGetter("7")
	public String getsnIduserByIndex() {		
		return (nIduser!=null ? nIduser.toString() : null) ;
	}	
	
	@JsonGetter("N_IDUSER")
	public String getsnIduser() {		
		return (nIduser!=null ? nIduser.toString() : null) ;
	}
	
	@JsonSetter("nIduser")
	public void setsnIduser(String iduser) {		
		nIduser = (iduser != null? new Long(iduser) : null);
	}
	
	@JsonSetter("N_IDUSER")
	public void setsnIduserEx1(String iduser) {		
		nIduser = (iduser != null? new Long(iduser) : null);
	}
	
	public void setnIduser(Long nIduser) {
		this.nIduser = nIduser;
	}

//	@JsonGetter("dDateadd")
//	public Date getdDateadd() {
//		return dDateadd;
//	}
	
//	@JsonGetter("dDateadd")
//	public String getdDateadd() {		
//		return (dDatadate!=null ? Utilidades.formatearFecha(dDateadd) : null) ;
//	}
	
	@JsonGetter("8")
	public String getdDateaddByIndex() {		
		return (dDateadd!=null ? Utilidades.formatearTimestampOFecha(dDateadd) : null) ;
	}
	
	@JsonGetter("D_DATEADD")
	public String getdDateadd() {		
		return (dDateadd!=null ? Utilidades.formatearTimestampOFecha(dDateadd) : null) ;
	}
	
//	@JsonSetter("dDateadd")
//	public void setdDateadd(String fechastr) {		
//		this.dDateadd = (StringUtils.isEmpty(fechastr) ? null : Utilidades.parsearMarcaTiempo(fechastr));	
//	}
	
//	@JsonSetter("D_DATEADD")
//	public void setdDateaddEx1(String fechastr) {
//		this.dDateadd = (StringUtils.isEmpty(fechastr) ? null : Utilidades.parsearMarcaTiempo(fechastr));		
//	}

//
//	@JsonGetter("nIdperiod")
//	public long getnIdperiod() {
//		return nIdperiod;
//	}
	
	@JsonGetter("9")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	public long getnIdperiodByIndex() {
		return nIdperiod;
	}
	
	@JsonGetter("N_IDPERIOD")
	public long getnIdperiod() {
		return nIdperiod;
	}

	@JsonSetter("N_IDPERIOD")
	public void setnIdperiod(long nIdperiod) {
		this.nIdperiod = nIdperiod;
	}


	@Override
	public String toString() {
		return "ConsultaResponseDTO [nIdstation=" + nIdstation + ", nIdvar=" + nIdvar + ", dDatadate=" + dDatadate
				+ ", nIdsource=" + nIdsource + ", nData=" + nData + ", nIdqc=" + nIdqc + ", nIdflag=" + nIdflag
				+ ", nIduser=" + nIduser + ", dDateadd=" + dDateadd + "]";
	}



	
	
	

	
	
	
	
	
}
