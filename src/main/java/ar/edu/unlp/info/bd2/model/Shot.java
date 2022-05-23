package ar.edu.unlp.info.bd2.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity(name = "Shot")
@Table(name = "shots")
public class Shot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;
	
	@ManyToOne
    @JoinColumn(name="patient_id")
	private Patient patient;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "vaccine_id")
	private Vaccine vaccine;
			
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "centre_id")
	private Centre centre;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "nurse_id")
	private Nurse nurse;
	
	@Column(name = "Date")
	private Date date;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "shotCertificate_id")
	private ShotCertificate shotCertificate;	
	
	
	public Shot() {
		
	}
	public Shot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) {
		super();
		this.patient = patient;
		this.vaccine = vaccine;
		this.date = date;
		this.centre = centre;
		this.nurse = nurse;
		this.shotCertificate = new ShotCertificate(date);
	}
	
	public long getId() {
		return id;
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
	
	public ShotCertificate getShotCertificate() {
		return shotCertificate;
	}
	
	
	
	
	
}
