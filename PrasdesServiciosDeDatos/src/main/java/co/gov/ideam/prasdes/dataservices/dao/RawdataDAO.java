package co.gov.ideam.prasdes.dataservices.dao;

import java.util.List;

import co.gov.ideam.prasdes.dataservices.entidades.Rawdata;
import co.gov.ideam.prasdes.dataservices.entidades.RawdataPK;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

public interface RawdataDAO extends GenericDAOInterface<Rawdata, RawdataPK> {

	
	public List<ConsultaResponseRawDataDTO> consultarInfoCrudaPorParametros(ConsultaRestFormDTO params);
	public void persistirInfoCruda(List<Rawdata> rawData);
	
	
	
}
