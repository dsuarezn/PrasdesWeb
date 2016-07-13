package co.gov.ideam.prasdes.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.entidades.Variable;
import co.gov.ideam.prasdes.dataservices.services.VariableService;



@Transactional
@Service
@Qualifier("variableServiceImpl")
public class VariableServiceImpl extends ServiceCommons implements VariableService {

	@Override
	public List<Variable> obtenerListaVariables() {
		return daoFactory.getVariableDAOImpl().obtenerListaVariables();
	}

}
