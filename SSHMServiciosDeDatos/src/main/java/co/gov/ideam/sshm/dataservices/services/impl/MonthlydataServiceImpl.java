package co.gov.ideam.sshm.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.sshm.dataservices.entidades.Monthlydata;
import co.gov.ideam.sshm.dataservices.services.MonthlydataService;
import co.gov.ideam.sshm.web.dto.ConsultaResponseDTO;
import co.gov.ideam.sshm.web.dto.ConsultaRestFormDTO;

@Transactional
@Service
@Qualifier("monthlydataServiceImpl")
public class MonthlydataServiceImpl extends ServiceCommons implements MonthlydataService {

	@Override
	public void actualizarDatosMensuales(List<Monthlydata> datosMensuales) {
		daoFactory.getMonthlydataDAOImpl().persistirInformacionDiaria(datosMensuales);
	}

	@Override
	public List<ConsultaResponseDTO> consultarDatosMensualesPorParametros(ConsultaRestFormDTO parametros) {
		return daoFactory.getMonthlydataDAOImpl().consultarInformacionDiaria(parametros);
	}

	@Override
	public List<ConsultaResponseDTO> consultarDatosMensualesPorParametrosPrasdes(ConsultaRestFormDTO parametros) {
		List<ConsultaResponseDTO> lista=daoFactory.getMonthlydataDAOImpl().consultarInformacionDiariaPrasdes(parametros);
		return lista;
	}

}
