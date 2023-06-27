package it.pegaso2000.ZooApp.service;

import java.util.List;
import java.util.Optional;

import it.pegaso2000.ZooApp.model.Razza;
import it.pegaso2000.ZooApp.repository.RazzaRepository;

public class RazzaImplementedService implements RazzaService {
	
	private RazzaRepository razzaRepository;
	
	public RazzaImplementedService(RazzaRepository razzaRepository) {
		// TODO Auto-generated constructor stub
		this.razzaRepository = razzaRepository;
	}

	@Override
	public List<Razza> getRazze() {
		// TODO Auto-generated method stub
		return razzaRepository.findAll();
	}

	@Override
	public Razza getRazza(Long id) {
		// TODO Auto-generated method stub
		Optional<Razza> razza = razzaRepository.findById(id);
		if(razza.isPresent()) return razza.get();
			else return null;
	}

	@Override
	public Razza saveRazza(Razza razza) {
		// TODO Auto-generated method stub
		return razzaRepository.save(razza);
	}

	@Override
	public Razza updateRazza(Razza razza, Long id) {
		// TODO Auto-generated method stub
		Optional<Razza> srcRazza = razzaRepository.findById(id);
		if(srcRazza.isPresent()) {
			razza.setId(id);
			return razzaRepository.save(razza);
		}else return null;
	}

	@Override
	public Boolean deleteRazza(Long id) {
		// TODO Auto-generated method stub
		Optional<Razza> srcRazza = razzaRepository.findById(id);
		if(srcRazza.isPresent()) {
			razzaRepository.delete(srcRazza.get());
			return true;
		}else return false;
	}

}
