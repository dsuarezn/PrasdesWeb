package co.gov.ideam.prasdes.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.dao.CountryDAO;
import co.gov.ideam.prasdes.dataservices.entidades.Country;

@Repository
@Transactional
@Qualifier("countryDAOImpl")
public class CountryDAOImpl extends GenericDAOJPAImpl<Country, Long> implements CountryDAO {

	@Override
	public List<Country> obtenerListaPaises() {
		Query query = em.createNamedQuery("Country.findAll");			
		return (List<Country>) query.getResultList();
	}

}
