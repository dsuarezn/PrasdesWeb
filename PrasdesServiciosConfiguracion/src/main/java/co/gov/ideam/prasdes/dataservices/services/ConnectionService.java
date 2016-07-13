package co.gov.ideam.prasdes.dataservices.services;

import java.util.List;

import co.gov.ideam.prasdes.web.dto.ConnectionDTO;

public interface ConnectionService {

	public List<ConnectionDTO> obtenerListadoConexionesActivas();
	
}
