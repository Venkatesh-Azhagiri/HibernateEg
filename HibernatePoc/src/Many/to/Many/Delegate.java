package Many.to.Many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Delegate")
public class Delegate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="delegate_id")
	private Long delegateId;
	@ManyToMany
	@JoinTable(name="event_delegate_tbl" , joinColumns={@JoinColumn(name="delegateId")},inverseJoinColumns={@JoinColumn(name="eventId")})
	private List<Event> eventList = new ArrayList<Event>();
	
	@Column(name="delegate_name")
	private String delegateName;

	public Long getDelegateId() {
		return delegateId;
	}

	public void setDelegateId(Long delegateId) {
		this.delegateId = delegateId;
	}

	public String getDelegateName() {
		return delegateName;
	}

	public void setDelegateName(String delegateName) {
		this.delegateName = delegateName;
	}

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}
	
	

}
