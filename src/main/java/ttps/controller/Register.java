package ttps.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import ttps.access.api.UserDAO;
import ttps.model.Guest;
import ttps.model.User;
import ttps.repository.UserRepository;
import ttps.service.GenericService;
import ttps.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Register extends ActionSupport implements ModelDriven<User>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private String name;
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getPassword2() {
//		return password2;
//	}
//
//	public void setPassword2(String password2) {
//		this.password2 = password2;
//	}
//
//	private String lastName;
//	private String password;
//	private String password2;
	@Autowired
	private GenericService<User> userService;
	
	public GenericService<User> getUserService() {
		return userService;
	}

	public void setUserService(GenericService<User> userService) {
		this.userService = userService;
	}

	public String execute() {
//		user.setName(getName());
//		user.setLastName(getLastName());
//		user.setPassword(getPassword());
		user.setProfile(new Guest());
		if(userService == null)
			System.out.println("esta nulo");
		else userService.save(user);
		return SUCCESS;
	}
	
	public void validate(){
		if (user.getName().equals(""))
			addFieldError("name", "Se requiere un nombre de usuario");
		if (user.getLastName().equals(""))
			addFieldError("lastName","Se requiere un apellido");
		if (user.getPassword().equals(""))
			addFieldError("password", "Se requiere una contraseña");
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		if (request.getParameter("password2").equals(""))
			addFieldError("password2","Se requiere repetir la contraseña");
		else if (!user.getPassword().equals(request.getParameter("password2")))
			addFieldError("password2","las contraseñas deben coincidir");
	}

	private User user= new User();
	
	@Override
	public User getModel() {
		return user;
	}
}
