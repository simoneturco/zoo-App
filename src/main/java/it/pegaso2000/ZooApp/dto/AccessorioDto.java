package it.pegaso2000.ZooApp.dto;

public class AccessorioDto {

	private Long id;
	private String descrizione;
	private Integer prezzo;
	
	public AccessorioDto() {
		// TODO Auto-generated constructor stub
	}
	
	public AccessorioDto(String descrizione, Integer prezzo) {
		// TODO Auto-generated constructor stub
		this.descrizione = descrizione;
		this.prezzo = prezzo;
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

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}
	
}
