package ttps.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import ttps.model.Gender;
import ttps.model.Role;
import ttps.model.User;
import ttps.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/user")
@Results({ @Result(name = "failure", location = "fail.jsp")})
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService userService;
	private List<User> users;
	private long id;
	private User user;
	private Gender[] genders = Gender.values();
	private Role[] roles = Role.values();
	
	
	//Getters and Setters
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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
	
	public Gender[] getGenders() {
		return genders;
	}

	public void setGenders(Gender[] genders) {
		this.genders = genders;
	}

	public Role[] getRoles() {
		return roles;
	}

	public void setRoles(Role[] roles) {
		this.roles = roles;
	}

	//Actions
	
	@Action("list")
	public String list(){
		users = userService.findAll();
		return SUCCESS;
	}
	
	@Action("view")
	public String view(){
		user = userService.findOne(id);
		return SUCCESS;
	}
	
	@Action("edit")
	public String edit(){
		user = userService.findOne(id);
		return SUCCESS;
	}
	
	@Action(value = "save", results = { 
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = "input", location = "edit.jsp")})
	public String save(){
		user = userService.save(user);
		return SUCCESS;
	}
	

	@Action(value = "delete", results = { @Result(name = SUCCESS, location = "list", type = "redirect") })
	public String delete() {
		userService.delete(id);
		return SUCCESS;
	}

	
	
	
	//TODO refactoring JRS-303
	public void validate(){
		if(user != null){
			if (user.getUsername().equals(""))
				addFieldError("user.username", "Se requiere un nombre de usuario");
			if (user.getName().equals(""))
				addFieldError("user.name", "Se requiere un nombre");
			if (user.getLastName().equals(""))
				addFieldError("user.lastName","Se requiere un apellido");
			if (user.getPassword().equals(""))
				addFieldError("user.password", "Se requiere una contraseña");
			if (user.getRole() == null)
				addFieldError("user.role", "Se requiere un rol");
		}
	}








}