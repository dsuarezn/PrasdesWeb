package co.gov.ideam.prasdes.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.entidades.Rawdata;
import co.gov.ideam.prasdes.dataservices.services.RawdataService;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;


@Service
@Qualifier("rawdataServiceImpl")
public class RawdataServiceImpl extends ServiceCommons implements RawdataService {

	@Override
	public List<ConsultaResponseRawDataDTO> consultarInfoCrudaPorParametros(ConsultaRestFormDTO params) {
		return daoFactory.getRawdataDAOImpl().consultarInfoCrudaPorParametros(params);
	}

	@Transactional(timeout=200,readOnly=true)
	@Override
	public void actualizarInfoCrudos(List<Rawdata> datosCrudos) {
		daoFactory.getRawdataDAOImpl().persistirInfoCruda(datosCrudos);

	}

}
