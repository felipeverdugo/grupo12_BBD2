package ar.edu.unlp.info.bd2.repositories;

import java.io.Serializable;
import java.util.Date;
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
import ar.edu.unlp.info.bd2.model.ShotCertificate;
import ar.edu.unlp.info.bd2.model.Staff;
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
	
	
//==================Meteodos Paciente===========================================================================================
	
	public Patient getPatientById(Long id) {	
		return this.sessionFactory.getCurrentSession().get(Patient.class, id);
	}
	
	
	public Optional<Patient> getPatientByEmail(String email)throws VaxException{	
		return this.sessionFactory.getCurrentSession().createQuery("from Patient pa where pa.email='" + email + "'").uniqueResultOptional(); 
	}
	
	
//==================Meteodos Vaccine==============================================================================================
	
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
	
	
//==================Meteodos Centre=============================================================================================	
	
	public Centre getCentreById(Long id) {

		return this.sessionFactory.getCurrentSession().get(Centre.class, id);
	}
	
	public Optional<Centre> getCentreByName(String name) throws VaxException{

		return this.sessionFactory.getCurrentSession().createQuery("from Centre ce where ce.name='" + name + "'").uniqueResultOptional();
	}
	
	public Centre updateCentre(Centre centre) {

		this.sessionFactory.getCurrentSession().update(centre);
		return this.getCentreById(centre.getId());
	}
	

//==================Meteodos Nurse=============================================================================================		
	
	public Nurse getNurseById(Long id) {

		return this.sessionFactory.getCurrentSession().get(Nurse.class, id);
	}
	
//==================Meteodos SupportStaff======================================================================================	
	
	public SupportStaff getSupportStaffById(Long id) {

		return this.sessionFactory.getCurrentSession().get(SupportStaff.class, id);
	}
	
	
	public Optional<SupportStaff> getSupportStaffByDni(String dni) {

		return this.sessionFactory.getCurrentSession().createQuery("from SupportStaff ss where ss.dni='" + dni + "'").uniqueResultOptional();
	}
	
	
	
//==================Meteodos VaccinationSchedule==============================================================================
	
	public VaccinationSchedule getVaccinationScheduleById(Long id) {

		return this.sessionFactory.getCurrentSession().get(VaccinationSchedule.class, id);
	}
	
	public void updateVaccinationSchedule(VaccinationSchedule vaccinationshedule) {
		this.sessionFactory.getCurrentSession().update(vaccinationshedule);		
	}
	
	
//==================Meteodos Shot==============================================================================================	
	
	public Shot getShotById(Long id) {

		return this.sessionFactory.getCurrentSession().get(Shot.class, id);
	}
	



//==================Meteodos ShotCerificate==============================================================================================


	public Optional<ShotCertificate> getShotCertificateBySerialNumber(int serial_number) {
		
		return this.sessionFactory.getCurrentSession().createQuery("from ShotCertificate ss where ss.serialNumber='" + serial_number + "'").uniqueResultOptional();
	}


//==========================================================================================================================================
//==========================================================================================================================================	
	
	public List<Patient> getAllPatients() {
		return this.sessionFactory.getCurrentSession().createQuery("from Patient").list();
	}


	public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
		return this.sessionFactory.getCurrentSession().createQuery("from Nurse n where n.experience > '" + years + "'").list();
	}


	
	public List<Centre> getCentresTopNStaff(int n) {
		String query = "Select c from Centre c group by c.id order by size(c.staffs) desc";
		return this.sessionFactory.getCurrentSession().createQuery(query).setMaxResults(n).getResultList();
	}


	public Centre getTopShotCentre() {
		String query = "Select s.centre from Shot s group by s.centre order by count(s.centre) desc";
		return (Centre) this.sessionFactory.getCurrentSession().createQuery(query).setMaxResults(1).uniqueResult();
	}


	public List<Nurse> getNurseNotShot() {
		String query = "select n from Nurse n left join Shot s on n.id = s.nurse where s.nurse is null";
		return this.sessionFactory.getCurrentSession().createQuery(query).list();
	}


	public SupportStaff getLessEmployeesSupportStaffArea() {
		String query = "from SupportStaff s group by s.area order by count(s.area) asc";
		return (SupportStaff) this.sessionFactory.getCurrentSession().createQuery(query).setMaxResults(1).uniqueResult();
	}


	public List<Staff> getStaffWithName(String name) {
		String query = "from Staff where fullname like '"+ '%' + name + '%' +"'";
		return this.sessionFactory.getCurrentSession().createQuery(query).getResultList();
	}


	public List<Vaccine> getUnappliedVaccines() {
		String query = "select v from Vaccine v left join Shot s on v.id = s.vaccine where s.vaccine is null ";
		return this.sessionFactory.getCurrentSession().createQuery(query).list();
	}


	public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate) {
		String query = "from ShotCertificate where date between '" + startDate + "' and '" + endDate +"' ";
		return this.sessionFactory.getCurrentSession()
				.createQuery("FROM ShotCertificate AS sc WHERE sc.date BETWEEN :stDate AND :edDate ")
				.setParameter("stDate", startDate)
				.setParameter("edDate", endDate)
				.list();
	}
	

	

	


	

	
}
