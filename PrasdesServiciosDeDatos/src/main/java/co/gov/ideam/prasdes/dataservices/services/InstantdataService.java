package co.gov.ideam.prasdes.dataservices.services;

import java.util.List;

import co.gov.ideam.prasdes.dataservices.entidades.Instantdata;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

public interface InstantdataService {
	
	public List<ConsultaResponseRawDataDTO> consultarInfoInstantaneaPorParametros(ConsultaRestFormDTO params);
	void actualizarInfoInstantanea(List<Instantdata> datosDiarios);
}
