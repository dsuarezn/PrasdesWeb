package co.gov.ideam.prasdes.dataservices.dao;

import java.util.List;

import co.gov.ideam.prasdes.dataservices.entidades.Monthlydata;
import co.gov.ideam.prasdes.dataservices.entidades.MonthlydataPK;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

public interface MonthlydataDAO extends GenericDAOInterface<Monthlydata, MonthlydataPK> {

	
	public List<ConsultaResponseDTO> consultarInfoMensualPorParametros(ConsultaRestFormDTO params);
	void persistirInfoMensual(List<Monthlydata> entities);
}
