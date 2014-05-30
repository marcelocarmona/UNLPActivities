package ttps.action.post;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import ttps.model.Category;
import ttps.model.Post;
import ttps.service.CategoryService;
import ttps.service.PostService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@Namespace("/post")
public class EditProcessingAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 1L;

	@Autowired private PostService postService;
	@Autowired private CategoryService categoryService;
	private Post post;
	private String tagStrings;
	private List<Category> categories;

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
			@Result(name = SUCCESS, location = "list", type = "redirect")})
	public String execute() throws Exception {

		// parcing tagStrings and creates tags
		String[] tagNames = tagStrings.split(",");

		// custom save
		postService.savePostWithTags(post, tagNames);

		return SUCCESS;
	}

	//metodo necesario para validar
	@Override
	public void prepare() throws Exception {
		categories = categoryService.findAll();
	}


}
