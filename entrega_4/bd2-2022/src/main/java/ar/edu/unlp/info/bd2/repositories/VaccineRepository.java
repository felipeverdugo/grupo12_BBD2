package ar.edu.unlp.info.bd2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.Vaccine;

public interface VaccineRepository extends CrudRepository <Vaccine, Long>{
	public abstract Optional<Vaccine> findByName(String name);
	
	@Query("from Vaccine where id not in ( select distinct vaccine from Shot )")
	public abstract List<Vaccine> getUnappliedVaccines();
	
}
