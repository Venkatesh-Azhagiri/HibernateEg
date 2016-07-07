package one.to.one.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "EmployeeDetails")
public class EmployeeDetails {
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employeeId")
	private Employees employee;
	@Id
	@GeneratedValue(generator ="generator1")
	@GenericGenerator(name ="generator1", strategy = "foreign", parameters ={@Parameter(value="employee",
	name="property")})	
	private int employeeId;
	private String address;
	private String designation;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Employees getEmployee() {
		return employee;
	}
	public void setEmployee(Employees employee) {
		this.employee = employee;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
