package co.gov.ideam.prasdes.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import co.gov.ideam.prasdes.dataservices.dao.MonthlydataDAO;
import co.gov.ideam.prasdes.dataservices.entidades.Monthlydata;
import co.gov.ideam.prasdes.dataservices.entidades.MonthlydataPK;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

@Repository
@Transactional
@Qualifier("monthlydataDAOImpl")
public class MonthlydataDAOImpl extends GenericDAOJPAImpl<Monthlydata, MonthlydataPK>
		implements MonthlydataDAO {


	@Override
	public List<ConsultaResponseDTO> consultarInfoMensualPorParametros(ConsultaRestFormDTO params) {
		Query query = em.createNamedQuery("Monthlydata.findByParametersToConsulta");
		String idCustomer = (StringUtils.isEmpty(params.getIdCustomer()) ? null :params.getIdCustomer());
		query.setParameter("pCodCliente", idCustomer);
		query.setParameter("pIdEstacion", params.getIdEstacion());
		query.setParameter("pIdVariable", params.getIdVariable());
		query.setParameter("pFechaIni", params.getFechaInicio());
		query.setParameter("pFechaFin", params.getFechaFin());		
		return (List<ConsultaResponseDTO>) (limiteRegistrosMensuales==0 ? query.getResultList() : query.setMaxResults(limiteRegistrosMensuales).getResultList());
	}
	
	@Override
	public void persistirInfoMensual(List<Monthlydata> entities) {		
		BatchUpdateWithEmSession(entities);
	}

}
