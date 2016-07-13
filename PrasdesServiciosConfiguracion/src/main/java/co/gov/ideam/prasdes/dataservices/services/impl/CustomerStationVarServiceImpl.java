package co.gov.ideam.prasdes.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.entidades.Customerstationvar;
import co.gov.ideam.prasdes.dataservices.services.CustomerStationVarService;
import co.gov.ideam.prasdes.web.dto.CustomerStationVarDTO;

@Transactional
@Service
@Qualifier("customerStationVarServiceImpl")
public class CustomerStationVarServiceImpl extends ServiceCommons  implements CustomerStationVarService {

	@Override
	public List<CustomerStationVarDTO> obtenerListadoCustomerStVar() {
		return daoFactory.getCustomerStationVarDAOImpl().obtenerListadoCustomerStVar();
	}

	@Override
	public Customerstationvar persistirCustomerStationVar(Customerstationvar customVar) {
		return daoFactory.getCustomerStationVarDAOImpl().persistirCustomerStationVar(customVar);
	}

	@Override
	public void eliminarCustomerStationVar(Customerstationvar customVar) {
		daoFactory.getCustomerStationVarDAOImpl().eliminarCustomerStationVar(customVar);
	}

}
