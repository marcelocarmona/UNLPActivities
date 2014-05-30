package ttps.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

@Entity
public class Comment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private long id;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="id_post")
	private Post post;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="id_user")
	private User user;

	private String content;
	
	public Comment(){	
	}
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getContent() {
		return content;
	}

	@RequiredStringValidator(message = "Se debe ingresar un contenido")
	@StringLengthFieldValidator(minLength = "10", message = "El contenido debe tener almenos 10 caracteres")
	public void setContent(String content) {
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
