package ttps.action.user;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ttps.model.Gender;
import ttps.model.User;
import ttps.service.UserService;

@Namespace("/user")
public class PerfilAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	private User user;
	private Gender[] genders = Gender.values();

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

	public String execute() throws Exception {
		User sessionUser = ((User) ((SecurityContext) ActionContext.getContext().getSession().get("SPRING_SECURITY_CONTEXT")).getAuthentication().getPrincipal());
		user = userService.findOne(sessionUser.getId());
		return SUCCESS;
	}

}
