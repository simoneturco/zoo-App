package it.pegaso2000.ZooApp.service;

import java.util.List;

import it.pegaso2000.ZooApp.model.Razza;

public interface RazzaService {

	List<Razza> getRazze();
	Razza getRazza(Long id);
	Razza saveRazza(Razza razza);
	Razza updateRazza(Razza razza, Long id);
	Boolean deleteRazza(Long id);
	
}
