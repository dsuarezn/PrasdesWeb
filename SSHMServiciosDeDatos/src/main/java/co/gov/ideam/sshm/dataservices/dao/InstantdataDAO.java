package co.gov.ideam.sshm.dataservices.dao;

import java.util.List;

import co.gov.ideam.sshm.dataservices.entidades.Instantdata;
import co.gov.ideam.sshm.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.sshm.web.dto.ConsultaRestFormDTO;

public interface InstantdataDAO {

	
	public List<ConsultaResponseRawDataDTO> consultarInformacionInstantanea(ConsultaRestFormDTO params);
	public void persistirInformacionInstantanea(List<Instantdata> datosInstantaneos);
	public List<ConsultaResponseRawDataDTO> consultarInformacionInstantaneaPrasdes(ConsultaRestFormDTO params);
}
