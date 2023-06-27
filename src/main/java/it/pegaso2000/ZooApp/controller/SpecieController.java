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

import it.pegaso2000.ZooApp.dto.SpecieDto;
import it.pegaso2000.ZooApp.model.Specie;
import it.pegaso2000.ZooApp.service.AccessorioService;
import it.pegaso2000.ZooApp.service.RazzaService;
import it.pegaso2000.ZooApp.service.SpecieService;

@RestController
@RequestMapping(path = "/api/v1/zoo/specie")
public class SpecieController {
	
	private SpecieService specieService;
	private AccessorioService accessorioService;
	private RazzaService razzaService;
	
	public SpecieController(SpecieService specieService,
			AccessorioService accessorioService, RazzaService razzaService) {
		// TODO Auto-generated constructor stub
		this.specieService = specieService;
		this.accessorioService = accessorioService;
		this.razzaService = razzaService;
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<SpecieDto>> getAllSpecie() {
		List<SpecieDto> specieDto =
				specieService.getAllSpecie()
					.stream()
						.map(specie -> {
							return entityToDto(specie);
						}).collect(Collectors.toList());
		return new ResponseEntity<>(specieDto, HttpStatus.OK);
	}
	
	@GetMapping(path = "/byId/{id}")
	public ResponseEntity<SpecieDto> getSpecie(@PathVariable Long id) {
		return new ResponseEntity<>(entityToDto(specieService.getSpecie(id)), HttpStatus.OK);
	}
	
	@PostMapping(path = "/save")
	public ResponseEntity<SpecieDto> saveSpecie(@RequestBody SpecieDto specie) {
		return new ResponseEntity<>(entityToDto(specieService.saveSpecie(dtoToEntity(specie))), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<SpecieDto> updateSpecie(@RequestBody SpecieDto specie, @PathVariable Long id) {
		return new ResponseEntity<>(entityToDto(specieService.updateSpecie(dtoToEntity(specie), id)), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Boolean> deleteSpecie(@PathVariable Long id) {
		return new ResponseEntity<>(specieService.deleteSpecie(id), HttpStatus.ACCEPTED);
	}
	
	private SpecieDto entityToDto(Specie entity) {
		SpecieDto dto = new SpecieDto(entity.getDescrizione());
		dto.setId(entity.getId());
		dto.setAccessori(
				entity.getAccessori()
					.stream()
						.map(accessorio -> {
							return accessorio.getId();
						}).collect(Collectors.toList()));
		dto.setRazze(
				entity.getRazze()
					.stream()
						.map(razza -> {
							return razza.getId();
						}).collect(Collectors.toList()));
		
		return dto;
	}
	
	private Specie dtoToEntity(SpecieDto dto) {
		Specie entity = new Specie();
		entity.setId(dto.getId());
		entity.setDescrizione(dto.getDescrizione());
		entity.setAccessori(
				dto.getAccessori()
					.stream()
						.map(id_accessorio -> {
							return accessorioService.getAccessorio(id_accessorio);
						}).collect(Collectors.toList()));
		entity.setRazze(
				dto.getRazze()
					.stream()
						.map(id_razza -> {
							return razzaService.getRazza(id_razza);
						}).collect(Collectors.toList()));
		return entity;
	}
}
