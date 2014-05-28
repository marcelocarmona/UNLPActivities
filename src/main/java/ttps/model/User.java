package ttps.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * Reference spring security
 * http://en.tekstenuitleg.net/blog/spring-security-with-roles-and-rights
 * 
 * @author mclo
 */
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

	private Date birthday;
	
	private String nationality;
	
	private String profession;
	
	@Enumerated
	private Role role;
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<Post>();
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Event> events = new ArrayList<Event>();
	//@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	//private List<AbstractPublic> publics;
	
	
	/* Spring Security fields */
	@Column(unique = true, nullable = false)
	private String username;
	private String password;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	

	public User(){
	}
	

	public User(String name, String lastName, Gender gender, String mail,
			Date birthday, String nationality, String profession, Role role,
			String username,
			String password) {
		this(name,lastName,gender,mail,birthday,nationality,profession,role,new ArrayList<Post>(),new ArrayList<Event>(),username,password);
	}

	public User(String name, String lastName, Gender gender, String mail,
			Date birthday, String nationality, String profession, Role role,
			List<Post> posts, List<Event> events, String username,
			String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.mail = mail;
		this.birthday = birthday;
		this.nationality = nationality;
		this.profession = profession;
		this.role = role;
		this.posts = posts;
		this.events = events;
		this.username = username;
		this.password = password;
		this.accountNonExpired = true;
		this.accountNonLocked = true;
		this.credentialsNonExpired = true;
		this.enabled = true;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * return authorities - spring security
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(role);
		return authorities;
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
