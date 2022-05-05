package ar.edu.unlp.info.bd2.model;




public class Nurse extends Staff{
	private Integer experience;

	

	public Nurse(String dni, String fullName, Integer experience) {
		super(dni,fullName);
		this.experience = experience;
	}



	public Integer getExperience() {
		return experience;
	}




	
	

}
