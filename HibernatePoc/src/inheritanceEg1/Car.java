package inheritanceEg1;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle{
	private String jaguar;

	public String getJaguar() {
		return jaguar;
	}

	public void setJaguar(String jaguar) {
		this.jaguar = jaguar;
	}
	
	

}
