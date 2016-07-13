package co.gov.ideam.prasdes.dataservices.dao;

import java.util.List;

import co.gov.ideam.prasdes.dataservices.entidades.MigTask;
import co.gov.ideam.prasdes.web.dto.MigTaskDTO;

public interface MigTaskDAO {

	public MigTask obtenerTarea(Long tareaId);
	public List<MigTaskDTO> obtenerListadoTareas();
	public MigTask persistirTarea(MigTask tarea);
	public void eliminarTarea(MigTask tarea);
	
}
