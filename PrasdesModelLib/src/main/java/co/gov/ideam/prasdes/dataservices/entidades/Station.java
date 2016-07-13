package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the GRDMAP_STATION database table.
 * 
 */
@Entity
@Table(name="GRDMAP_STATION")
@NamedQuery(name="Station.findAll", query="SELECT s FROM Station s")
public class Station implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="N_IDSTATION")
	private Long nIdstation;

	@Column(name="N_ALTITUDE")
	private BigDecimal nAltitude;

	@Column(name="N_IDCATEGORY")
	private BigDecimal nIdcategory;

	@Column(name="N_IDREGION")
	private BigDecimal nIdregion;

	@Column(name="N_LATITUDE")
	private BigDecimal nLatitude;

	@Column(name="N_LONGITUDE")
	private BigDecimal nLongitude;

	@Column(name="V_COD_STATION1")
	private String vCodStation1;

	@Column(name="V_COD_STATION2")
	private String vCodStation2;

	@Column(name="V_COD_STATION3")
	private String vCodStation3;

	@Column(name="V_COD_STATION4")
	private String vCodStation4;

	@Column(name="V_COD_STATION5")
	private String vCodStation5;

	@Column(name="V_IDBASIN")
	private BigDecimal vIdbasin;

	@Column(name="V_NAME_STATION")
	private String vNameStation;

	public Station() {
	}

	public long getNIdstation() {
		return this.nIdstation;
	}

	public void setNIdstation(long nIdstation) {
		this.nIdstation = nIdstation;
	}

	public BigDecimal getNAltitude() {
		return this.nAltitude;
	}

	public void setNAltitude(BigDecimal nAltitude) {
		this.nAltitude = nAltitude;
	}

	public BigDecimal getNIdcategory() {
		return this.nIdcategory;
	}

	public void setNIdcategory(BigDecimal nIdcategory) {
		this.nIdcategory = nIdcategory;
	}

	public BigDecimal getNIdregion() {
		return this.nIdregion;
	}

	public void setNIdregion(BigDecimal nIdregion) {
		this.nIdregion = nIdregion;
	}

	public BigDecimal getNLatitude() {
		return this.nLatitude;
	}

	public void setNLatitude(BigDecimal nLatitude) {
		this.nLatitude = nLatitude;
	}

	public BigDecimal getNLongitude() {
		return this.nLongitude;
	}

	public void setNLongitude(BigDecimal nLongitude) {
		this.nLongitude = nLongitude;
	}

	public String getVCodStation1() {
		return this.vCodStation1;
	}

	public void setVCodStation1(String vCodStation1) {
		this.vCodStation1 = vCodStation1;
	}

	public String getVCodStation2() {
		return this.vCodStation2;
	}

	public void setVCodStation2(String vCodStation2) {
		this.vCodStation2 = vCodStation2;
	}

	public String getVCodStation3() {
		return this.vCodStation3;
	}

	public void setVCodStation3(String vCodStation3) {
		this.vCodStation3 = vCodStation3;
	}

	public String getVCodStation4() {
		return this.vCodStation4;
	}

	public void setVCodStation4(String vCodStation4) {
		this.vCodStation4 = vCodStation4;
	}

	public String getVCodStation5() {
		return this.vCodStation5;
	}

	public void setVCodStation5(String vCodStation5) {
		this.vCodStation5 = vCodStation5;
	}

	public BigDecimal getVIdbasin() {
		return this.vIdbasin;
	}

	public void setVIdbasin(BigDecimal vIdbasin) {
		this.vIdbasin = vIdbasin;
	}

	public String getVNameStation() {
		return this.vNameStation;
	}

	public void setVNameStation(String vNameStation) {
		this.vNameStation = vNameStation;
	}

}