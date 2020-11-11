package org.springframework.samples.petclinic.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.samples.petclinic.model.Partido;

public interface PartidoRepository extends ExtendedJpaRepository<Partido>{
	
	public List<Partido> findByFechaOrderByHora(LocalDate date);

}
