package EmbeddedEg1;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int addressId;
	private String country;
	private String city;	
	@Embedded
	private AddressType addressType;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name ="streetName", column= @Column(name="office_street_name")),
		@AttributeOverride(name ="location", column= @Column(name="office_location"))
	})
	private AddressType officeAddress;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public AddressType getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(AddressType officeAddress) {
		this.officeAddress = officeAddress;
	}
	
}
