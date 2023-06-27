package it.pegaso2000.ZooApp.dto;

import java.util.ArrayList;
import java.util.List;

public class SpecieDto {

	private Long id;
	private String descrizione;
	
	private List<Long> razze = new ArrayList<>();
	private List<Long> accessori = new ArrayList<>();
	
	public SpecieDto() {
		// TODO Auto-generated constructor stub
	}
	
	public SpecieDto(String descrizione) {
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

	public List<Long> getRazze() {
		return razze;
	}

	public void setRazze(List<Long> razze) {
		this.razze = razze;
	}

	public List<Long> getAccessori() {
		return accessori;
	}

	public void setAccessori(List<Long> accessori) {
		this.accessori = accessori;
	}

}
