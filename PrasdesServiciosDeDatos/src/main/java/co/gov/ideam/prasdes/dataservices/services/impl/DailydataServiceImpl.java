package co.gov.ideam.prasdes.dataservices.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.entidades.Dailydata;
import co.gov.ideam.prasdes.dataservices.services.DailydataService;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

@Transactional
@Service
@Qualifier("dailydataServiceImpl")
public class DailydataServiceImpl extends ServiceCommons implements DailydataService {

	

	@Override
	public List<ConsultaResponseDTO> consultarInfoDiariaPorParametros(ConsultaRestFormDTO params) {
		return daoFactory.getDailydataDAOImpl().consultarInfoDiariaPorParametros(params);
	}
	
	@Override
	public void actualizarInfoDiaria(List<Dailydata> datosDiarios) {
		daoFactory.getDailydataDAOImpl().persistirInfoDiaria(datosDiarios);		
	}

}
