
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

import co.gov.ideam.prasdes.dataservices.entidades.Dailydata;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;


@RestController
@RequestMapping("/rest/dailydata")
public class DailydataRestController extends CommonController {    

	static final Logger logger = LogManager.getLogger(DailydataRestController.class.getName());

	@CrossOrigin
    @RequestMapping(value = "",
    		method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<ConsultaResponseDTO> consultarDatosDiarios(
    		@RequestParam(value = "c", required = true) String idCustomer,
    		@RequestParam(value = "e", required = false) Long idEstacion,
    		@RequestParam(value = "v", required = false) Long idVariable,
    		@RequestParam(value = "fi", required = false) String sfechaInicio,
    		@RequestParam(value = "ff", required = false) String sfechaFin,
    		@RequestParam(value = "p", required = false) Long idPeriod
    	){ 				
		ConsultaRestFormDTO datosConsulta = new ConsultaRestFormDTO(idEstacion,idVariable,idCustomer,sfechaInicio, sfechaFin, idPeriod);
    	System.out.println("Respondiento peticion rest (get)...");    	
    	return dailydataServiceImpl.consultarInfoDiariaPorParametros(datosConsulta);    	     
    }
          
    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)    
    public void actualizarDatosDiarios(@RequestBody String datosDiariosjson) {
    	System.out.println("Respondiento peticion rest (post)...");
    	datosDiariosjson = cleanJsonIncorrectFormat(datosDiariosjson);
    	ObjectMapper mapper = new ObjectMapper();    	 
		List<ConsultaResponseDTO> listaConsultaResponse = listFromJSON(new TypeReference<List<ConsultaResponseDTO>>() {}, datosDiariosjson);		
		
		Mapper dozerMapper = new DozerBeanMapper();    	
		List<Dailydata> datosDiarios = new ArrayList<Dailydata>();
        for (ConsultaResponseDTO datoConsulta : listaConsultaResponse) {        
        	Dailydata datoDiario= new Dailydata();
        	dozerMapper.map(datoConsulta, datoDiario);
        	datoDiario.setDDateadd(new Date());
        	if(datoDiario.getNIdflag()==null){
        		datoDiario.setNIdflag(flagNulosValues);
        	}
        	if(datoDiario.getNIdqc()==null){
        		datoDiario.setNIdqc(idqcNulosValues);
        	}
        	if(aceptarNulos==false){
        		if(datoConsulta.getnData()!=null){
        			datosDiarios.add(datoDiario);
        		}
        	}
        	else{
        		datosDiarios.add(datoDiario);
        	}        	        
		}    	   
        dailydataServiceImpl.actualizarInfoDiaria(datosDiarios);
    }            	 
}
