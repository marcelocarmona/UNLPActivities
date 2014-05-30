package ttps.model;

import java.io.Serializable;

import javax.persistence.*;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractPublic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	private String title;

	private String description;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "id_category", nullable=false)
	private Category category;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="id_user") private User user;
	 */

	public String getTitle() {
		return title;
	}

	@RequiredStringValidator(message = "El tiulo es un campo obligatorio.")
	@StringLengthFieldValidator(minLength = "4", maxLength = "12", message = "El titulo debe tener entre 4 y 12 caracteres")
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	@RequiredStringValidator(message = "Se debe ingresar una descripción")
	@StringLengthFieldValidator(minLength = "4",maxLength = "30", message = "La descripción debe tener entre 4 y 30 caracteres")
	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

//	@RequiredStringValidator(message = "Se debe ingresar una categoría")
	public void setCategory(Category category) {
		this.category = category;
	}
	/*
	 * public User getUser() { return user; } public void setUser(User user) {
	 * this.user = user; }
	 */
}
