package ttps.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import ttps.model.Role;
import ttps.model.User;
import ttps.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;
	private long id;
	private User user;
	
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
	
	@Action(value = "register" )
	public String register() {
		return SUCCESS;
	}
	
	@Action(value = "saveGuest", results = { 
			@Result(name = SUCCESS, location = "index.jsp"),
			@Result(name = "input", location = "register.jsp")})
	public String saveGuest(){
		user.setRole(Role.GUEST);
		System.out.println(user.getUsername()+user.getPassword()+user.getRole());
		user = userService.save(user);
		return SUCCESS;
	}
	
	public void validate(){
		if(user != null){
			if (user.getUsername().equals(""))
				addFieldError("user.username", "Se requiere un nombre de usuario");
			if (user.getPassword().equals(""))
				addFieldError("user.password", "Se requiere una contraseña");
		}
	}
}
