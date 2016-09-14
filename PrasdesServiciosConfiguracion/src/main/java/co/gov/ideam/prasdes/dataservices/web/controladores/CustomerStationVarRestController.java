package co.gov.ideam.prasdes.dataservices.web.controladores;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.ideam.prasdes.dataservices.entidades.Customerstationvar;
import co.gov.ideam.prasdes.dataservices.entidades.MigTask;
import co.gov.ideam.prasdes.web.dto.CustomerStationVarDTO;

@RestController
@RequestMapping("/rest/customerStationVar")
public class CustomerStationVarRestController extends CommonController{

static final Logger logger = LogManager.getLogger(CustomerStationVarRestController.class.getName());
	
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<CustomerStationVarDTO> consultarStationVar() {     	
    	System.out.println("Respondiento peticion rest (get)...");
    	return customerStationVarServiceImpl.obtenerListadoCustomerStVar();   	     
    }
	
	@CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")    
    public @ResponseBody Customerstationvar actualizarStationVar(@RequestBody String jsonStationvar) {
    	System.out.println("Respondiento peticion rest (post)...");	    	
    	ObjectMapper mapper = new ObjectMapper();    	 
    	CustomerStationVarDTO cstationvar = null;
		try {
			cstationvar = mapper.readValue(jsonStationvar, CustomerStationVarDTO.class);
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
		
    	return customerStationVarServiceImpl.persistirCustomerStationVar(cstationvar.getCustomerStationVar());	    
    }
	
	@CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")    
    public void eliminarStationVar(@RequestBody String jsonStationvar) {
    	System.out.println("Respondiento peticion rest (post)...");	    	
    	ObjectMapper mapper = new ObjectMapper();    	 
    	CustomerStationVarDTO cstationvar = null;
		try {
			cstationvar = mapper.readValue(jsonStationvar, CustomerStationVarDTO.class);
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
		
    	customerStationVarServiceImpl.eliminarCustomerStationVar(cstationvar.getCustomerStationVar());	    
    }
	
}
