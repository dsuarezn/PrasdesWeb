package co.gov.ideam.prasdes.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.dao.CustomerStationVarDAO;
import co.gov.ideam.prasdes.dataservices.entidades.Customerstationvar;
import co.gov.ideam.prasdes.web.dto.CustomerStationVarDTO;


@Repository
@Transactional
@Qualifier("customerStationVarDAOImpl")
public class CustomerStationVarDAOImpl extends GenericDAOJPAImpl<Customerstationvar, String> implements CustomerStationVarDAO {

	@Override
	public List<CustomerStationVarDTO> obtenerListadoCustomerStVar() {
		Query query = em.createNamedQuery("Customerstationvar.findAll");			
		return (List<CustomerStationVarDTO>) query.getResultList();
	}

	@Override
	public Customerstationvar persistirCustomerStationVar(Customerstationvar customVar) {
		return update(customVar);
	}

	@Override
	public void eliminarCustomerStationVar(Customerstationvar customVar) {
		delete(customVar);
	}

}
