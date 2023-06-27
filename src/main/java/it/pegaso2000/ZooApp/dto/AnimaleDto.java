package it.pegaso2000.ZooApp.dto;

public class AnimaleDto {

	private Long id;
	private String nome;
	
	private Long razza;
	
	public AnimaleDto() {
		// TODO Auto-generated constructor stub
	}
	
	public AnimaleDto(String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getRazza() {
		return razza;
	}

	public void setRazza(Long razza) {
		this.razza = razza;
	}

}
