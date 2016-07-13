package co.gov.ideam.sshm.dataservices.dao;

import java.util.List;

import co.gov.ideam.sshm.dataservices.entidades.Dailydata;
import co.gov.ideam.sshm.web.dto.ConsultaResponseDTO;
import co.gov.ideam.sshm.web.dto.ConsultaRestFormDTO;

public interface DailydataDAO {
	
	public List<ConsultaResponseDTO> consultarInformacionDiaria(ConsultaRestFormDTO params);
	public void persistirInformacionDiaria(List<Dailydata> datosDiarios);
}
