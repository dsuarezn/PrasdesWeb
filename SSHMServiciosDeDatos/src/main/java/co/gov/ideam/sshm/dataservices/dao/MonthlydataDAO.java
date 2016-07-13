package co.gov.ideam.sshm.dataservices.dao;

import java.util.List;

import co.gov.ideam.sshm.dataservices.entidades.Dailydata;
import co.gov.ideam.sshm.dataservices.entidades.Monthlydata;
import co.gov.ideam.sshm.web.dto.ConsultaResponseDTO;
import co.gov.ideam.sshm.web.dto.ConsultaRestFormDTO;

public interface MonthlydataDAO {

	public List<ConsultaResponseDTO> consultarInformacionDiaria(ConsultaRestFormDTO params);
	public void persistirInformacionDiaria(List<Monthlydata> datosMensuales);
}
