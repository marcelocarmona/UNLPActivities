package ttps.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;
	@Column(unique = true, nullable = false)
	private String name;

	@OneToMany(mappedBy="category",cascade = CascadeType.ALL)
	private List<AbstractPublic> publics;
	
	public Category() {
	}
	
	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AbstractPublic> getPublics() {
		return publics;
	}

	public void setPublics(List<AbstractPublic> publics) {
		this.publics = publics;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
