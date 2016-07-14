package com.gov.ideam.prasdes.rest;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.gov.ideam.prasdes.config.AppConfigInfo;

import co.gov.ideam.prasdes.dataservices.entidades.Country;
import co.gov.ideam.prasdes.dataservices.entidades.Customerstationvar;
import co.gov.ideam.prasdes.dataservices.entidades.Customerwebserv;
import co.gov.ideam.prasdes.dataservices.entidades.MigTask;
import co.gov.ideam.prasdes.dataservices.entidades.Period;
import co.gov.ideam.prasdes.dataservices.entidades.PrasdesEquiv;
import co.gov.ideam.prasdes.dataservices.entidades.Station;
import co.gov.ideam.prasdes.dataservices.entidades.Variable;
import co.gov.ideam.prasdes.utilidades.Utilidades;
import co.gov.ideam.prasdes.web.dto.ConnectionDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.prasdes.web.dto.CustomerStationVarDTO;
import co.gov.ideam.prasdes.web.dto.MigTaskDTO;
import co.gov.ideam.prasdes.web.dto.MigracionFormWebDTO;



@Component
@Qualifier("restAdapterImpl")
@DependsOn("appConfigInfo")
public class RestAdapterImpl implements RestAdapter {

	
	
	public RestAdapterImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void init(){
		
	}
	
	@Autowired
	private AppConfigInfo appConfigInfo;
	
	
	public RestTemplate getRestTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		return restTemplate;
	}
	
//	@Override
	public List<ConnectionDTO> getPrasdesConnections() {
		RestTemplate restTemplate = getRestTemplate();		
		ConnectionDTO[] listaConexiones = restTemplate.getForObject(Utilidades.getUri(appConfigInfo.connectionServiceUrl), ConnectionDTO[].class);
		return Arrays.asList(listaConexiones); 
	}

