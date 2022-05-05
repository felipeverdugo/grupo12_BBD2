package ar.edu.unlp.info.bd2.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity(name = "Vaccine")
@Table(name = "Vaccine")
public class Vaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	@Column
	private String name;
	
	
	public Vaccine() {
	
	}
	
	public Vaccine(String name) {
		this.name = name;
	}
	
	
	
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vaccine [id=" + id + ", name=" + name + "]";
	}





	public String getName() {
		return name;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
}
