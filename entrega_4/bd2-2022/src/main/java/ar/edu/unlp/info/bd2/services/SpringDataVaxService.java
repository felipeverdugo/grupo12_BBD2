package ar.edu.unlp.info.bd2.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Shot;
import ar.edu.unlp.info.bd2.model.ShotCertificate;
import ar.edu.unlp.info.bd2.model.Staff;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;

import ar.edu.unlp.info.bd2.repositories.*;

@Service
public class SpringDataVaxService implements VaxService {

	@Autowired
	CentreRepository centreRepository;
	@Autowired
	NurseRepository nurseRepository;
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	ShotCertificateRepository shotCertificateRepository;
	@Autowired
	ShotRepository shotRepository;
	@Autowired
	StaffRepository staffRepository;
	@Autowired
	SupportStaffRepository supportStaffRepository;
	@Autowired
	VaccinationScheduleRepository vaccinationScheduleRepository;
	@Autowired
	VaccineRepository vaccineRepository;
	
	@Override
	public List<Patient> getAllPatients() {
		return (List<Patient>) patientRepository.findAll();
	}

	@Override
	public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
		return nurseRepository.findByExperienceGreaterThan(years);
	}

	@Override
	public List<Centre> getCentresTopNStaff(int n) {
		Pageable topN = PageRequest.of(0, n);
		return centreRepository.getCentresTopNStaff(topN);
	}

	@Override
	public Centre getTopShotCentre() {
		//Pageable top = PageRequest.of(0, 1);
		return shotRepository.getTopShotCentre().get(0);
	}

	@Override
	public List<Nurse> getNurseNotShot() {
		return nurseRepository.getNurseNotShot();
	}

	@Override
	public String getLessEmployeesSupportStaffArea() {
		return supportStaffRepository.getLessEmployeesSupportStaffArea().get(0);
	}

	@Override
	public List<Staff> getStaffWithName(String name) {
		return staffRepository.findByFullNameContaining(name);
	}

	@Override
	public List<Vaccine> getUnappliedVaccines() {
		return vaccineRepository.getUnappliedVaccines();
	}

	@Override
	public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate) {
		return  shotCertificateRepository.getShotCertificatesBetweenDates( startDate, endDate);		
	}
	
	//===============================================================================================================
	//---------------------------------------------------------------------------------------------------------------
	//===============================================================================================================
	

	@Override
	public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException { 
		try {
			return patientRepository.save(new Patient(email, fullname, password, dayOfBirth));
		} catch(Exception e) {
			if( e.getClass().equals(org.springframework.dao.DataIntegrityViolationException.class)) {
				throw new VaxException("Constraint Violation");
			}else {
				throw e;
			}			
		}
	}

	@Override
	public Vaccine createVaccine(String name) throws VaxException {
		try {
			return vaccineRepository.save(new Vaccine(name));
		} catch(Exception e) {
			if( e.getClass().equals(org.springframework.dao.DataIntegrityViolationException.class)) {
				throw new VaxException("Constraint Violation");
			}else {
				throw e;
			}
		}
	}

	@Override
	public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException {
		try {
			return shotRepository.save(new Shot(patient, vaccine, date, centre, nurse));
		} catch(Exception e) {
			if( e.getClass().equals(org.springframework.dao.DataIntegrityViolationException.class)) {
				throw new VaxException("Constraint Violation");
			}else {
				throw e;
			}
		}
	}

	@Override
	public Centre createCentre(String name) throws VaxException {
		try {
			return centreRepository.save(new Centre(name));
		} catch(Exception e) {
			if( e.getClass().equals(org.springframework.dao.DataIntegrityViolationException.class)) {
				throw new VaxException("Constraint Violation");
			}else {
				throw e;
			}
		}
	}

	@Override
	public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
		try {
			return nurseRepository.save(new Nurse(dni,fullName,experience));
		} catch(Exception e) {
			if( e.getClass().equals(org.springframework.dao.DataIntegrityViolationException.class)) {
				throw new VaxException("Constraint Violation");
			}else {
				throw e;
			}
		}
	}

	@Override
	public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
		try {
			return supportStaffRepository.save(new SupportStaff(dni,fullName,area));
		} catch(Exception e) {
			if( e.getClass().equals(org.springframework.dao.DataIntegrityViolationException.class)) {
				throw new VaxException("Constraint Violation");
			}else {
				throw e;
			}
		}
	}

	@Override
	public VaccinationSchedule createVaccinationSchedule() throws VaxException {
		try {
			return vaccinationScheduleRepository.save(new VaccinationSchedule());
		} catch(Exception e) {
			if( e.getClass().equals(org.springframework.dao.DataIntegrityViolationException.class)) {
				throw new VaxException("Constraint Violation");
			}else {
				throw e;
			}
		}
	}
	
	@Override
	public Optional<Patient> getPatientByEmail(String email) {
		return patientRepository.findByEmail(email);
	}

	@Override
	public Optional<Vaccine> getVaccineByName(String name) {
		return vaccineRepository.findByName(name);
	}

	@Override
	public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
		return vaccinationScheduleRepository.findById(id).get();
	}

	@Override
	public Optional<Centre> getCentreByName(String name) throws VaxException {
		return centreRepository.findByName(name);
	}

	@Override
	public Centre updateCentre(Centre centre) {
		return centreRepository.save(centre);
	}

	@Override
	public Optional<SupportStaff> getSupportStaffByDni(String dni) {
		return supportStaffRepository.findByDni(dni);
	}

	@Override
	public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
		return supportStaffRepository.save(staff);
	}
	
	@Override
	public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule schedule) {
		return vaccinationScheduleRepository.save(schedule);
	}

}
