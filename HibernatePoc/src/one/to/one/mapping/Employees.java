package one.to.one.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name = "Employee")
public class Employees {
	private int employeeId;
	private String employeeName;
	//@OneToOne(cascade =CascadeType.ALL, fetch=FetchType.EAGER)
	//@JoinColumn(name="employeeId")
	//private EmployeeDetails empDetails;
	/*public EmployeeDetails getEmpDetails() {
		return empDetails;
	}
	public void setEmpDetails(EmployeeDetails empDetails) {
		this.empDetails = empDetails;
	}*/
	@Id
	@TableGenerator(initialValue=1, name = "tbl")
	@GeneratedValue(strategy= GenerationType.TABLE, generator="tbl")
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	
	

}
