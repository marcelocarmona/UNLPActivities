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

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

@Entity
public class Post extends AbstractPublic {

	private static final long serialVersionUID = 1L;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "post", cascade = CascadeType.DETACH)
	private Set<Comment> comments = new HashSet<>();

	
	private String content;

	private boolean privacity;

	@ManyToMany(fetch = FetchType.EAGER )
	private Set<Tag> tags = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_user")
	private User user;

	public User getUser() {
		return user;
	}

//	@RequiredStringValidator(message = "El post debe tener un usuario como dueño")
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

	@RequiredStringValidator(message = "Se debe ingresar un contenido")
	@StringLengthFieldValidator(minLength = "10", message = "El contenido debe tener almenos 10 caracteres")
	public void setContent(String content) {
		this.content = content;
	}
}
