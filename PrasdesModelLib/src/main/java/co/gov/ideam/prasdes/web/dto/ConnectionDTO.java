package co.gov.ideam.prasdes.web.dto;

public class ConnectionDTO {
	
	public ConnectionDTO(){
		
	}

	public ConnectionDTO(String vIdcustomer, long nIdcountry, String vNameCountry, long nIdperiod, String vNamePeriod,
			String vTablesource, String vUrl, String vNameCustomer, String vNameResponsible) {
		super();
		this.vIdcustomer = vIdcustomer;
		this.nIdcountry = nIdcountry;
		this.vNameCountry = vNameCountry;
		this.vNameCustomer = vNameCustomer;
		this.nIdperiod = nIdperiod;
		this.vNamePeriod = vNamePeriod;
		this.vTablesource = vTablesource;
		this.vNameResponsible=vNameResponsible;
		this.vUrl = vUrl;
	}

	protected String vNameResponsible;
	
	protected String vNameCustomer;
	
	protected String vIdcustomer;
	
	protected long nIdcountry;

	protected String vNameCountry;
	
	protected long nIdperiod;
	
	protected String vNamePeriod;
	
	protected String vTablesource;
	
	protected String vUrl;

	public String getvIdcustomer() {
		return vIdcustomer;
	}

	public void setvIdcustomer(String vIdcustomer) {
		this.vIdcustomer = vIdcustomer;
	}

	public long getnIdcountry() {
		return nIdcountry;
	}

	public void setnIdcountry(long nIdcountry) {
		this.nIdcountry = nIdcountry;
	}

	public String getvNameCountry() {
		return vNameCountry;
	}

	public void setvNameCountry(String vNameCountry) {
		this.vNameCountry = vNameCountry;
	}

	public long getnIdperiod() {
		return nIdperiod;
	}

	public void setnIdperiod(long nIdperiod) {
		this.nIdperiod = nIdperiod;
	}

	public String getvNamePeriod() {
		return vNamePeriod;
	}

	public void setvNamePeriod(String vNamePeriod) {
		this.vNamePeriod = vNamePeriod;
	}

	public String getvTablesource() {
		return vTablesource;
	}

	public void setvTablesource(String vTablesource) {
		this.vTablesource = vTablesource;
	}

	public String getvUrl() {
		return vUrl;
	}

	public void setvUrl(String vUrl) {
		this.vUrl = vUrl;
	}
	
	
	
	public String getvNameResponsible() {
		return vNameResponsible;
	}

	public void setvNameResponsible(String vNameResponsible) {
		this.vNameResponsible = vNameResponsible;
	}

	public String getvNameCustomer() {
		return vNameCustomer;
	}

	public void setvNameCustomer(String vNameCustomer) {
		this.vNameCustomer = vNameCustomer;
	}

	@Override
	public String toString() {
		return "ConnectionDTO [vIdcustomer=" + vIdcustomer + ", nIdcountry=" + nIdcountry + ", vNameCountry="
				+ vNameCountry + ", nIdperiod=" + nIdperiod + ", vNamePeriod=" + vNamePeriod + ", vTablesource="
				+ vTablesource + ", vUrl=" + vUrl + "]";
	}
	
	
}
