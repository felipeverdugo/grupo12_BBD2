package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "Centre")
@Table(name = "centre")
public class Centre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "centre_id")
	private Collection<Staff> staffs = new ArrayList<Staff>();

	
	

	public Centre() {
	}
	
	public Centre(String name) {
		this.name = name;
	}
	


	public String getName() {
		return name;
	}
	
	public Collection<Staff> getStaffs() {
		return staffs;
	}
	
	public void addStaff(Staff staff) {
		this.staffs.add(staff);
	}
	
	
	











	public void setIdCentre(long id) {
		this.id = id;
	}




	public void setName(String name) {
		this.name = name;
	}




//	public void setStaffs(Collection<Staff> staffs) {
//		this.staffs = staffs;
//	}
//
//
//
//
//	public void addStaff(Nurse nurse) {
//		this.staffs.add(nurse);
//		nurse.addCentre(this);
//
//	}
//	public void addStaff(SupportStaff supportStaff) {
//		this.staffs.add(supportStaff);
//		supportStaff.addCentre(this);
//		
//	}



	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}




//	public Collection<Staff> getStaffs() {
//		// TODO Auto-generated method stub
//		return staffs;
//	}
	




}
