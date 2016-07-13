package co.gov.ideam.prasdes.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.dao.MigTaskDAO;
import co.gov.ideam.prasdes.dataservices.entidades.MigTask;
import co.gov.ideam.prasdes.web.dto.MigTaskDTO;



@Repository
@Transactional
@Qualifier("migTaskDAOImpl")
public class MigTaskDAOImpl extends GenericDAOJPAImpl<MigTask, Long> implements MigTaskDAO {

	@Override
	public List<MigTaskDTO> obtenerListadoTareas() {
		Query query = em.createNamedQuery("MigTask.findAll");			
		return (List<MigTaskDTO>) query.getResultList();
	}
	
	
	@Override
	public MigTask obtenerTarea(Long tareaId) {
		return em.find(MigTask.class, tareaId);					
	}

	@Override
	public MigTask persistirTarea(MigTask tarea) {
		return update(tarea);
	}

	@Override
	public void eliminarTarea(MigTask tarea) {
		delete(tarea);
	}

}
