package ar.edu.unlp.info.bd2.repositories;

import org.springframework.transaction.annotation.Transactional;


@Transactional
public class VaxException extends Exception {
	private static final long serialVersionUID = -6794099354377771004L;
	private String message = "";
	

	public VaxException(String message) {
		
		super(message);
		this.message = message;
		System.out.println("------------------------"+message+"---------------------------");
	}



	public String getMessage() {
		return message;
	}


	

}
