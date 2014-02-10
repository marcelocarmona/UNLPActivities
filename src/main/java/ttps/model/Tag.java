package ttps.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Tag implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags", cascade = CascadeType.PERSIST)
	private List<Post> posts;
	
	public Tag(){	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
