package ar.edu.unlp.info.bd2.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.service.spi.InjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Shot;
import ar.edu.unlp.info.bd2.model.ShotCertificate;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;
import ar.edu.unlp.info.bd2.repositories.VaxException;
import ar.edu.unlp.info.bd2.repositories.VaxRepository;

@Service
public class VaxServiceImpl implements VaxService{


	private VaxRepository repository;
	
	public VaxServiceImpl() {
		
	}

	public VaxServiceImpl(VaxRepository repository) {
		this.repository = repository;
	}
	
	public VaxRepository getRepository() {
		return repository;
	}
	
	
	

//==================Meteodos Patient=======================

	public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException{
		Optional<Patient> aux = this.repository.getPatientByEmail(email);
		if (aux.isPresent()) {
			throw new VaxException("Constraint Violation");
		}
		Patient patient = new Patient(email, fullname, password, dayOfBirth);
		Serializable serializablePatient = this.repository.create(patient);
		
		return this.repository.getPatientById((Long) serializablePatient);
	}
	
	public Optional<Patient> getPatientByEmail(String email) throws VaxException {
//		List<Patient> lista = this.repository.getPatientByEmail(email);
//		return lista.stream(). 
//		filter(v -> v.getEmail().equals(email)).
//		findFirst();
		return this.repository.getPatientByEmail(email);
	}
	
	


//==================Meteodos Vaccine=======================
	
	public Vaccine createVaccine(String name) throws VaxException {
		Optional<Vaccine> aux = this.repository.getVaccineByName(name);
		if (aux.isPresent()) {
			throw new VaxException("Constraint Violation");
		}
		Vaccine vaccine = new Vaccine(name);
		Serializable serializableVacinne = this.repository.create(vaccine);
		
		return this.repository.getVaccineById((Long) serializableVacinne);
	}
	
	public Optional<Vaccine> getVaccineByName(String name) throws VaxException{
		return this.repository.getVaccineByName(name);
	}
	

	
	
	
	
//==================Meteodos Centre=======================	
	
	public Centre createCentre(String name) throws VaxException  {			
		Centre centre = new Centre(name);
		Serializable serializableCentre = this.repository.create(centre);
		
		return this.repository.getCentreById((Long) serializableCentre);
	}
	
	public Optional<Centre> getCentreByName(String name) throws VaxException  {			
		return this.repository.getCentreByName(name);
	}
	
	
	@Override
	public Centre updateCentre(Centre centre) {		
		return this.repository.updateCentre(centre);
	}
	

	
	
	
	
//==================Meteodos Nurse=======================	

	@Override
	public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException  {
		Nurse nurse = new Nurse(dni, fullName, experience);
		Serializable serializableCentre = this.repository.create(nurse);
		
		return this.repository.getNurseById((Long) serializableCentre);	
	}
	

	
	
	
	
//==================Meteodos SupportStaff=======================

	@Override
	public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException  {
		SupportStaff supportStaff = new SupportStaff(dni, fullName, area);
		Serializable serializableCentre = this.repository.create(supportStaff);
		
		return this.repository.getSupportStaffById((Long) serializableCentre);
	}
	
	@Override
	public Optional<SupportStaff> getSupportStaffByDni(String dni) {
		return this.repository.getSupportStaffByDni(dni);
	}
	

	
	
	
	
//==================Meteodos VaccinationSchedule=======================

	public VaccinationSchedule createVaccinationSchedule() throws VaxException {
		VaccinationSchedule vaccinationSchedule = new VaccinationSchedule();
		Serializable serializableCentre = this.repository.create(vaccinationSchedule);
		
		return this.repository.getVaccinationScheduleById((Long) serializableCentre);
	}
	
	
	public VaccinationSchedule getVaccinationScheduleById(Long id) {
		
		return this.repository.getVaccinationScheduleById(id);
	}
	

	
	
	
	
//==================Meteodos Shot=======================		


	@Override
	public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException {
		Shot shot = new Shot(patient, vaccine, date, centre, nurse);
		patient.addShot(shot);
		
		Serializable serializableCentre = this.repository.create(shot);
		
		return this.repository.getShotById((Long) serializableCentre);	
		
	}
	
	
	public Optional<ShotCertificate> getShotCertificateBySerialNumber(int serial_number) {
		return this.repository.getShotCertificateBySerialNumber(serial_number);
	}
	
	


}
