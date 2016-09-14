package co.gov.ideam.sshm.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import co.gov.ideam.sshm.dataservices.entidades.Instantdata;
import co.gov.ideam.sshm.dataservices.services.InstantdataService;
import co.gov.ideam.sshm.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.sshm.web.dto.ConsultaRestFormDTO;

@Transactional
@Service
@Qualifier("instantdataServiceImpl")
public class InstantdataServiceImpl extends ServiceCommons implements InstantdataService {

	@Override
	public void actualizarDatosInstantaneos(List<Instantdata> datosInstantaneos) {
		daoFactory.getInstantdataDAOImpl().persistirInformacionInstantanea(datosInstantaneos);
	}

	@Override
	public List<ConsultaResponseRawDataDTO> consultarDatosInstantaneosPorParametros(ConsultaRestFormDTO parametros) {
		return daoFactory.getInstantdataDAOImpl().consultarInformacionInstantanea(parametros);
	}
	
	@Override
	public List<ConsultaResponseRawDataDTO> consultarDatosInstantaneosPorParametrosPrasdes(ConsultaRestFormDTO parametros) {
		return daoFactory.getInstantdataDAOImpl().consultarInformacionInstantaneaPrasdes(parametros);
		
	}

}
