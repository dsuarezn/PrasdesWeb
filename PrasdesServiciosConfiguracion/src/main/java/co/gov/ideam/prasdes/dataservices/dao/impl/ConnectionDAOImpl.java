package co.gov.ideam.prasdes.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.dao.ConnectionDAO;
import co.gov.ideam.prasdes.dataservices.entidades.Connection;
import co.gov.ideam.prasdes.web.dto.ConnectionDTO;

@Repository
@Transactional
@Qualifier("connectionDAOImpl")
public class ConnectionDAOImpl extends GenericDAOJPAImpl<Connection, String> implements ConnectionDAO {

	@Override
	public List<ConnectionDTO> obtenerListadoConexionesActivas(){
		Query query = em.createNamedQuery("Connection.findActiveConnections");			
		return (List<ConnectionDTO>) query.getResultList();
	}
	
}
