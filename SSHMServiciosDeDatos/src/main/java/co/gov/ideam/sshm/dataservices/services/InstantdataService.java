package co.gov.ideam.sshm.dataservices.services;

import java.util.List;

import co.gov.ideam.sshm.dataservices.entidades.Instantdata;
import co.gov.ideam.sshm.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.sshm.web.dto.ConsultaRestFormDTO;

public interface InstantdataService {

	public void actualizarDatosInstantaneos(List<Instantdata> datosInstantaneos);
	public List<ConsultaResponseRawDataDTO> consultarDatosInstantaneosPorParametros(ConsultaRestFormDTO parametros);
	public List<ConsultaResponseRawDataDTO> consultarDatosInstantaneosPorParametrosPrasdes(ConsultaRestFormDTO parametros);
	
}
