package one.to.many.mapping;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "College")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "college_Id")
	private Long collegeId;

	@Column(name = "college_name")
	private String collegeName;
	
	
	@OneToMany(targetEntity = Student.class, cascade=CascadeType.ALL, mappedBy="college")
	private Set<Student> studentSet = new HashSet<Student>(0);


	public Long getCollegeId() {
		return collegeId;
	}


	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}


	public String getCollegeName() {
		return collegeName;
	}


	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}


	public Set<Student> getStudentSet() {
		return studentSet;
	}


	public void setStudentSet(Set<Student> studentSet) {
		this.studentSet = studentSet;
	}
	
	
}
