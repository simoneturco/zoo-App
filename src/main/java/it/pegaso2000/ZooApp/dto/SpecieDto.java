package it.pegaso2000.ZooApp.dto;

public class SpecieDto {

	private Long id;
	private String descrizione;
	
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

}
