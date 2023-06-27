package it.pegaso2000.ZooApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pegaso2000.ZooApp.model.Specie;

public interface SpecieRepository extends JpaRepository<Specie, Long>{

}
