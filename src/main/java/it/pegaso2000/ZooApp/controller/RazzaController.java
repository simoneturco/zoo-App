package it.pegaso2000.ZooApp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pegaso2000.ZooApp.dto.RazzaDto;
import it.pegaso2000.ZooApp.model.Razza;
import it.pegaso2000.ZooApp.service.AnimaleService;
import it.pegaso2000.ZooApp.service.RazzaService;
import it.pegaso2000.ZooApp.service.SpecieService;

@RestController
@RequestMapping(path = "/api/v1/zoo/razza")
public class RazzaController {

	private RazzaService razzaService;
	private SpecieService specieService;
	private AnimaleService animaleService;
	
	public RazzaController(RazzaService razzaService,
			SpecieService specieService, AnimaleService animaleService) {
		// TODO Auto-generated constructor stub
		this.razzaService = razzaService;
		this.specieService = specieService;
		this.animaleService = animaleService;
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<RazzaDto>> getRazze() {
		List<RazzaDto> razzeDto = 
				razzaService.getRazze()
					.stream()
						.map(razza -> {
							return entityToDto(razza);
						}).collect(Collectors.toList());
		return new ResponseEntity<>(razzeDto, HttpStatus.OK);
	}
	
	@GetMapping(path = "/byId/{id}")
	public ResponseEntity<RazzaDto> getRazza(@PathVariable Long id) {
		return new ResponseEntity<>(entityToDto(razzaService.getRazza(id)), HttpStatus.OK);
	}
	
	@PostMapping(path = "/save")
	public ResponseEntity<RazzaDto> saveRazza(@RequestBody RazzaDto razza) {
		return new ResponseEntity<>(entityToDto(razzaService.saveRazza(dtoToEntity(razza))), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<RazzaDto> updateRazza(@RequestBody RazzaDto razza, @PathVariable Long id) {
		return new ResponseEntity<>(entityToDto(razzaService.updateRazza(dtoToEntity(razza), id)), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Boolean> deleteRazza(@PathVariable Long id) {
		return new ResponseEntity<>(razzaService.deleteRazza(id), HttpStatus.ACCEPTED);
	}
	
	private RazzaDto entityToDto(Razza entity) {
		RazzaDto dto = new RazzaDto(entity.getDescrizione());
		dto.setId(entity.getId());
		dto
			.setAnimali(
				entity.getAnimali()
					.stream()
						.map(animale -> {
							return animale.getId();
						}).collect(Collectors.toList()));
		dto.setSpecie(entity.getSpecie().getId());
		
		return dto;
	}
	
	private Razza dtoToEntity(RazzaDto dto) {
		Razza entity = new Razza();
		entity.setId(dto.getId());
		entity.setDescrizione(dto.getDescrizione());
		entity.setAnimali(
				dto.getAnimali()
					.stream()
						.map(id_animale -> {
							return animaleService.getAnimale(id_animale);
						}).collect(Collectors.toList()));
		entity.setSpecie(specieService.getSpecie(dto.getSpecie()));
		
		return entity;
	}
}
