package EmbeddedEg1;

import javax.persistence.Embeddable;


@Embeddable
public class AddressType {
	
	private String streetName;
	private String location;
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
