package ttps.action.post;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import ttps.model.Category;
import ttps.model.Post;
import ttps.service.CategoryService;
import ttps.service.PostService;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/post")
public class ListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PostService postService;
	@Autowired
	private CategoryService categoryService;
	private List<Category> categories;
	private List<Post> posts;

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

	@Override
	public String execute() throws Exception {
		setCategories(categoryService.findAll());
		setPosts(postService.findAll());
		return SUCCESS;
	}

}
