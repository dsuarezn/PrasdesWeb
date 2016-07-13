package co.gov.ideam.sshm.dataservices.services;

import java.util.List;

import co.gov.ideam.sshm.dataservices.entidades.Dailydata;
import co.gov.ideam.sshm.web.dto.ConsultaResponseDTO;
import co.gov.ideam.sshm.web.dto.ConsultaRestFormDTO;

public interface DailydataService {

	public void actualizarDatosDiarios(List<Dailydata> datosDiarios);
	public List<ConsultaResponseDTO> consultarDatosDiariosPorParametros(ConsultaRestFormDTO parametros);
	
}
