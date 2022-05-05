package ar.edu.unlp.info.bd2.model;



public class SupportStaff extends Staff{
	private String area;

	
	public SupportStaff(String dni, String fullName, String area) {
		super(dni,fullName);
		this.area = area;
	}



	public String getArea() {
		// TODO Auto-generated method stub
		return area;
	}






}
