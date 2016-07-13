package co.gov.ideam.prasdes.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.dao.PeriodDAO;
import co.gov.ideam.prasdes.dataservices.entidades.Period;

@Repository
@Transactional
@Qualifier("periodDAOImpl")
public class PeriodDAOImpl extends GenericDAOJPAImpl<Period, Long> implements PeriodDAO {

	@Override
	public List<Period> obtenerListaPeriodos() {
		Query query = em.createNamedQuery("Period.findAll");			
		return (List<Period>) query.getResultList();
	}

}
