package it.pegaso2000.ZooApp.dto;

import java.util.ArrayList;
import java.util.List;

public class RazzaDto {

	private Long id;
	private String descrizione;
	
	private Long specie;
	private List<Long> animali = new ArrayList<>();
	
	public RazzaDto() {
		// TODO Auto-generated constructor stub
	}
	
	public RazzaDto(String descrizione) {
		// TODO Auto-generated constructor stub
		this.descrizione = descrizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getSpecie() {
		return specie;
	}

	public void setSpecie(Long specie) {
		this.specie = specie;
	}

	public List<Long> getAnimali() {
		return animali;
	}

	public void setAnimali(List<Long> animali) {
		this.animali = animali;
	}
	
}
