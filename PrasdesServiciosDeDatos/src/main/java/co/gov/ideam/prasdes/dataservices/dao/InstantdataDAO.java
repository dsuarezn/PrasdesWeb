package co.gov.ideam.prasdes.dataservices.dao;

import java.util.List;

import co.gov.ideam.prasdes.dataservices.entidades.Instantdata;
import co.gov.ideam.prasdes.dataservices.entidades.InstantdataPK;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

public interface InstantdataDAO extends GenericDAOInterface<Instantdata, InstantdataPK> {

	
	public List<ConsultaResponseRawDataDTO> consultarInfoInstantaneaPorParametros(ConsultaRestFormDTO params);
	void persistirInfoInstantanea(List<Instantdata> entities);
	
}
