package ar.edu.unlp.info.bd2.model;

import java.util.Date;

public class ShotCertificate {
	private Date date;
	private long serialNumber;
	
	
	public ShotCertificate(Date date, long serialNumber) {
		super();
		this.date = date;
		this.serialNumber = serialNumber;
	}


	public Date getDate() {
		return date;
	}




	public long getSerialNumber() {
		return serialNumber;
	}



	
}
