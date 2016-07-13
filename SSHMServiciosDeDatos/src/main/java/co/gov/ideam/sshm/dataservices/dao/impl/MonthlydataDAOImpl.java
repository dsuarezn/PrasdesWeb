package co.gov.ideam.sshm.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.sshm.dataservices.dao.MonthlydataDAO;

import co.gov.ideam.sshm.dataservices.entidades.Monthlydata;
import co.gov.ideam.sshm.web.dto.ConsultaResponseDTO;
import co.gov.ideam.sshm.web.dto.ConsultaRestFormDTO;

@Repository
@Transactional
@Qualifier("monthlydataDAOImpl")
public class MonthlydataDAOImpl extends GenericDAOJPAImpl<Monthlydata, Long> implements MonthlydataDAO {

	@Override
	public List<ConsultaResponseDTO> consultarInformacionDiaria(ConsultaRestFormDTO params) {
		Query query = em.createNamedQuery("Monthlydata.findByParameters");				
		query.setParameter("pIdStation", params.getIdEstacion());
		query.setParameter("pIdVariable", params.getIdVariable());
		query.setParameter("pfechaIni", params.getFechaInicio());
		query.setParameter("pfechafin", params.getFechaFin());
		return (List<ConsultaResponseDTO>)query.setMaxResults(limiteRegistrosInstananeos).getResultList();
	}

	@Override
	public void persistirInformacionDiaria(List<Monthlydata> datosMensuales) {
		 BatchUpdateWithEmSession(datosMensuales);			
	}

}
