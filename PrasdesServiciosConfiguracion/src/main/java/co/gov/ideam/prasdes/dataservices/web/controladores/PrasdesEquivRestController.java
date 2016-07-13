package co.gov.ideam.prasdes.dataservices.web.controladores;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.gov.ideam.prasdes.dataservices.entidades.PrasdesEquiv;



@RestController
@RequestMapping("/rest/equiv")
public class PrasdesEquivRestController extends CommonController {

	static final Logger logger = LogManager.getLogger(PrasdesEquivRestController.class.getName());
	
	
	
	
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<PrasdesEquiv> consultarEquivalenciasVariables(
    		@RequestParam(value = "t", required = false) String type,
    		@RequestParam(value = "p", required = false) String prasdesval,
    		@RequestParam(value = "i", required = false) String ideamval
    	) {
    	logger.info("Respondiento peticion rest (get)...");
//    	return connectionServiceImpl.obtenerListadoConexionesActivas();
    	return prasdesEquivServiceImpl.obtenerEquivalenciasPorParametro(type, ideamval, prasdesval);
    }
	
	
}
