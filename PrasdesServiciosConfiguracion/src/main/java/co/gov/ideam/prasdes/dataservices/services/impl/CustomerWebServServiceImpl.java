package co.gov.ideam.prasdes.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.entidades.Customerwebserv;
import co.gov.ideam.prasdes.dataservices.services.CustomerWebServService;

@Transactional
@Service
@Qualifier("customerWebServServiceImpl")
public class CustomerWebServServiceImpl extends ServiceCommons  implements CustomerWebServService {

	@Override
	public List<Customerwebserv> obtenerCustomerWebServ() {
		return daoFactory.getCustomerWebServiceDAOImpl().obtenerListaCustomersWebServ();
	}

}
