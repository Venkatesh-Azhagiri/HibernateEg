package one.to.one.mapping.eg2;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "worker")
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "worker_id")
	private Long workerId;

	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "birth_date")
	private Date birthDate;
	@Column(name = "cell_phone")
	private String cellPho;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="worker_id")	
	private WorkerDetail workerDetail;
	public Long getWorkerId() {
		return workerId;
	}

	public WorkerDetail getWorkerDetail() {
		return workerDetail;
	}

	public void setWorkerDetail(WorkerDetail workerDetail) {
		this.workerDetail = workerDetail;
	}

	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellPho() {
		return cellPho;
	}

	public void setCellPho(String cellPho) {
		this.cellPho = cellPho;
	}

}
