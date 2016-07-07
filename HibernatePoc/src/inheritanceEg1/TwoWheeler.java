package inheritanceEg1;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {
	
	private String honda;

	public String getHonda() {
		return honda;
	}

	public void setHonda(String honda) {
		this.honda = honda;
	}
	
}
