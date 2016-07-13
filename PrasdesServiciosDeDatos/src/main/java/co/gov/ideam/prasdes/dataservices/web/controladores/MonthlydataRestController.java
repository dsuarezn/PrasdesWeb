
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

import co.gov.ideam.prasdes.dataservices.entidades.Monthlydata;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaRestFormDTO;

@RestController
@RequestMapping("/rest/monthlydata")
public class MonthlydataRestController extends CommonController {
    
	static final Logger logger = LogManager.getLogger(MonthlydataRestController.class.getName());

	@CrossOrigin
    @RequestMapping(value = "",
    		method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<ConsultaResponseDTO> consultarDatosMensuales(
    		@RequestParam(value = "c", required = true) String idCustomer,
    		@RequestParam(value = "e", required = false) Long idEstacion,
    		@RequestParam(value = "v", required = false) Long idVariable,
    		@RequestParam(value = "fi", required = false) String sfechaInicio,
    		@RequestParam(value = "ff", required = false) String sfechaFin,
    		@RequestParam(value = "p", required = false) Long idPeriod
    	) {
		ConsultaRestFormDTO datosConsulta = new ConsultaRestFormDTO(idEstacion,idVariable,idCustomer,sfechaInicio, sfechaFin, idPeriod);
    	return monthlydataServiceImpl.consultarInfoMensualPorParametros(datosConsulta);
    }
    
    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)    
    public void actualizarDatosInstantaneos(@RequestBody String datosMensualesjson) {
    	logger.info("Respondiento peticion rest (post)...");
    	datosMensualesjson = cleanJsonIncorrectFormat(datosMensualesjson);
    	ObjectMapper mapper = new ObjectMapper();    	 
		List<ConsultaResponseDTO> listaConsultaResponse = listFromJSON(new TypeReference<List<ConsultaResponseDTO>>() {}, datosMensualesjson);		
		
		Mapper dozerMapper = new DozerBeanMapper();    	
		List<Monthlydata> datosMensuales = new ArrayList<Monthlydata>();
        for (ConsultaResponseDTO datoConsulta : listaConsultaResponse) {        
        	Monthlydata datoMensual= new Monthlydata();
        	dozerMapper.map(datoConsulta, datoMensual);
        	datoMensual.setDDateadd(new Date());
        	if(aceptarNulos==false){
        		if(datoConsulta.getnData()!=null){
        			datosMensuales.add(datoMensual);
        		}
        	}
        	else{
        		datosMensuales.add(datoMensual);
        	}
        	
		}    	   
        monthlydataServiceImpl.actualizarInfoMensual(datosMensuales);
    }
    
}
