package co.gov.ideam.prasdes.dataservices.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;



@Repository
@Qualifier("daoFactory")
public class DAOFactory {
	//TODO: evaluar porque se podria o no hacer estaticos los DAOs
	public DAOFactory() {
		super();
	
	}
	
	@Autowired
	private DailydataDAO dailydataDAOImpl;
	
	@Autowired
	private InstantdataDAO instantdataDAOImpl;

	@Autowired
	private MonthlydataDAO monthlydataDAOImpl;
	
	@Autowired
	private RawdataDAO rawdataDAODAOImpl;

	public DailydataDAO getDailydataDAOImpl() {
		return dailydataDAOImpl;
	}

	public InstantdataDAO getInstantdataDAOImpl() {
		return instantdataDAOImpl;
	}

	public MonthlydataDAO getMonthlydataDAOImpl() {
		return monthlydataDAOImpl;
	}

	public RawdataDAO getRawdataDAOImpl() {
		return rawdataDAODAOImpl;
	}

	

		

}
