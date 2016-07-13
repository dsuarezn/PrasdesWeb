package co.gov.ideam.prasdes.dataservices.services;

import java.util.List;

import co.gov.ideam.prasdes.dataservices.entidades.Monthlydata;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

public interface MonthlydataService {

	
	public List<ConsultaResponseDTO> consultarInfoMensualPorParametros(ConsultaRestFormDTO params);
	void actualizarInfoMensual(List<Monthlydata> datosMensuales);
}
