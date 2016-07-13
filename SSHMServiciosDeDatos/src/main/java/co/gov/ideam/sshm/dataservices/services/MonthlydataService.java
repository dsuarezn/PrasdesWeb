package co.gov.ideam.sshm.dataservices.services;

import java.util.List;

import co.gov.ideam.sshm.dataservices.entidades.Monthlydata;
import co.gov.ideam.sshm.web.dto.ConsultaResponseDTO;
import co.gov.ideam.sshm.web.dto.ConsultaRestFormDTO;

public interface MonthlydataService {

	public void actualizarDatosMensuales(List<Monthlydata> datosMensuales);
	public List<ConsultaResponseDTO> consultarDatosMensualesPorParametros(ConsultaRestFormDTO parametros);
	
}
