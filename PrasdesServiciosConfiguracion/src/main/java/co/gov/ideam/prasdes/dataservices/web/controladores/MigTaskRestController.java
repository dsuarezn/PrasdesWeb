package co.gov.ideam.prasdes.dataservices.web.controladores;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.ideam.prasdes.dataservices.entidades.MigTask;
import co.gov.ideam.prasdes.web.dto.MigTaskDTO;

@RestController
@RequestMapping("/rest/migtask")
public class MigTaskRestController extends CommonController {

	static final Logger logger = LogManager.getLogger(MigTaskRestController.class.getName());
	
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<MigTaskDTO> consultarTareas() {     	
    	logger.info("Respondiento peticion rest (get)...");
    	return migTaskServiceImpl.obtenerListadoTareas();    	     
    }
	
	@CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")    
    public @ResponseBody MigTask actulizarTarea(@RequestBody String jsonTarea) {
    	logger.info("Respondiento peticion rest (post)...");	    	
    	ObjectMapper mapper = new ObjectMapper();    	 
    	MigTask tarea = null;
		try {
			tarea = mapper.readValue(jsonTarea, MigTask.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
    	return migTaskServiceImpl.persistirTarea(tarea);	    
    }
	
//	@CrossOrigin
//    @RequestMapping(value = "", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)    
//    public void eliminarTarea(@RequestBody String jsonTarea) {
//    	logger.info("Respondiento peticion rest (post)...");	    	
//    	ObjectMapper mapper = new ObjectMapper();    	 
//    	MigTask tarea = null;
//		try {
//			tarea = mapper.readValue(jsonTarea, MigTask.class);
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		
//    	migTaskServiceImpl.eliminarTarea(tarea);	    
//    }
	
	@CrossOrigin
    @RequestMapping(value = "/{jobId}", method = RequestMethod.DELETE)    
    public void eliminar(@PathVariable("jobId") Long jobId) {
    	logger.info("Respondiento delete peticion rest (post)...");	    	
    	MigTask tarea = migTaskServiceImpl.obtenerTareas(jobId); 			
    	migTaskServiceImpl.eliminarTarea(tarea);	    
    }
	
}
