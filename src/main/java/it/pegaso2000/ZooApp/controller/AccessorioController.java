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

import it.pegaso2000.ZooApp.dto.AccessorioDto;
import it.pegaso2000.ZooApp.model.Accessorio;
import it.pegaso2000.ZooApp.service.AccessorioService;
import it.pegaso2000.ZooApp.service.SpecieService;

@RestController
@RequestMapping(path = "/api/v1/zoo/accessorio")
public class AccessorioController {
	
	private AccessorioService accessorioService;
	private SpecieService specieService;
	
	public AccessorioController(AccessorioService accessorioService,
			SpecieService specieService) {
		// TODO Auto-generated constructor stub
		this.accessorioService = accessorioService;
		this.specieService = specieService;
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<AccessorioDto>> getAccessori() {
		List<AccessorioDto> accessoriDto = 
				accessorioService.getAccessori()
					.stream()
						.map(accessorio -> {
							return entityToDto(accessorio);
						}).collect(Collectors.toList());
		return new ResponseEntity<>(accessoriDto, HttpStatus.OK);
	}
	
	@GetMapping(path = "/byId/{id}")
	public ResponseEntity<AccessorioDto> getAccessorio(@PathVariable Long id) {
		return new ResponseEntity<>(entityToDto(accessorioService.getAccessorio(id)), HttpStatus.OK);
	}
	
	@PostMapping(path = "/save")
	public ResponseEntity<AccessorioDto> saveAccessorio(@RequestBody AccessorioDto accessorio) {
		return new ResponseEntity<>(entityToDto(accessorioService.saveAccessorio(dtoToEntity(accessorio))), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<AccessorioDto> updateAccessorio(@RequestBody AccessorioDto accessorio, @PathVariable Long id) {
		return new ResponseEntity<>(entityToDto(accessorioService.updateAccessorio(dtoToEntity(accessorio), id)), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Boolean> deleteAccessorio(@PathVariable Long id) {
		return new ResponseEntity<>(accessorioService.deleteAccessorio(id), HttpStatus.ACCEPTED);
	}

	private AccessorioDto entityToDto(Accessorio entity) {
		AccessorioDto dto = new AccessorioDto(entity.getDescrizione(), entity.getPrezzo());
		dto.setId(entity.getId());
		dto.setSpecie(entity.getSpecie().getId());
		
		return dto;
	}
	
	private Accessorio dtoToEntity(AccessorioDto dto) {
		Accessorio entity = new Accessorio();
		entity.setId(dto.getId());
		entity.setDescrizione(dto.getDescrizione());
		entity.setPrezzo(dto.getPrezzo());
		entity.setSpecie(specieService.getSpecie(dto.getSpecie()));
		
		return entity;
	}
}
