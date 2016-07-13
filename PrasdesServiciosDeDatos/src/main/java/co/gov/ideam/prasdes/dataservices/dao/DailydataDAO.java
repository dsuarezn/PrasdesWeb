package co.gov.ideam.prasdes.dataservices.dao;

import java.util.List;

import co.gov.ideam.prasdes.dataservices.entidades.Dailydata;
import co.gov.ideam.prasdes.dataservices.entidades.DailydataPK;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

public interface DailydataDAO extends GenericDAOInterface<Dailydata, DailydataPK> {

	
	public List<ConsultaResponseDTO> consultarInfoDiariaPorParametros(ConsultaRestFormDTO params);
	public void persistirInfoDiaria(List<Dailydata> datosDiarios);
	
	
	
}
