
package ar.edu.unlp.info.bd2.repositories;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;

@Repository
public interface NurseRepository extends CrudRepository <Nurse, Long> {
	public abstract List<Nurse> findByExperienceGreaterThan(int years);
	
	@Query("from Nurse where id not in (select distinct nurse from Shot)")
	public abstract List<Nurse> getNurseNotShot();
	
}
