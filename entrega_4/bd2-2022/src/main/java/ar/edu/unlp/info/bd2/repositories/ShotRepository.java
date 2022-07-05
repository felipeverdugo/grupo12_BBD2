
package ar.edu.unlp.info.bd2.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Shot;

@Repository
public interface ShotRepository extends CrudRepository <Shot, Long> {
	
	@Query("Select s.centre from Shot s group by s.centre order by count(s.centre) desc")
	public abstract List<Centre> getTopShotCentre(/* Pageable pageable */);
	
}
