package co.gov.ideam.sshm.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.sshm.dataservices.dao.DailydataDAO;
import co.gov.ideam.sshm.dataservices.entidades.Dailydata;
import co.gov.ideam.sshm.web.dto.ConsultaResponseDTO;
import co.gov.ideam.sshm.web.dto.ConsultaRestFormDTO;

@Repository
@Transactional
@Qualifier("dailydataDAOImpl")
public class DailydataDAOImpl extends GenericDAOJPAImpl<Dailydata, Long> implements DailydataDAO {

	@Override
	public List<ConsultaResponseDTO> consultarInformacionDiaria(ConsultaRestFormDTO params) {
		Query query = em.createNamedQuery("Dailydata.findByParameters");				
		query.setParameter("pIdStation", params.getIdEstacion());
		query.setParameter("pIdVariable", params.getIdVariable());
		query.setParameter("pfechaIni", params.getFechaInicio());
		query.setParameter("pfechafin", params.getFechaFin());
		return (List<ConsultaResponseDTO>)query.setMaxResults(limiteRegistrosDiarios).getResultList();
	}

	@Override
	public void persistirInformacionDiaria(List<Dailydata> datosDiarios) {
		BatchUpdateWithEmSession(datosDiarios);	
	}

}
