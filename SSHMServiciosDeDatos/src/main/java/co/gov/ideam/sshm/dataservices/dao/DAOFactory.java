package co.gov.ideam.sshm.dataservices.dao;

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
	private InstantdataDAO instantdataDAOImpl; 

	@Autowired
	private DailydataDAO dailydataDAOImpl;

	@Autowired
	private MonthlydataDAO monthlydataDAOImpl;

	public InstantdataDAO getInstantdataDAOImpl() {
		return instantdataDAOImpl;
	}

	public DailydataDAO getDailydataDAOImpl() {
		return dailydataDAOImpl;
	}

	public MonthlydataDAO getMonthlydataDAOImpl() {
		return monthlydataDAOImpl;
	}
	
	
	

		

}
