package co.gov.ideam.prasdes.dataservices.services;

import java.util.List;

import co.gov.ideam.prasdes.dataservices.entidades.Customerstationvar;
import co.gov.ideam.prasdes.web.dto.CustomerStationVarDTO;

public interface CustomerStationVarService {

	public List<CustomerStationVarDTO> obtenerListadoCustomerStVar();
	public Customerstationvar persistirCustomerStationVar(Customerstationvar customVar);
	public void eliminarCustomerStationVar(Customerstationvar customVar);
	
}
