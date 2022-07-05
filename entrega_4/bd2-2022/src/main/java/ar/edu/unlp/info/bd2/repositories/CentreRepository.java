
package ar.edu.unlp.info.bd2.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.Centre;

@Repository
public interface CentreRepository extends CrudRepository <Centre, Long> {
	public abstract Optional<Centre> findByName(String name);
	
	@Query("Select c from Centre c group by c.id order by size(c.staffs) desc")
	public abstract List<Centre> getCentresTopNStaff(Pageable pageable);
	
	
}
