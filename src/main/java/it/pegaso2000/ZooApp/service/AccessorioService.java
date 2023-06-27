package it.pegaso2000.ZooApp.service;

import java.util.List;

import it.pegaso2000.ZooApp.model.Accessorio;

public interface AccessorioService {

	List<Accessorio> getAccessori();
	Accessorio getAccessorio(Long id);
	Accessorio saveAccessorio(Accessorio accessorio);
	Accessorio updateAccessorio(Accessorio accessorio, Long id);
	Boolean deleteAccessorio(Long id);
}
