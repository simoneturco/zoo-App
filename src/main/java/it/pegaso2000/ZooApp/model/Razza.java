package it.pegaso2000.ZooApp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "razze")
public class Razza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String descrizione;
	@ManyToOne
	@JoinColumn(name = "razza_id")
	private Specie specie;
	@OneToMany(mappedBy = "razza")
	private List<Animale> animali;
	
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
	public Specie getSpecie() {
		return specie;
	}
	public void setSpecie(Specie specie) {
		this.specie = specie;
	}
	public List<Animale> getAnimali() {
		return animali;
	}
	public void setAnimali(List<Animale> animali) {
		this.animali = animali;
	}
	
}
