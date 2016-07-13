package co.gov.ideam.prasdes.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.services.ConnectionService;
import co.gov.ideam.prasdes.web.dto.ConnectionDTO;

@Transactional
@Service
@Qualifier("connectionServiceImpl")
public class ConnectionServiceImpl extends ServiceCommons implements ConnectionService {

	@Override
	public List<ConnectionDTO> obtenerListadoConexionesActivas() {
		return daoFactory.getConnectionServiceImpl().obtenerListadoConexionesActivas();
	}

}
