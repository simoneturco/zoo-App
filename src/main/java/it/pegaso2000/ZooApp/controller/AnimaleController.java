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

import it.pegaso2000.ZooApp.dto.AnimaleDto;
import it.pegaso2000.ZooApp.model.Animale;
import it.pegaso2000.ZooApp.service.AnimaleService;
import it.pegaso2000.ZooApp.service.RazzaService;

@RestController
@RequestMapping(path = "/api/v1/zoo/animale")
public class AnimaleController {
	
	private AnimaleService animaleService;
	private RazzaService razzaService;
	
	public AnimaleController(AnimaleService animaleService,
			RazzaService razzaService) {
		// TODO Auto-generated constructor stub
		this.animaleService = animaleService;
		this.razzaService = razzaService;
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<AnimaleDto>> getAnimali() {
		List<AnimaleDto> animaliDto = 
				animaleService.getAnimali()
					.stream()
						.map(animale -> {
							return entityToDto(animale);
						}).collect(Collectors.toList());
		return new ResponseEntity<>(animaliDto, HttpStatus.OK);
	}
	
	@GetMapping("/byId/{id}")
	public ResponseEntity<AnimaleDto> getAnimale(@PathVariable Long id) {
		return new ResponseEntity<>(entityToDto(animaleService.getAnimale(id)), HttpStatus.OK);
	}
	
	@PostMapping(path = "/save")
	public ResponseEntity<AnimaleDto> saveAnimale(@RequestBody AnimaleDto animale) {
		return new ResponseEntity<>(entityToDto(animaleService.saveAnimale(dtoToEntity(animale))), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<AnimaleDto> updateAnimale(@RequestBody AnimaleDto animale, @PathVariable Long id) {
		return new ResponseEntity<>(entityToDto(animaleService.updateAnimale(dtoToEntity(animale), id)), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Boolean> deleteAnimale(@PathVariable Long id) {
		return new ResponseEntity<>(animaleService.deleteAnimale(id), HttpStatus.ACCEPTED);
	}

	private AnimaleDto entityToDto(Animale entity) {
		AnimaleDto dto = new AnimaleDto(entity.getNome());
		dto.setId(entity.getId());
		dto.setRazza(entity.getRazza().getId());
		
		return dto;
	}
	
	private Animale dtoToEntity(AnimaleDto dto) {
		Animale entity = new Animale();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setRazza(razzaService.getRazza(dto.getRazza()));
		
		return entity;
	}
}
