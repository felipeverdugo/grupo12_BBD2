package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//@Entity
//@Table(name = "VaccinationSchedule")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class VaccinationSchedule {
	
//	@Id
//	@GeneratedValue
	private long idSchedule;
	private Collection<Vaccine> vaccines = new ArrayList<Vaccine>();

	public VaccinationSchedule() {
		super();
	}

	
	
	public Collection<Vaccine> getVaccines() {
		return vaccines;
	}



	public void addVaccine(Vaccine vaccine) {
		this.vaccines.add(vaccine);
		
	}



	public Long getId() {
		// TODO Auto-generated method stub
		return idSchedule;
	}
	
	
	
	
	
	
}
