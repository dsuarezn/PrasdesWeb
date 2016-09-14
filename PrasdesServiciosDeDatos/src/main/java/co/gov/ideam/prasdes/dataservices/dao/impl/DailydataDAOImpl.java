package co.gov.ideam.prasdes.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import co.gov.ideam.prasdes.dataservices.dao.DailydataDAO;
import co.gov.ideam.prasdes.dataservices.entidades.Dailydata;
import co.gov.ideam.prasdes.dataservices.entidades.DailydataPK;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

@Repository
@Transactional
@Qualifier("dailydataDAOImpl")
public class DailydataDAOImpl extends GenericDAOJPAImpl<Dailydata, DailydataPK> implements DailydataDAO {

	

	
	@Override
	public void persistirInfoDiaria(List<Dailydata> entities) {		
		BatchUpdateWithEmSession(entities);		
	}

	@Override
	public List<ConsultaResponseDTO> consultarInfoDiariaPorParametros(ConsultaRestFormDTO params) {
		Query query = em.createNamedQuery("Dailydata.findByParametersToConsulta");
		String idCustomer = (StringUtils.isEmpty(params.getIdCustomer()) ? null :params.getIdCustomer());
		query.setParameter("pCodCliente", idCustomer);
		query.setParameter("pIdEstacion", params.getIdEstacion());
		query.setParameter("pIdVariable", params.getIdVariable());
		query.setParameter("pFechaIni", params.getFechaInicio());
		query.setParameter("pFechaFin", params.getFechaFin());
		return (List<ConsultaResponseDTO>) (limiteRegistrosDiarios==0 ? query.getResultList() : query.setMaxResults(limiteRegistrosDiarios).getResultList());							
	}
	

	

}
