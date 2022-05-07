package ar.edu.unlp.info.bd2.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Shot;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;


@Repository
public class VaxRepository {

	@Autowired
	private SessionFactory sessionFactory;
	

	public VaxRepository() {

	}


	public Serializable create (Object aux) throws VaxException {
		try {			
			Serializable serializableAux = sessionFactory.getCurrentSession().save(aux);
			System.out.println(aux.toString());
			return serializableAux;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			throw new VaxException("Constraint Violation");			
		}
	}
	
	
//==================Meteodos Paciente=======================
	
	public Patient getPatientById(Long id) {	
		return this.sessionFactory.getCurrentSession().get(Patient.class, id);
	}
	
	public Optional<Patient> getPatientByEmail(String email)throws VaxException{	
		return this.sessionFactory.getCurrentSession().createQuery("from Patient pa where pa.email='" + email + "'").uniqueResultOptional(); 
	}
	
	
//==================Meteodos Vaccine=======================
	
	public Vaccine getVaccineById(Long id) {
		return this.sessionFactory.getCurrentSession().get(Vaccine.class, id);
	}
	
	public Optional<Vaccine> getVaccineByName(String name) throws VaxException{	
		// Esta consulta es mejor solo retornando el nombre, supongo
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		List<Vaccine> lista = session.createQuery("from Vaccine").getResultList();
//		session.getTransaction().commit();
//		session.close();
//		return lista;
		
		return this.sessionFactory.getCurrentSession().createQuery("from Vaccine va where va.name='" + name + "'").uniqueResultOptional();		
	}
	
	
//==================Meteodos Centre=======================	
	
	public Centre getCentreById(Long id) {

		return this.sessionFactory.getCurrentSession().get(Centre.class, id);
	}
	public Optional<Centre> getCentreByName(String name) throws VaxException{

		return this.sessionFactory.getCurrentSession().createQuery("from Centre ce where ce.name='" + name + "'").uniqueResultOptional();
	}
	
	

//==================Meteodos Nurse=======================	
	
	public Nurse getNurseById(Long id) {

		return this.sessionFactory.getCurrentSession().get(Nurse.class, id);
	}
	
//==================Meteodos SupportStaff=======================	
	
	public SupportStaff getSupportStaffById(Long id) {

		return this.sessionFactory.getCurrentSession().get(SupportStaff.class, id);
	}
	
	
	public Optional<SupportStaff> getSupportStaffByDni(String dni) {

		return this.sessionFactory.getCurrentSession().createQuery("from SupportStaff ss where ss.dni='" + dni + "'").uniqueResultOptional();
	}
	
	
	
//==================Meteodos VaccinationSchedule=======================
	
	public VaccinationSchedule getVaccinationScheduleById(Long id) {

		return this.sessionFactory.getCurrentSession().get(VaccinationSchedule.class, id);
	}
	
	
}