package co.gov.ideam.prasdes.dataservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ideam.prasdes.dataservices.entidades.MigTask;
import co.gov.ideam.prasdes.dataservices.services.MigTaskService;
import co.gov.ideam.prasdes.web.dto.MigTaskDTO;

@Transactional
@Service
@Qualifier("migTaskServiceImpl")
public class MigTaskServiceImpl extends ServiceCommons implements MigTaskService {

	@Override
	public List<MigTaskDTO> obtenerListadoTareas() {
		return daoFactory.getMigTaskDAOImpl().obtenerListadoTareas();
	}

	@Override
	public MigTask persistirTarea(MigTask tarea) {
		return daoFactory.getMigTaskDAOImpl().persistirTarea(tarea);
	}

	@Override
	public void eliminarTarea(MigTask tarea) {
		daoFactory.getMigTaskDAOImpl().eliminarTarea(tarea);
	}

	@Override
	public MigTask obtenerTareas(Long tareaId) {
		return daoFactory.getMigTaskDAOImpl().obtenerTarea(tareaId);
	}

}
