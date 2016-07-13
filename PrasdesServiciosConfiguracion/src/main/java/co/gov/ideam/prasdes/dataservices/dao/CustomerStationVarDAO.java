package co.gov.ideam.prasdes.dataservices.dao;

import java.util.List;

import co.gov.ideam.prasdes.dataservices.entidades.Customerstationvar;
import co.gov.ideam.prasdes.web.dto.CustomerStationVarDTO;

public interface CustomerStationVarDAO {

		public List<CustomerStationVarDTO> obtenerListadoCustomerStVar();
		public Customerstationvar persistirCustomerStationVar(Customerstationvar customVar);
		public void eliminarCustomerStationVar(Customerstationvar customVar);
	
}
