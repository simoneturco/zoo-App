package it.pegaso2000.ZooApp.service;

import java.util.List;
import java.util.Optional;

import it.pegaso2000.ZooApp.model.Animale;
import it.pegaso2000.ZooApp.repository.AnimaleRepository;

public class AnimaleImplementedService implements AnimaleService {
	
	private AnimaleRepository animaleRepository;
	
	public AnimaleImplementedService(AnimaleRepository animaleRepository) {
		// TODO Auto-generated constructor stub
		this.animaleRepository = animaleRepository;
	}

	@Override
	public List<Animale> getAnimali() {
		// TODO Auto-generated method stub
		return animaleRepository.findAll();
	}

	@Override
	public Animale getAnimale(Long id) {
		// TODO Auto-generated method stub
		Optional<Animale> animale = animaleRepository.findById(id);
		if(animale.isPresent()) return animale.get();
			else return null;
	}

	@Override
	public Animale saveAnimale(Animale animale) {
		// TODO Auto-generated method stub
		return animaleRepository.save(animale);
	}

	@Override
	public Animale updateAnimale(Animale animale, Long id) {
		// TODO Auto-generated method stub
		Optional<Animale> srcAnimale = animaleRepository.findById(id);
		if(srcAnimale.isPresent()) {
			animale.setId(id);
			return animaleRepository.save(animale);
		}else return null;
	}

	@Override
	public Boolean deleteAnimale(Long id) {
		// TODO Auto-generated method stub
		Optional<Animale> srcAnimale = animaleRepository.findById(id);
		if(srcAnimale.isPresent()) {
			animaleRepository.delete(srcAnimale.get());
			return true;
		}else return null;
	}

}
