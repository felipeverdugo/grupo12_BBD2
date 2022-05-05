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
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Shot;
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
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw new VaxException("Constraint Violation");
			
		}
	}
	

	public Patient getPatientById(Long id) {
		
		return this.sessionFactory.getCurrentSession().get(Patient.class, id);
	}
	
	public Vaccine getVaccineById(Long id) {

		return this.sessionFactory.getCurrentSession().get(Vaccine.class, id);
	}
	
	public Centre getCentreById(Long id) {

		return this.sessionFactory.getCurrentSession().get(Centre.class, id);
	}
	
	public Optional<Patient> getPatientByEmail(String email)throws VaxException{
			

		return this.sessionFactory.getCurrentSession().createQuery("from Patient pa where pa.email='"+email+"'").uniqueResultOptional();

	}

	




	public List<Vaccine> getVaccineByName(String name) throws VaxException{
		
		
		// Esta consulta es mejor solo retornando el nombre, supongo
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Vaccine> lista = session.createQuery("from Vaccine").getResultList();
		session.getTransaction().commit();
		session.close();
		return lista;

	}





	
	
	
//	public Patient createPatient(Patient patient) {
//		
////		Session session = sessionFactory.getCurrentSession();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(patient);
//		session.getTransaction().commit();
//		session.close();
//		return patient;
//	}
//
//
//	public Vaccine createVaccine(Vaccine vaccine) {
////		Session session = sessionFactory.getCurrentSession();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(vaccine);
//		System.out.println(vaccine.getId());
//		session.getTransaction().commit();
//		
//		session.beginTransaction();
//		Vaccine vacine = session.get(Vaccine.class, vaccine.getId());
//		System.out.println(vaccine.getName());
//		session.getTransaction().commit();
//		session.close();
//		return vaccine;
//	}
//
//
////	public Shot createShot(Shot shot) {
////		Session session = sessionFactory.getCurrentSession();
////		session.save(shot);
////		session.getTransaction().commit();
////		session.close();
////		return shot;
////	}
//
//
//	public Centre createCentre(Centre centre) {
////		Session session = sessionFactory.getCurrentSession();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(centre);
//		session.getTransaction().commit();
//		session.close();
//		return centre;
//	}
	
	
}
