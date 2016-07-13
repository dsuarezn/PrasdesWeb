package co.gov.ideam.prasdes.dataservices.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.gov.ideam.prasdes.dataservices.entidades.Customerwebserv;



@Repository
@Qualifier("daoFactory")
public class DAOFactory {
	//TODO: evaluar porque se podria o no hacer estaticos los DAOs
	public DAOFactory() {
		super();	
	}
	
	@Autowired
	private PeriodDAO periodDAOImpl;
	
	@Autowired
	private CountryDAO countryDAOImpl;
	
	@Autowired
	private ConnectionDAO connectionServiceImpl;
		
	
	@Autowired
	private PrasdesEquivDAO prasdesEquivDAOImpl;
	
	@Autowired
	private MigTaskDAO migTaskDAOImpl;
	
	@Autowired
	private StationDAO stationDAOImpl;
	
	@Autowired
	private VariableDAO variableDAOImpl;
	
	@Autowired
	private CustomerStationVarDAO customerStationVarDAOImpl;
	
	@Autowired
	private CustomerWebServiceDAO customerWebServiceDAOImpl;
	
	
	public CustomerStationVarDAO getCustomerStationVarDAOImpl() {
		return customerStationVarDAOImpl;
	}

	public void setCustomerStationVarDAOImpl(CustomerStationVarDAO customerStationVarDAOImpl) {
		this.customerStationVarDAOImpl = customerStationVarDAOImpl;
	}

	public StationDAO getStationDAOImpl() {
		return stationDAOImpl;
	}

	public void setStationDAOImpl(StationDAO stationDAOImpl) {
		this.stationDAOImpl = stationDAOImpl;
	}

	public VariableDAO getVariableDAOImpl() {
		return variableDAOImpl;
	}

	public void setVariableDAOImpl(VariableDAO variableDAOImpl) {
		this.variableDAOImpl = variableDAOImpl;
	}

	public MigTaskDAO getMigTaskDAOImpl() {
		return migTaskDAOImpl;
	}

	public void setMigTaskDAOImpl(MigTaskDAO migTaskDAOImpl) {
		this.migTaskDAOImpl = migTaskDAOImpl;
	}

	public ConnectionDAO getConnectionServiceImpl() {
		return connectionServiceImpl;
	}

	public void setConnectionServiceImpl(ConnectionDAO connectionServiceImpl) {
		this.connectionServiceImpl = connectionServiceImpl;
	}

	

	public PrasdesEquivDAO getPrasdesEquivDAOImpl() {
		return prasdesEquivDAOImpl;
	}

	public void setPrasdesEquivDAOImpl(PrasdesEquivDAO prasdesEquivDAOImpl) {
		this.prasdesEquivDAOImpl = prasdesEquivDAOImpl;
	}

	public CustomerWebServiceDAO getCustomerWebServiceDAOImpl() {
		return customerWebServiceDAOImpl;
	}

	public void setCustomerWebServiceDAOImpl(CustomerWebServiceDAO customerWebServiceDAOImpl) {
		this.customerWebServiceDAOImpl = customerWebServiceDAOImpl;
	}

	public CountryDAO getCountryDAOImpl() {
		return countryDAOImpl;
	}

	public void setCountryDAOImpl(CountryDAO countryDAOImpl) {
		this.countryDAOImpl = countryDAOImpl;
	}

	public PeriodDAO getPeriodDAOImpl() {
		return periodDAOImpl;
	}

	public void setPeriodDAOImpl(PeriodDAO periodDAOImpl) {
		this.periodDAOImpl = periodDAOImpl;
	}

	

	
	
	


		

}
