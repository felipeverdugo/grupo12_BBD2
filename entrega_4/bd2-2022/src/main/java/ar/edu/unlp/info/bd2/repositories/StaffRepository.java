
package ar.edu.unlp.info.bd2.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.Staff;

@Repository
public interface StaffRepository extends CrudRepository <Staff, Long>{
	
	public abstract List<Staff> findByFullNameContaining(String fullName);
}
