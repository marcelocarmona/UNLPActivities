package ttps.action;



import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import ttps.model.Category;
import ttps.model.Post;
import ttps.service.impl.CategoryService;
import ttps.service.impl.PostService;



@Namespace("/post")
public class PostAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	private Post post;

	private List<Category> categories;
	
	private Category category;

	private List<Post> posts=new ArrayList<Post>();

	private long idPost;

	//Getter and setters
	public Category getCategory() {
		return category;
	}

	public void setCategoryName(Category category) {
		this.category = category;
	}

	public long getIdPost() {
		return idPost;
	}

	public void setIdPost(long idPost) {
		this.idPost = idPost;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	//Actions	
	
	@Action("list")
	public String posts() {
		setPosts(postService.findAll());
        return SUCCESS;
	}
	
	@Action("edit")
	public String edit() {
		setCategories(categoryService.findAll());
        return SUCCESS;
	}
	
	@Action(value = "save", results = { 
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = "input", location = "edit.jsp")})
	public String save() {
		postService.save(post);
        return SUCCESS;
	}
	

	@Action(value = "delete", results = { @Result(name = SUCCESS, location = "list", type = "redirect") })
	public String deletePost() {
		postService.delete(idPost);
		return SUCCESS;
	}
	
	
}
