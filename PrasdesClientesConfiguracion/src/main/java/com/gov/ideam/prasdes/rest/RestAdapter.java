package com.gov.ideam.prasdes.rest;

import java.util.List;
import java.util.Map;

import co.gov.ideam.prasdes.dataservices.entidades.Country;
import co.gov.ideam.prasdes.dataservices.entidades.Customerstationvar;
import co.gov.ideam.prasdes.dataservices.entidades.Customerwebserv;
import co.gov.ideam.prasdes.dataservices.entidades.MigTask;
import co.gov.ideam.prasdes.dataservices.entidades.Period;
import co.gov.ideam.prasdes.dataservices.entidades.Station;
import co.gov.ideam.prasdes.dataservices.entidades.Variable;
import co.gov.ideam.prasdes.web.dto.ConnectionDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.prasdes.web.dto.CustomerStationVarDTO;
import co.gov.ideam.prasdes.web.dto.MigTaskDTO;
import co.gov.ideam.prasdes.web.dto.MigracionFormWebDTO;



public interface RestAdapter {
	
	
	
	public List<Country> getPrasdesCountrys();
	public List<Period> getPrasdesPeriods();
	public List<ConnectionDTO> getPrasdesConnections();
	public List<ConsultaResponseDTO> getPrasdesDailyData(MigracionFormWebDTO webdto);
	public List<ConsultaResponseDTO> getPrasdesMonthlyData(MigracionFormWebDTO webdto);
	public List<ConsultaResponseRawDataDTO> getPrasdesInstantData(MigracionFormWebDTO webdto);
	public List<ConsultaResponseRawDataDTO> getPrasdesRawData(MigracionFormWebDTO webdto);
	public void postPrasdesRawData(List<ConsultaResponseRawDataDTO> dataList);
	public void postPrasdesInstantData(List<ConsultaResponseRawDataDTO> dataList);
	public void postPrasdesDailyData(List<ConsultaResponseDTO> dataList);
	public void postPrasdesMonthlyData(List<ConsultaResponseDTO> dataList);
	public List<MigTaskDTO> getPrasdesTasks();
	public MigTask postPrasdesTasks(MigTask task);	
	public void deletePrasdesTasks(MigTask task);
	public List<CustomerStationVarDTO> getCustomerStationVarDTO();
	public Customerstationvar postCustomerStationVarDTO(Customerstationvar var);
	public void deleteCustomerStationVarDTO(Customerstationvar csv);
	public List<Station> getStations();
	public List<Variable> getVariable();
	public List<Customerwebserv> getCustomerWebService();
	
	public Map<Long, Long> getEquivPrasdesSources();
	public Map<Long, Long> getEquivPrasdesStations();
	public Map<String, Long> getEquivPrasdesVariables();
	public void migrarInformacionIdeamToPrasdes(String serviceUrl, Long idPeriod);
	
	public List<co.gov.ideam.sshm.web.dto.ConsultaResponseDTO> getSshmDailyData(MigracionFormWebDTO webdto);
	public List<co.gov.ideam.sshm.web.dto.ConsultaResponseDTO> getSshmMonthlyData(MigracionFormWebDTO webdto);
	public List<co.gov.ideam.sshm.web.dto.ConsultaResponseDTO> getSshmInstantData(MigracionFormWebDTO webdto);
	public List<co.gov.ideam.sshm.web.dto.ConsultaResponseDTO> getSshmRawData(MigracionFormWebDTO webdto);
	
}
