package com.gov.ideam.prasdes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gov.ideam.prasdes.rest.RestAdapter;

import co.gov.ideam.prasdes.dataservices.entidades.Customerwebserv;
import co.gov.ideam.prasdes.dataservices.entidades.Station;
import co.gov.ideam.prasdes.dataservices.entidades.Variable;
import co.gov.ideam.prasdes.web.dto.CustomerStationVarDTO;

@Controller
@RequestMapping("/configEst")
public class ConfigEstacionesController {
	@Autowired
	private RestAdapter restAdapterImpl;	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getConfigEstView(Model model){
		List<CustomerStationVarDTO> lista =restAdapterImpl.getCustomerStationVarDTO();
		
		model.addAttribute("listaCustomers", lista);
		return "configEstaciones";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postConfigEst(Model model, CustomerStationVarDTO dto ){
	
		
		return "configEstaciones";
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public String deleteConfigEst(Model model, CustomerStationVarDTO dto ){
	
		
		return "configEstaciones";
	}
	
	@ModelAttribute("listaEstaciones")
    public List<Station> stationList() {
        return restAdapterImpl.getStations();
    }
	
	@ModelAttribute("listaVariables")
    public List<Variable> variableList() {
        return restAdapterImpl.getVariable();
    }
	
	@ModelAttribute("listaCustomersWeb")
    public List<Customerwebserv> customerList() {
        return restAdapterImpl.getCustomerWebService();
    }
	
}
