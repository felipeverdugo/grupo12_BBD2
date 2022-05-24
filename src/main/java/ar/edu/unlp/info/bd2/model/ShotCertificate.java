package ar.edu.unlp.info.bd2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "ShotCertificate")
@Table(name = "shotCertificate")
public class ShotCertificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column()
	private Date date;
	
	@Column
	private long serialNumber;
	//falta validar q no se repita
	
	public ShotCertificate(Date date) {
		this.date = date;
		this.serialNumber = 100 + (int)(Math.random() * ((1000 - 100) + 1)); //valor aleatorio entre 100 y 1000
	}
	
	public ShotCertificate() {
		
	}
	
	public Date getDate() {
		return date;
	}

	public long getSerialNumber() {
		return serialNumber;
	}



	
}
