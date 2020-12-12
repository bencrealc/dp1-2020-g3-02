package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.samples.petclinic.model.Equipo;
import org.springframework.samples.petclinic.service.base.BaseEstadisticasService;

public interface EquipoService extends BaseEstadisticasService<Equipo>{
	
	public abstract List<String> findCategoria();
	public abstract Equipo findByCategoria(String category);
	public abstract List<Equipo> findByCategoriaStartingWith(String category);
	public abstract List<Equipo> findByLiga(String league);

}
