package co.gov.ideam.prasdes.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.dao.StationDAO;
import co.gov.ideam.prasdes.dataservices.entidades.Station;

@Repository
@Transactional
@Qualifier("stationDAOImpl")
public class StationDAOImpl extends GenericDAOJPAImpl<Station, Long> implements StationDAO {

	@Override
	public List<Station> obtenerListaEstaciones() {		
		Query query = em.createNamedQuery("Station.findAll");			
		return (List<Station>) query.getResultList();				
	}

}
