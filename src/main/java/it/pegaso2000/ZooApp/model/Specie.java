package it.pegaso2000.ZooApp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "specie")
public class Specie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String descrizione;
	@OneToMany(mappedBy = "specie")
	private List<Razza> razze;
	@OneToMany(mappedBy = "specie")
	private List<Accessorio> accessori;
	
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
	public List<Razza> getRazze() {
		return razze;
	}
	public void setRazze(List<Razza> razze) {
		this.razze = razze;
	}
	public List<Accessorio> getAccessori() {
		return accessori;
	}
	public void setAccessori(List<Accessorio> accessori) {
		this.accessori = accessori;
	}
	
}
