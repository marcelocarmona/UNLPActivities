package ttps.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Post extends AbstractPublic {
	//@Id @GeneratedValue
	//private int id_post;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="post",cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	private boolean privacity;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "Post_Tag", joinColumns = { @JoinColumn(name = "id_post") }, inverseJoinColumns = { @JoinColumn(name = "id_tag") })
	private List<Tag> tags;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_user")
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post() {
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public boolean isPrivacity() {
		return privacity;
	}
	public void setPrivacity(boolean privacity) {
		this.privacity = privacity;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
