package co.gov.ideam.sshm.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.sshm.dataservices.entidades.Dailydata;
import co.gov.ideam.sshm.dataservices.services.DailydataService;
import co.gov.ideam.sshm.web.dto.ConsultaResponseDTO;
import co.gov.ideam.sshm.web.dto.ConsultaRestFormDTO;

@Transactional
@Service
@Qualifier("dailydataServiceImpl")
public class DailydataServiceImpl extends ServiceCommons implements DailydataService {

	@Override
	public void actualizarDatosDiarios(List<Dailydata> datosDiarios) {
		daoFactory.getDailydataDAOImpl().persistirInformacionDiaria(datosDiarios);
	}

	@Override
	public List<ConsultaResponseDTO> consultarDatosDiariosPorParametros(ConsultaRestFormDTO parametros) {
		return daoFactory.getDailydataDAOImpl().consultarInformacionDiaria(parametros);
	}

	@Override
	public List<ConsultaResponseDTO> consultarDatosDiariosPorParametrosPrasdes(ConsultaRestFormDTO parametros) {
		List<ConsultaResponseDTO> lista=daoFactory.getDailydataDAOImpl().consultarInformacionDiariaPrasdes(parametros);
		return lista;
	}

}
