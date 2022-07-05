
package ar.edu.unlp.info.bd2.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unlp.info.bd2.model.SupportStaff;

@Repository
public interface SupportStaffRepository extends CrudRepository <SupportStaff, Long> {
	public abstract Optional<SupportStaff> findByDni(String dni);
	
	@Query("select s.area from SupportStaff s group by s.area order by count(s) asc")
	public abstract List<String> getLessEmployeesSupportStaffArea();
	
}
