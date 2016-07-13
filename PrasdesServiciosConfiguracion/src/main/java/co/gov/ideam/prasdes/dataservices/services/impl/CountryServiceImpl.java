package co.gov.ideam.prasdes.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.entidades.Country;
import co.gov.ideam.prasdes.dataservices.services.CountryService;

@Transactional
@Service
@Qualifier("countryServiceImpl")
public class CountryServiceImpl extends ServiceCommons implements CountryService {

	@Override
	public List<Country> obtenerListaPaises() {
		return daoFactory.getCountryDAOImpl().obtenerListaPaises();
	}

}
