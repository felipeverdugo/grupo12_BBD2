package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.Collection;

public class Staff {
	private String dni;
	private String fullName;
	private Collection<Centre> centres = new ArrayList<Centre>();
	
	public Staff(String dni, String fullName) {
		super();
		this.dni = dni;
		this.fullName = fullName;
	}
	
	public String getDni() {
		return dni;
	}


	public String getFullName() {
		return fullName;
	}
	
	
	public Collection<Centre> getCentres() {
		// TODO Auto-generated method stub
		return centres;
	}
	
	

	public void addCentre(Centre centre) {
		this.centres.add(centre);
		
	}
	
}