//	@Override
	public List<ConsultaResponseDTO> getPrasdesDailyData(MigracionFormWebDTO webdto) {		
		RestTemplate restTemplate = getRestTemplate();
		ConsultaResponseDTO[] listaDatos = restTemplate.getForObject(Utilidades.getUri(webdto.getServiceUrl()), ConsultaResponseDTO[].class);
		return Arrays.asList(listaDatos); 
	}
	
	
	public List<ConsultaResponseDTO> getPrasdesMonthlyData(MigracionFormWebDTO webdto) {		
		RestTemplate restTemplate = getRestTemplate();		
		ConsultaResponseDTO[] listaDatos = restTemplate.getForObject(Utilidades.getUri(webdto.getServiceUrl()), ConsultaResponseDTO[].class);
		return Arrays.asList(listaDatos); 
	}
	
	public List<ConsultaResponseRawDataDTO> getPrasdesInstantData(MigracionFormWebDTO webdto) {		
		RestTemplate restTemplate = getRestTemplate();	
		ConsultaResponseRawDataDTO[] listaDatos = restTemplate.getForObject(Utilidades.getUri(webdto.getServiceUrl()), ConsultaResponseRawDataDTO[].class);
		return Arrays.asList(listaDatos); 
	}
	
	public List<ConsultaResponseRawDataDTO> getPrasdesRawData(MigracionFormWebDTO webdto) {		
		RestTemplate restTemplate = getRestTemplate();
		
		ConsultaResponseRawDataDTO[] listaDatos = restTemplate.getForObject(Utilidades.getUri(webdto.getServiceUrl()), ConsultaResponseRawDataDTO[].class);
		return Arrays.asList(listaDatos); 
	}
	
	public void postPrasdesRawData(List<ConsultaResponseRawDataDTO> dataList) {	
		RestTemplate restTemplate = getRestTemplate();
		restTemplate.postForObject(Utilidades.getUri(appConfigInfo.instantDataServiceUrl), dataList, String.class);		
	}
	
	public void postPrasdesInstantData(List<ConsultaResponseRawDataDTO> dataList) {	
		RestTemplate restTemplate = getRestTemplate();		
		restTemplate.postForObject(Utilidades.getUri(appConfigInfo.instantDataServiceUrl), dataList, String.class);		
	}
	
	public void postPrasdesDailyData(List<ConsultaResponseDTO> dataList) {	
		RestTemplate restTemplate = getRestTemplate();
		restTemplate.postForObject(Utilidades.getUri(appConfigInfo.dailyDataServiceUrl), dataList, String.class);		
	}
	
	public void postPrasdesMonthlyData(List<ConsultaResponseDTO> dataList) {	
		RestTemplate restTemplate = getRestTemplate();
		restTemplate.postForObject(Utilidades.getUri(appConfigInfo.monthlyDataServiceUrl), dataList, String.class);		
	}
		
	
	public List<MigTaskDTO> getPrasdesTasks() {
		RestTemplate restTemplate = getRestTemplate();		
		MigTaskDTO[] listaConexiones = restTemplate.getForObject(Utilidades.getUri(appConfigInfo.migTaskServiceUrl), MigTaskDTO[].class);
		return Arrays.asList(listaConexiones); 
	}
	
	public MigTask postPrasdesTasks(MigTask task) {
		RestTemplate restTemplate = getRestTemplate();
		return restTemplate.postForObject(Utilidades.getUri(appConfigInfo.migTaskServiceUrl), task, MigTask.class);			
	}
	
	public void deletePrasdesTasks(MigTask task) {
		RestTemplate restTemplate = getRestTemplate();
		String url=appConfigInfo.migTaskServiceUrl;		
		restTemplate.delete(url, task); 		
	}

	@Override
	public List<CustomerStationVarDTO> getCustomerStationVarDTO() {
		RestTemplate restTemplate = getRestTemplate();
		CustomerStationVarDTO[] listaCustomer = restTemplate.getForObject(Utilidades.getUri(appConfigInfo.customerStationVarServiceUrl), CustomerStationVarDTO[].class);
		return Arrays.asList(listaCustomer); 
	}
	
	

	@Override
	public Customerstationvar postCustomerStationVarDTO(Customerstationvar var) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomerStationVarDTO(Customerstationvar csv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Station> getStations() {
		RestTemplate restTemplate = getRestTemplate();
		Station[] listaStations = restTemplate.getForObject(Utilidades.getUri(appConfigInfo.stationServiceUrl), Station[].class);
		return Arrays.asList(listaStations);
	}

	@Override
	public List<Variable> getVariable() {
		RestTemplate restTemplate = getRestTemplate();
		Variable[] listaVariables = restTemplate.getForObject(Utilidades.getUri(appConfigInfo.variableServiceUrl), Variable[].class);
		return Arrays.asList(listaVariables);
	}

	@Override
	public List<Customerwebserv> getCustomerWebService() {
		RestTemplate restTemplate = getRestTemplate();
		Customerwebserv[] listaCustomers = restTemplate.getForObject(Utilidades.getUri(appConfigInfo.customerWebServServiceUrl), Customerwebserv[].class);
		return Arrays.asList(listaCustomers);
	}

	@Override
	public List<Country> getPrasdesCountrys() {
		RestTemplate restTemplate = getRestTemplate();
		Country[] listaCountrys = restTemplate.getForObject(Utilidades.getUri(appConfigInfo.countryServiceUrl), Country[].class);
		return Arrays.asList(listaCountrys);
	}

	@Override
	public List<Period> getPrasdesPeriods() {
		RestTemplate restTemplate = getRestTemplate();
		Period[] listaPeriods = restTemplate.getForObject(Utilidades.getUri(appConfigInfo.periodServiceUrl), Period[].class);
		return Arrays.asList(listaPeriods);
	}
	
	public Map<Long, Long> getEquivPrasdesStations(){
		RestTemplate restTemplate = getRestTemplate();
		PrasdesEquiv[] equivStation= restTemplate.getForObject(Utilidades.getUri(appConfigInfo.equivStationsServiceUrl), PrasdesEquiv[].class);		
		Map<Long, Long> equivIdEstIdeamPrasdes= new HashMap<Long, Long>();					
		for (PrasdesEquiv estEquiv : equivStation) {
			equivIdEstIdeamPrasdes.put(Long.parseLong(estEquiv.getId().getIdeamVal()), Long.parseLong(estEquiv.getId().getPrasdesVal()));
		}
		return equivIdEstIdeamPrasdes;
		
	}
	
	public Map<String, Long> getEquivPrasdesVariables(){
		RestTemplate restTemplate = getRestTemplate();
		Map<String, Long> equivIdVarIdeamPrasdes= new HashMap<String, Long>();
		PrasdesEquiv[] equivVar= restTemplate.getForObject(Utilidades.getUri(appConfigInfo.equivVariablesServiceUrl), PrasdesEquiv[].class);
		for (PrasdesEquiv varEquiv : equivVar) {
			equivIdVarIdeamPrasdes.put(varEquiv.getId().getIdeamVal(), Long.parseLong(varEquiv.getId().getPrasdesVal()));
		}
		return equivIdVarIdeamPrasdes;
	}
	
	
	public Map<Long, Long> getEquivPrasdesSources(){
		RestTemplate restTemplate = getRestTemplate();
		Map<Long, Long> equivIdSourceIdeamPrasdes= new HashMap<Long, Long>();
		PrasdesEquiv[] equivSource= restTemplate.getForObject(Utilidades.getUri(appConfigInfo.equivSourcesServiceUrl), PrasdesEquiv[].class);
		for (PrasdesEquiv sourceEquiv : equivSource) {
			equivIdSourceIdeamPrasdes.put(Long.parseLong(sourceEquiv.getId().getIdeamVal()), Long.parseLong(sourceEquiv.getId().getPrasdesVal()));
		}
		return equivIdSourceIdeamPrasdes;
	}
	
	public Map<Long, Long> getEquivPrasdesQuality(){
		RestTemplate restTemplate = getRestTemplate();
		Map<Long, Long> equivIdSourceIdeamPrasdes= new HashMap<Long, Long>();
		PrasdesEquiv[] equivSource= restTemplate.getForObject(Utilidades.getUri(appConfigInfo.equivQualityServiceUrl), PrasdesEquiv[].class);
		for (PrasdesEquiv sourceEquiv : equivSource) {
			equivIdSourceIdeamPrasdes.put(Long.parseLong(sourceEquiv.getId().getIdeamVal()), Long.parseLong(sourceEquiv.getId().getPrasdesVal()));
		}
		return equivIdSourceIdeamPrasdes;
	}

	
		
	public void migrarInformacionIdeamToPrasdes(String serviceUrl, Long idPeriod) {		
		RestTemplate restTemplate = getRestTemplate();			
		co.gov.ideam.sshm.web.dto.ConsultaResponseDTO[] listaResponse = restTemplate.getForObject(Utilidades.getUri(serviceUrl), co.gov.ideam.sshm.web.dto.ConsultaResponseDTO[].class);		
		Map<Long, Long>  equivIdEstIdeamPrasdes = getEquivPrasdesStations();
		Map<String, Long> equivIdVarIdeamPrasdes = getEquivPrasdesVariables();
		Map<Long, Long> equivIdSourceIdeamPrasdes = getEquivPrasdesSources();
		Map<Long, Long> equivIdQualityIdeamPrasdes = getEquivPrasdesQuality();
		List listaPrasdesVals=new ArrayList<>();		
		for (co.gov.ideam.sshm.web.dto.ConsultaResponseDTO item : listaResponse) {						
			if(idPeriod.equals(appConfigInfo.periodIdDailyData) || idPeriod.equals(appConfigInfo.periodIdMonthlyData)){
				ConsultaResponseDTO dto = obtenerResponsePrasdesFromIdeam(item, equivIdEstIdeamPrasdes, equivIdVarIdeamPrasdes, equivIdSourceIdeamPrasdes, equivIdQualityIdeamPrasdes);						
				listaPrasdesVals.add(dto);
			}
			if(idPeriod.equals(appConfigInfo.periodIdInstantData) || idPeriod.equals(appConfigInfo.periodIdRawData)){
				ConsultaResponseRawDataDTO dto = obtenerResponsePrasdesRawFromIdeam(item, equivIdEstIdeamPrasdes, equivIdVarIdeamPrasdes, equivIdSourceIdeamPrasdes, equivIdQualityIdeamPrasdes);						
				listaPrasdesVals.add(dto);
			}					
		}		
		if(idPeriod.equals(appConfigInfo.periodIdDailyData)){
			postPrasdesDailyData(listaPrasdesVals);
		}
		else if(idPeriod.equals(appConfigInfo.periodIdMonthlyData)){
			postPrasdesMonthlyData(listaPrasdesVals);
		}
		else if(idPeriod.equals(appConfigInfo.periodIdInstantData)){
			postPrasdesInstantData(listaPrasdesVals);
		}
		else if(idPeriod.equals(appConfigInfo.periodIdRawData)){
			postPrasdesRawData(listaPrasdesVals);
		}			
	}
	
	
	private ConsultaResponseDTO obtenerResponsePrasdesFromIdeam(co.gov.ideam.sshm.web.dto.ConsultaResponseDTO item ,Map<Long, Long>  equivIdEstIdeamPrasdes, Map<String, Long> equivIdVarIdeamPrasdes, Map<Long, Long> equivIdSourceIdeamPrasdes, Map<Long, Long> equivIdQualityIdeamPrasdes){
		ConsultaResponseDTO dto = new ConsultaResponseDTO();			
		dto.setnIdstation(equivIdEstIdeamPrasdes.get(item.getIdStation()));
		dto.setnIdvar(equivIdVarIdeamPrasdes.get(item.getIdVariable()));
		dto.setnIdsource(equivIdSourceIdeamPrasdes.get(item.getIdSource()));
		dto.setdDatadate(item.getDateDatadate());
		dto.setnData(new BigDecimal(item.getData()));
		dto.setnIdflag(item.getIdFlag());
		dto.setnIdqc(equivIdQualityIdeamPrasdes.get(item.getIdqc()));
		dto.setnIduser(appConfigInfo.prasdesDefaultUser);
		return dto;
	}
	
	private ConsultaResponseRawDataDTO obtenerResponsePrasdesRawFromIdeam(co.gov.ideam.sshm.web.dto.ConsultaResponseDTO item ,Map<Long, Long>  equivIdEstIdeamPrasdes, Map<String, Long> equivIdVarIdeamPrasdes, Map<Long, Long> equivIdSourceIdeamPrasdes, Map<Long, Long> equivIdQualityIdeamPrasdes){
		ConsultaResponseRawDataDTO dto = new ConsultaResponseRawDataDTO();			
		dto.setnIdstation(equivIdEstIdeamPrasdes.get(item.getIdStation()));
		dto.setnIdvar(equivIdVarIdeamPrasdes.get(item.getIdVariable()));
		dto.setnIdsource(equivIdSourceIdeamPrasdes.get(item.getIdSource()));
		dto.setdDatadate(item.getDateDatadate());
		dto.setnData(new BigDecimal(item.getData()));
		dto.setnIdflag(item.getIdFlag());
		dto.setnIdqc(equivIdQualityIdeamPrasdes.get(item.getIdqc()));
		dto.setnIduser(appConfigInfo.prasdesDefaultUser);
		return dto;
	}
	

	@Override
	public List<co.gov.ideam.sshm.web.dto.ConsultaResponseDTO> getSshmDailyData(MigracionFormWebDTO webdto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<co.gov.ideam.sshm.web.dto.ConsultaResponseDTO> getSshmMonthlyData(MigracionFormWebDTO webdto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<co.gov.ideam.sshm.web.dto.ConsultaResponseDTO> getSshmInstantData(MigracionFormWebDTO webdto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<co.gov.ideam.sshm.web.dto.ConsultaResponseDTO> getSshmRawData(MigracionFormWebDTO webdto) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
