
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

import co.gov.ideam.prasdes.dataservices.entidades.Instantdata;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

@RestController
@RequestMapping("/rest/instantdata")
public class InstantdataRestController extends CommonController {
    
	static final Logger logger = LogManager.getLogger(InstantdataRestController.class.getName());
	
	@CrossOrigin
    @RequestMapping(value = "",
    		method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<ConsultaResponseRawDataDTO> consultarDatosInstantaneos(
    		@RequestParam(value = "c", required = true) String idCustomer,
    		@RequestParam(value = "e", required = false) Long idEstacion,
    		@RequestParam(value = "v", required = false) Long idVariable,
    		@RequestParam(value = "fi", required = false) String sfechaInicio,
    		@RequestParam(value = "ff", required = false) String sfechaFin,
    		@RequestParam(value = "p", required = false) Long idPeriod
    	) {
		ConsultaRestFormDTO datosConsulta = new ConsultaRestFormDTO(idEstacion,idVariable,idCustomer,sfechaInicio, sfechaFin, idPeriod);
    	List<ConsultaResponseRawDataDTO> lista = instantdataServiceImpl.consultarInfoInstantaneaPorParametros(datosConsulta);
    	return lista;
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
        	datoInstantaneo.setDDateadd(new Date());
        	if(aceptarNulos==false){
        		if(datoConsulta.getnData()!=null){
        			datosInstantaneos.add(datoInstantaneo);
        		}
        	}
        	else{
        		datosInstantaneos.add(datoInstantaneo);
        	}        	
		}    	   
        instantdataServiceImpl.actualizarInfoInstantanea(datosInstantaneos);        
    }
}
