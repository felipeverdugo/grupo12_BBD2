
package ar.edu.unlp.info.bd2.repositories;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.ShotCertificate;

@Repository
public interface ShotCertificateRepository extends CrudRepository <ShotCertificate, Long>{


	@Query("FROM ShotCertificate WHERE id in (select shotCertificate from Shot where date BETWEEN :stDate AND :enDate)")
	public abstract List<ShotCertificate> getShotCertificatesBetweenDates(@Param("stDate") Date startDate, @Param("enDate") Date endDate);
	
}
