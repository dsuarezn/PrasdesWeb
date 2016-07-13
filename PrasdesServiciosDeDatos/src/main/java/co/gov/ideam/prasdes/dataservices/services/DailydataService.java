package co.gov.ideam.prasdes.dataservices.services;


import java.util.List;

import co.gov.ideam.prasdes.dataservices.entidades.Dailydata;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

public interface DailydataService {
	
	
	public List<ConsultaResponseDTO> consultarInfoDiariaPorParametros(ConsultaRestFormDTO params);
	public void actualizarInfoDiaria(List<Dailydata> datosDiarios);

}
