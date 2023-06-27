package it.pegaso2000.ZooApp.service;

import java.util.List;

import it.pegaso2000.ZooApp.model.Specie;

public interface SpecieService {

	List<Specie> getAllSpecie();
	Specie getSpecie(Long id);
	Specie saveSpecie(Specie specie);
	Specie updateSpecie(Specie specie, Long id);
	Boolean deleteSpecie(Long id);
	
}
