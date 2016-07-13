package co.gov.ideam.prasdes.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.entidades.Monthlydata;
import co.gov.ideam.prasdes.dataservices.services.MonthlydataService;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

@Transactional
@Service
@Qualifier("monthlydataServiceImpl")
public class MonthlydataServiceImpl extends ServiceCommons implements MonthlydataService {



	@Override
	public List<ConsultaResponseDTO> consultarInfoMensualPorParametros(ConsultaRestFormDTO params) {
		return daoFactory.getMonthlydataDAOImpl().consultarInfoMensualPorParametros(params);
	}
	
	@Override
	public void actualizarInfoMensual(List<Monthlydata> datosMensuales) {
		daoFactory.getMonthlydataDAOImpl().persistirInfoMensual(datosMensuales);
	}
}
