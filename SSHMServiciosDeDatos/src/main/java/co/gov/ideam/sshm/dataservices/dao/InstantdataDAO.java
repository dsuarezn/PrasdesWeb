package co.gov.ideam.sshm.dataservices.dao;

import java.util.List;

import co.gov.ideam.sshm.dataservices.entidades.Dailydata;
import co.gov.ideam.sshm.dataservices.entidades.Instantdata;
import co.gov.ideam.sshm.web.dto.ConsultaResponseDTO;
import co.gov.ideam.sshm.web.dto.ConsultaRestFormDTO;

public interface InstantdataDAO {

	
	public List<ConsultaResponseDTO> consultarInformacionInstantanea(ConsultaRestFormDTO params);
	public void persistirInformacionInstantanea(List<Instantdata> datosInstantaneos);
	public List<ConsultaResponseDTO> consultarInformacionInstantaneaPrasdes(ConsultaRestFormDTO params);
}
