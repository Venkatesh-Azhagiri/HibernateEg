package Many.to.Many;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.SupportedOptions;
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
@Table(name = "Event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id")
	private Long eventId;
	@ManyToMany
	@JoinTable(name="event_delegate_tbl" , joinColumns={@JoinColumn(name="eventId")},inverseJoinColumns={@JoinColumn(name="delegateId")})
	private List<Delegate> delegateList = new ArrayList<Delegate>();

	@Column(name = "event_name")
	private String eventName;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public List<Delegate> getDelegateList() {
		return delegateList;
	}

	public void setDelegateList(List<Delegate> delegateList) {
		this.delegateList = delegateList;
	}

}
