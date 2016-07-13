package co.gov.ideam.prasdes.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.entidades.Instantdata;
import co.gov.ideam.prasdes.dataservices.services.InstantdataService;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

@Transactional
@Service
@Qualifier("instantdataServiceImpl")
public class InstantdataServiceImpl extends ServiceCommons implements InstantdataService {

	
	
	@Override
	public List<ConsultaResponseRawDataDTO> consultarInfoInstantaneaPorParametros(ConsultaRestFormDTO params) {
		return daoFactory.getInstantdataDAOImpl().consultarInfoInstantaneaPorParametros(params);
	}

	@Override
	public void actualizarInfoInstantanea(List<Instantdata> datosInstantaneos) {
		daoFactory.getInstantdataDAOImpl().persistirInfoInstantanea(datosInstantaneos);
	}
	
}
