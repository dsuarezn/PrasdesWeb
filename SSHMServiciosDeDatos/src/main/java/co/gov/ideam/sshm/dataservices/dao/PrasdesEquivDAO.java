package co.gov.ideam.sshm.dataservices.dao;

import java.util.List;

import co.gov.ideam.prasdes.dataservices.entidades.PrasdesEquiv;



public interface PrasdesEquivDAO {

	public List<PrasdesEquiv> obtenerEquivalenciasPorParametros(String tipoValor, String ideamVal, String prasdesVal);
		
	
}
