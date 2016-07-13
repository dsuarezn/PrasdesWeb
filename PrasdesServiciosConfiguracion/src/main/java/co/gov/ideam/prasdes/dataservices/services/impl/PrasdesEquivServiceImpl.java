package co.gov.ideam.prasdes.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.entidades.PrasdesEquiv;
import co.gov.ideam.prasdes.dataservices.services.PrasdesEquivService;

@Transactional
@Service
@Qualifier("prasdesEquivServiceImpl")
public class PrasdesEquivServiceImpl extends ServiceCommons implements PrasdesEquivService {

	@Override
	public List<PrasdesEquiv> obtenerEquivalenciasPorParametro(String tipoval, String ideamval, String prasdesval) {
		return daoFactory.getPrasdesEquivDAOImpl().obtenerEquivalenciasPorParametros(tipoval, ideamval, prasdesval);
	}

}
