package ar.edu.unlp.info.bd2.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


//@Entity(name = "Shot")
//@Table(name = "shots")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Shot {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "Id")
	private long id;
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "patient_fk")
	private Patient patient;
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "vaccine_fk")
	private Vaccine vaccine;
//	@Column(name = "Date")
	private Date date;
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "centre_fk")
	private Centre centre;
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "nurse_fk")
	private Nurse nurse;
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "shotCertificate_fk")
	private ShotCertificate shotCertificate;
	
	
	
	
	
	public Shot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) {
		super();
		this.patient = patient;
		this.vaccine = vaccine;
		this.date = date;
		this.centre = centre;
		this.nurse = nurse;
		this.shotCertificate = new ShotCertificate(date, id);
	}
	public Patient getPatient() {
		return patient;
	}
	public Vaccine getVaccine() {
		return vaccine;
	}
	public Date getDate() {
		return date;
	}
	public Centre getCentre() {
		return centre;
	}
	public Nurse getNurse() {
		return nurse;
	}
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public ShotCertificate getShotCertificate() {
		// TODO Auto-generated method stub
		return shotCertificate;
	}
	
	
	
	
	
}
