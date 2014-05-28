package ttps.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post extends AbstractPublic {

	private static final long serialVersionUID = 1L;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "post", cascade = CascadeType.DETACH)
	private Set<Comment> comments = new HashSet<>();

	private String content;

	private boolean privacity;

	@ManyToMany(fetch = FetchType.EAGER )
	private Set<Tag> tags = new HashSet<>();

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_user")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post() {
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public boolean isPrivacity() {
		return privacity;
	}

	public void setPrivacity(boolean privacity) {
		this.privacity = privacity;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
