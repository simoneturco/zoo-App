package it.pegaso2000.ZooApp.service;

import java.util.List;
import java.util.Optional;

import it.pegaso2000.ZooApp.model.Accessorio;
import it.pegaso2000.ZooApp.repository.AccessorioRepository;

public class AccessorioImplementedService implements AccessorioService {
	
	private AccessorioRepository accessorioRepository;
	
	public AccessorioImplementedService(AccessorioRepository accessorioRepository) {
		// TODO Auto-generated constructor stub
		this.accessorioRepository = accessorioRepository;
	}

	@Override
	public List<Accessorio> getAccessori() {
		// TODO Auto-generated method stub
		return accessorioRepository.findAll();
	}

	@Override
	public Accessorio getAccessorio(Long id) {
		// TODO Auto-generated method stub
		Optional<Accessorio> accessorio = accessorioRepository.findById(id);
		if(accessorio.isPresent()) return accessorio.get();
			else return null;
	}

	@Override
	public Accessorio saveAccessorio(Accessorio accessorio) {
		// TODO Auto-generated method stub
		return accessorioRepository.save(accessorio);
	}

	@Override
	public Accessorio updateAccessorio(Accessorio accessorio, Long id) {
		// TODO Auto-generated method stub
		Optional<Accessorio> srcAccessorio = accessorioRepository.findById(id);
		if(srcAccessorio.isPresent()) {
			accessorio.setId(id);
			return accessorioRepository.save(accessorio);
		}else return null;
	}

	@Override
	public Boolean deleteAccessorio(Long id) {
		// TODO Auto-generated method stub
		Optional<Accessorio> srcAccessorio = accessorioRepository.findById(id);
		if(srcAccessorio.isPresent()) {
			accessorioRepository.delete(srcAccessorio.get());
			return true;
		}else return false;
	}

}
