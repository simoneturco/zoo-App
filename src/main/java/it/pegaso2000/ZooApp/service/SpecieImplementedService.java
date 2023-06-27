package it.pegaso2000.ZooApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.pegaso2000.ZooApp.model.Specie;
import it.pegaso2000.ZooApp.repository.SpecieRepository;

@Service
public class SpecieImplementedService implements SpecieService {
	
	private SpecieRepository specieRepository;
	
	public SpecieImplementedService(SpecieRepository specieRepository) {
		// TODO Auto-generated constructor stub
		this.specieRepository = specieRepository;
	}

	@Override
	public List<Specie> getAllSpecie() {
		// TODO Auto-generated method stub
		return specieRepository.findAll();
	}

	@Override
	public Specie getSpecie(Long id) {
		// TODO Auto-generated method stub
		Optional<Specie> specie = specieRepository.findById(id);
		if(specie.isPresent()) return specie.get();
			else return null;
	}

	@Override
	public Specie saveSpecie(Specie specie) {
		// TODO Auto-generated method stub
		return specieRepository.save(specie);
	}

	@Override
	public Specie updateSpecie(Specie specie, Long id) {
		// TODO Auto-generated method stub
		Optional<Specie> srcSpecie = specieRepository.findById(id);
		if(srcSpecie.isPresent()) {
			specie.setId(id);
			return specieRepository.save(specie);
		}else return null;
	}

	@Override
	public Boolean deleteSpecie(Long id) {
		// TODO Auto-generated method stub
		Optional<Specie> srcSpecie = specieRepository.findById(id);
		if(srcSpecie.isPresent()) {
			specieRepository.delete(srcSpecie.get());
			return true;
		}else return null;
	}

}
