package ttps.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Tag implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id;
	
	@Column(unique = true, nullable = false)
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "tags", cascade =  { CascadeType.ALL})
	private Set<Post> posts = new HashSet<>();
	
	
	public Tag(){	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
	
}
