package co.gov.ideam.sshm.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.sshm.dataservices.dao.DailydataDAO;
import co.gov.ideam.sshm.dataservices.dao.InstantdataDAO;
import co.gov.ideam.sshm.dataservices.entidades.Dailydata;
import co.gov.ideam.sshm.dataservices.entidades.Instantdata;
import co.gov.ideam.sshm.web.dto.ConsultaResponseDTO;
import co.gov.ideam.sshm.web.dto.ConsultaRestFormDTO;

@Repository
@Transactional
@Qualifier("instantdataDAOImpl")
public class InstantdataDAOImpl extends GenericDAOJPAImpl<Instantdata, Long> implements InstantdataDAO {

	@Override
	public List<ConsultaResponseDTO> consultarInformacionInstantanea(ConsultaRestFormDTO params) {
		Query query = em.createNamedQuery("Instantdata.findByParameters");				
		query.setParameter("pIdStation", params.getIdEstacion());
		query.setParameter("pIdVariable", params.getIdVariable());
		query.setParameter("pfechaIni", params.getFechaInicio());
		query.setParameter("pfechafin", params.getFechaFin());
		return (List<ConsultaResponseDTO>)query.setMaxResults(limiteRegistrosInstananeos).getResultList();
	}

	@Override
	public void persistirInformacionInstantanea(List<Instantdata> datosInstantaneos) {
		BatchUpdateWithEmSession(datosInstantaneos);	
	}

}
