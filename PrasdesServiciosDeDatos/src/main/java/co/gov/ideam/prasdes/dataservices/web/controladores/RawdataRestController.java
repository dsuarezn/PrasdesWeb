
package co.gov.ideam.prasdes.dataservices.web.controladores;

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

import co.gov.ideam.prasdes.dataservices.entidades.Rawdata;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;


@RestController
@RequestMapping("/rest/rawdata")
public class RawdataRestController extends CommonController {    

	static final Logger logger = LogManager.getLogger(RawdataRestController.class.getName());

	@CrossOrigin
    @RequestMapping(value = "",
    		method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<ConsultaResponseRawDataDTO> consultarDatosCrudos(
    		@RequestParam(value = "c", required = true) String idCustomer,
    		@RequestParam(value = "e", required = false) Long idEstacion,
    		@RequestParam(value = "v", required = false) Long idVariable,
    		@RequestParam(value = "fi", required = false) String sfechaInicio,
    		@RequestParam(value = "ff", required = false) String sfechaFin,
    		@RequestParam(value = "p", required = false) Long idPeriod
    	){    
		ConsultaRestFormDTO datosConsulta = new ConsultaRestFormDTO(idEstacion,idVariable,idCustomer,sfechaInicio, sfechaFin, idPeriod);
    	logger.info("Respondiento peticion rest (get)...");    	
    	return rawdataServiceImpl.consultarInfoCrudaPorParametros(datosConsulta);    	     
    }
          
    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)    
    public void actualizarDatosDiarios(@RequestBody String datosCrudosjson) {
    	logger.info("Respondiento peticion rest (post)...");
    	datosCrudosjson = cleanJsonIncorrectFormat(datosCrudosjson);
    	ObjectMapper mapper = new ObjectMapper();    	 
		List<ConsultaResponseRawDataDTO> listaConsultaResponse = listFromJSON(new TypeReference<List<ConsultaResponseRawDataDTO>>() {}, datosCrudosjson);		
		
		Mapper dozerMapper = new DozerBeanMapper();    	
		List<Rawdata> datosCrudos = new ArrayList<Rawdata>();
        for (ConsultaResponseRawDataDTO datoConsulta : listaConsultaResponse) {        
        	Rawdata datoCrudo= new Rawdata();
        	dozerMapper.map(datoConsulta, datoCrudo);
        	datoCrudo.setDDateadd(new Date());
        	if(aceptarNulos==false){
        		if(datoConsulta.getsnData()!=null){
        			datosCrudos.add(datoCrudo);
        		}
        	}
        	else{
        		datosCrudos.add(datoCrudo);
        	}
        	
		}    	   
        rawdataServiceImpl.actualizarInfoCrudos(datosCrudos);
    }
    
    
    	
    
}
