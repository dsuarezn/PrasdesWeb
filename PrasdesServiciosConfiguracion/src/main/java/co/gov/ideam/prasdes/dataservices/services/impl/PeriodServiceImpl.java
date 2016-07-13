package co.gov.ideam.prasdes.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.entidades.Period;
import co.gov.ideam.prasdes.dataservices.services.PeriodService;

@Transactional
@Service
@Qualifier("periodServiceImpl")
public class PeriodServiceImpl extends ServiceCommons  implements PeriodService {

	@Override
	public List<Period> obtenerListaPeriodos() {
		return daoFactory.getPeriodDAOImpl().obtenerListaPeriodos();
	}

}
