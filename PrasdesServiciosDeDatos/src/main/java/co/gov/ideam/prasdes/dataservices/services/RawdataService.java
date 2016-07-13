package co.gov.ideam.prasdes.dataservices.services;


import java.util.List;

import co.gov.ideam.prasdes.dataservices.entidades.Rawdata;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

public interface RawdataService {
	
	
	public List<ConsultaResponseRawDataDTO> consultarInfoCrudaPorParametros(ConsultaRestFormDTO params);
	public void actualizarInfoCrudos(List<Rawdata> datosCrudos);

}
