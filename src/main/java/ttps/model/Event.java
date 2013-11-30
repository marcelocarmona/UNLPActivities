package ttps.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Event extends AbstractPublic {
	//@Id @GeneratedValue
	//private int id_event;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "date", columnDefinition="DATETIME")
	private Date date;
	private String place;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event() {
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}

	
}
