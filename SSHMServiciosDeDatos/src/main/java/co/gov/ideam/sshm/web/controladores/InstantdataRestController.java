
package co.gov.ideam.sshm.web.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.ideam.sshm.dataservices.entidades.Instantdata;
import co.gov.ideam.sshm.web.dto.ConsultaResponseDTO;
import co.gov.ideam.sshm.web.dto.ConsultaRestFormDTO;

@RestController
@RequestMapping("/rest/instantdata")
public class InstantdataRestController extends CommonController {
    
	static final Logger logger = LogManager.getLogger(InstantdataRestController.class.getName());
	
	@CrossOrigin
    @RequestMapping(value = "",
    		method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<ConsultaResponseDTO> consultarDatosInstantaneos(
    		@RequestParam(value = "c", required = false) String idCustomer,
    		@RequestParam(value = "e", required = false) Long idEstacion,
    		@RequestParam(value = "v", required = false) String idVariable,
    		@RequestParam(value = "fi", required = false) String sfechaInicio,
    		@RequestParam(value = "ff", required = false) String sfechaFin,
    		@RequestParam(value = "p", required = false) Long idPeriod,
    		@RequestParam(value = "type", required = false) String type
    	) {
		ConsultaRestFormDTO datosConsulta = new ConsultaRestFormDTO(idEstacion,idVariable,idCustomer,sfechaInicio, sfechaFin, idPeriod);
    	
		if("prasdes".equals(type)){
    		return instantdataServiceImpl.consultarDatosInstantaneosPorParametrosPrasdes(datosConsulta); 
    	}
		
    	return instantdataServiceImpl.consultarDatosInstantaneosPorParametros(datosConsulta);
    }
    
    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)    
    public void actualizarDatosInstantaneos(@RequestBody String datosInstantaneosjson) {
    	logger.info("Respondiento peticion rest (post)...");
    	datosInstantaneosjson = cleanJsonIncorrectFormat(datosInstantaneosjson);    	  	
		List<ConsultaResponseDTO> listaConsultaResponse = listFromJSON(new TypeReference<List<ConsultaResponseDTO>>() {}, datosInstantaneosjson);				
		Mapper dozerMapper = new DozerBeanMapper();    	
		List<Instantdata> datosInstantaneos = new ArrayList<Instantdata>();
        for (ConsultaResponseDTO datoConsulta : listaConsultaResponse) {        
        	Instantdata datoInstantaneo= new Instantdata();
        	dozerMapper.map(datoConsulta, datoInstantaneo);
        	datoInstantaneo.setDate(new Date());
        	datosInstantaneos.add(datoInstantaneo);
		}    	   
        instantdataServiceImpl.actualizarDatosInstantaneos(datosInstantaneos);
    }
}
