package collectionEg1;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Venkatesh
 *
 */
@Entity
@NamedQuery(name ="UserInfo", query="from User where userId = ?")
@Table(name ="user_eg1")
public class User {
	
	
	private int userId;	
	private String userName;
	
	private Set<Address> listOfAddress = new HashSet();
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setListOfAddress(Set<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	@ElementCollection
	public Set<Address> getListOfAddress() {
		return listOfAddress;
	}
	
	
	
}
