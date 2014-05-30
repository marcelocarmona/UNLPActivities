package ttps.action.user;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import ttps.model.Gender;
import ttps.model.User;
import ttps.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class PerfilProcessingAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private User user;
	@Autowired
	private UserService userService;
	private Gender[] genders = Gender.values();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public Gender[] getGenders() {
		return genders;
	}

	public void setGenders(Gender[] genders) {
		this.genders = genders;
	}

	@Action(results = { @Result(name = SUCCESS, location = "perfil", type="redirect"),
			@Result(name = "input", location = "perfil.jsp")})
	public String execute() throws Exception {
		User userTemp = userService.findOne(user.getId());
		user.setRole(userTemp.getRole());
		user = userService.save(user);
		return SUCCESS;
	}

	public void validate() {
		if (user != null) {
			if (user.getUsername().equals(""))
				addFieldError("user.username",
						"Se requiere un nombre de usuario");
			if (user.getName().equals(""))
				addFieldError("user.name", "Se requiere un nombre");
			if (user.getLastName().equals(""))
				addFieldError("user.lastName", "Se requiere un apellido");
			if (user.getPassword().equals(""))
				addFieldError("user.password", "Se requiere una contraseña");
		}
	}



}
