package ttps.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;








import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class User implements UserDetails, Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private String lastName;
	
	@Enumerated
	private Gender gender;
	
	@Column(unique = true, nullable = false)
	private String mail;

	private String birthday;
	
	private String nationality;
	
	private String profession;
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Post> posts;
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Event> events;
	//@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	//private List<AbstractPublic> publics;
	
	
	/* Spring Security fields */
	@Column(unique = true, nullable = false)
	private String username;
	private String password;
	
//	@OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
//	@JoinColumn(name="user_id")
//	private Collection<Role> authorities;

	@OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private Collection<Role> authorities;	
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	

	public User(){
	}
	
	//TODO Borrar Contructor
	/**
	 * Single constructor to Test
	 * @param name name of user
	 */
	public User(String name) {
		super();
		this.name = name;
		this.lastName = name;
		this.mail = name+"@email.com";
		this.nationality = name;
		this.profession = name;
		this.username = name;
		this.password = name;
		this.authorities = new ArrayList<Role>();
		this.accountNonExpired = true;
		this.accountNonLocked = true;
		this.credentialsNonExpired = true;
		this.enabled = true;
	}

	public User(String name, String lastName, String mail,
			String nationality, String profession, List<Post> posts,
			List<Event> events, String username, String password,
			Collection<Role> authorities, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired,
			boolean enabled) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.mail = mail;
		this.nationality = nationality;
		this.profession = profession;
		this.posts = posts;
		this.events = events;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	public void setAuthorities(Collection<Role> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
