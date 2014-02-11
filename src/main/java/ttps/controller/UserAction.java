package ttps.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ttps.model.Event;
import ttps.model.Post;
import ttps.model.Role;
import ttps.model.User;
import ttps.service.impl.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;
	
	private User user= new User();
	private String password2;
	private long idUser;
	private boolean editable = false; 
	
	private List<User> userList = new ArrayList<User>();
	private String authority;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	public String save() {
		ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new Role(authority));
        userService.save(
        		new User(user.getName(),user.getLastName(),new ArrayList<Post>(),new ArrayList<Event>(), user.getUsername(),user.getPassword(), roles,true,true,true,true));
        return SUCCESS;
	}
	
	public String list() {
		userList=userService.findAll();
		setEditable(false);
		return SUCCESS;
	}
	
	public String delete(){
		userService.delete(idUser);
		return SUCCESS;
	}
	
	public String edit() {
		user = userService.findOne(idUser);
		setEditable(true);
		return SUCCESS;
	}
	
	public String regMod() {
		setEditable(true);
		return SUCCESS;
	}
	
	public void validate(){
		if(user.getName()!=null){
			if (user.getUsername().equals(""))
				addFieldError("username", "Se requiere un nombre de usuario");
			if (user.getName().equals(""))
				addFieldError("name", "Se requiere un nombre");
			if (user.getLastName().equals(""))
				addFieldError("lastName","Se requiere un apellido");
			if (user.getPassword().equals(""))
				addFieldError("password", "Se requiere una contraseña");
			if (password2.equals(""))
				addFieldError("password2","Se requiere repetir la contraseña");
			else if (!user.getPassword().equals(password2))
				addFieldError("password2","Las contraseñas deben coincidir");
		}
	}


	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	@Override
	public User getModel() {
		return user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
