package co.gov.ideam.prasdes.dataservices.dao;

import java.util.List;

import co.gov.ideam.prasdes.web.dto.ConnectionDTO;

public interface ConnectionDAO {

	public List<ConnectionDTO> obtenerListadoConexionesActivas();

}
