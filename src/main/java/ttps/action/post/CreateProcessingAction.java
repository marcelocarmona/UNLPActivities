package ttps.action.post;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;

import ttps.model.Category;
import ttps.model.Post;
import ttps.model.User;
import ttps.service.CategoryService;
import ttps.service.PostService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@Namespace("/post")
public class CreateProcessingAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 1L;

	@Autowired private PostService postService;
	@Autowired private CategoryService categoryService;
	private Post post;
	private String tagStrings;
	private List<Category> categories;
	private User sessionUser;

	@VisitorFieldValidator
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getTagStrings() {
		return tagStrings;
	}

	@RequiredStringValidator(message = "Se requiere almenos un tag")
	public void setTagStrings(String tagStrings) {
		this.tagStrings = tagStrings;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	@Override
	@Action(results = {
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = "input", location = "create.jsp") })
	
	public String execute() throws Exception {
		 //le agrego al post usuario de session
		post.setUser(sessionUser);
		
		//parcing tagStrings and creates tags
		String[] tagNames = tagStrings.split(",");
		
		//custom save
		postService.savePostWithTags(post,tagNames);
		return SUCCESS;
	}


	//metodo necesario para validar
	@Override
	public void prepare() throws Exception {
		categories = categoryService.findAll();
		if(ActionContext.getContext().getSession().get("SPRING_SECURITY_CONTEXT") != null)
		sessionUser = ((User) ((SecurityContext) ActionContext.getContext().getSession().get("SPRING_SECURITY_CONTEXT")).getAuthentication().getPrincipal());
	}


}
