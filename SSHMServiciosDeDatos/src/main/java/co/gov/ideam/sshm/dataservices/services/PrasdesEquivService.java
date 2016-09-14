package co.gov.ideam.sshm.dataservices.services;

import java.util.List;

import co.gov.ideam.prasdes.dataservices.entidades.PrasdesEquiv;

public interface PrasdesEquivService {

	public List<PrasdesEquiv> obtenerEquivalenciasPorParametro(String tipoval, String ideamval, String prasdesval);
}
