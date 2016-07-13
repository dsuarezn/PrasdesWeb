package co.gov.ideam.prasdes.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.dao.VariableDAO;
import co.gov.ideam.prasdes.dataservices.entidades.Variable;


@Repository
@Transactional
@Qualifier("variableDAOImpl")
public class VariableDAOImpl extends GenericDAOJPAImpl<Variable, Long> implements VariableDAO {

	@Override
	public List<Variable> obtenerListaVariables() {
		Query query = em.createNamedQuery("Variable.findAll");			
		return (List<Variable>) query.getResultList();
	}

}
