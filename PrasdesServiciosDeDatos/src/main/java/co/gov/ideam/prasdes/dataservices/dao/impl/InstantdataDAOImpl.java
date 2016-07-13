package co.gov.ideam.prasdes.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import co.gov.ideam.prasdes.dataservices.dao.InstantdataDAO;
import co.gov.ideam.prasdes.dataservices.entidades.Instantdata;
import co.gov.ideam.prasdes.dataservices.entidades.InstantdataPK;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

@Repository
@Transactional
@Qualifier("instantdataDAOImpl")
public class InstantdataDAOImpl extends GenericDAOJPAImpl<Instantdata, InstantdataPK>
		implements InstantdataDAO {

	

	@Override
	public List<ConsultaResponseRawDataDTO> consultarInfoInstantaneaPorParametros(ConsultaRestFormDTO params) {
		Query query = em.createNamedQuery("Instantdata.findByParametersToObjects");
		String idCustomer = (StringUtils.isEmpty(params.getIdCustomer()) ? null :params.getIdCustomer());
		query.setParameter("pCodCliente", idCustomer);
		query.setParameter("pIdEstacion", params.getIdEstacion());
		query.setParameter("pIdVariable", params.getIdVariable());
		query.setParameter("pFechaIni", params.getFechaInicio());
		query.setParameter("pFechaFin", params.getFechaFin());		
		return (List<ConsultaResponseRawDataDTO>) (limiteRegistrosInstananeos==0 ? query.getResultList() : query.setMaxResults(limiteRegistrosInstananeos).getResultList());
	}
	
	@Override
	public void persistirInfoInstantanea(List<Instantdata> entities) {		
		BatchUpdateWithEmSession(entities);
	}

}
