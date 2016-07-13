package co.gov.ideam.prasdes.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.dao.CustomerWebServiceDAO;
import co.gov.ideam.prasdes.dataservices.entidades.Customerwebserv;


@Repository
@Transactional
@Qualifier("customerWebServiceDAOImpl")
public class CustomerWebServiceDAOImpl extends GenericDAOJPAImpl<Customerwebserv, String> implements CustomerWebServiceDAO {

	@Override
	public List<Customerwebserv> obtenerListaCustomersWebServ() {
		Query query = em.createNamedQuery("Customerwebserv.findAll");			
		return (List<Customerwebserv>) query.getResultList();
	}
	
	

}
