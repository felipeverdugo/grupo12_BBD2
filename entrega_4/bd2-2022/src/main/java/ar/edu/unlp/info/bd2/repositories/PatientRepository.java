
package ar.edu.unlp.info.bd2.repositories;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository <Patient, Long>{
	
	public abstract Optional<Patient> findByEmail(String email);
	
}
