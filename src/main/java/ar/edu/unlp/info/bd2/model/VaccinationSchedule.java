package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vaccinationSchedules")
public class VaccinationSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_shedule", nullable = false)
	private long id;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="vaccines_shedules" )
    private List<Vaccine> vaccines;
	
	

	public VaccinationSchedule() {		
		this.vaccines = new ArrayList<Vaccine>();
	}

	public List<Vaccine> getVaccines() {
		return this.vaccines;
	}

	public void addVaccine(Vaccine vaccine) {
		this.vaccines.add(vaccine);
		vaccine.addShedule(this);
	}

	public Long getId() {
		return id;
	}
	
	
	
	
	
	
}
