package it.pegaso2000.ZooApp.service;

import java.util.List;

import it.pegaso2000.ZooApp.model.Animale;

public interface AnimaleService {

	List<Animale> getAnimali();
	Animale getAnimale(Long id);
	Animale saveAnimale(Animale animale);
	Animale updateAnimale(Animale animale, Long id);
	Boolean deleteAnimale(Long id);
}
