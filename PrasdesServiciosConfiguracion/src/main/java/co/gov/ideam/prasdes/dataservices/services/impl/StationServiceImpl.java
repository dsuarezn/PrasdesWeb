package co.gov.ideam.prasdes.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.entidades.Station;
import co.gov.ideam.prasdes.dataservices.services.StationService;

@Transactional
@Service
@Qualifier("stationServiceImpl")
public class StationServiceImpl extends ServiceCommons implements StationService  {

	@Override
	public List<Station> obtenerListaEstaciones() {
		return daoFactory.getStationDAOImpl().obtenerListaEstaciones();
	}

}
