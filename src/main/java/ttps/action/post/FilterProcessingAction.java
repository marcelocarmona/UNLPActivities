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
public class FilterProcessingAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired private PostService postService;
	@Autowired private CategoryService categoryService;
	private List<Category> categories;
	private List<Post> posts;
	private long idCategory;


	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}

	@Override
	@Action(results = {@Result(name = SUCCESS, location = "list.jsp" )})
	public String execute() throws Exception {
		setPosts(postService.findPostsByIdCategory(idCategory));
		setCategories(categoryService.findAll());
		return SUCCESS;
	}
	




}
