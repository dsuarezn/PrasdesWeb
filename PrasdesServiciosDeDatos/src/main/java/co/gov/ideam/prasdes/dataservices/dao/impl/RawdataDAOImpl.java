package co.gov.ideam.prasdes.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import co.gov.ideam.prasdes.dataservices.dao.RawdataDAO;
import co.gov.ideam.prasdes.dataservices.entidades.Rawdata;
import co.gov.ideam.prasdes.dataservices.entidades.RawdataPK;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

@Repository
@Transactional
@Qualifier("rawdataDAOImpl")
public class RawdataDAOImpl extends GenericDAOJPAImpl<Rawdata, RawdataPK> implements RawdataDAO {

	@Override
	public List<ConsultaResponseRawDataDTO> consultarInfoCrudaPorParametros(ConsultaRestFormDTO params) {
		Query query = em.createNamedQuery("Rawdata.findByParametersToConsulta");
		String idCustomer = (StringUtils.isEmpty(params.getIdCustomer()) ? null :params.getIdCustomer());
		query.setParameter("pCodCliente", idCustomer);
		query.setParameter("pIdEstacion", params.getIdEstacion());
		query.setParameter("pIdVariable", params.getIdVariable());
		query.setParameter("pFechaIni", params.getFechaInicio());
		query.setParameter("pFechaFin", params.getFechaFin());
		query.setParameter("pIdperiod", params.getIdPeriod());
		return (List<ConsultaResponseRawDataDTO>)query.setMaxResults(limiteRegistrosCrudos).getResultList();
	}

	@Override
	public void persistirInfoCruda(List<Rawdata> rawData) {		
			BatchUpdateWithEmSession(rawData);
	}

	

	


}
