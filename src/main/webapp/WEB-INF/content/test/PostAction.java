package ttps.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ttps.model.Category;
import ttps.model.Post;
import ttps.service.impl.CategoryService;
import ttps.service.impl.PostService;
import ttps.service.impl.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PostAction extends ActionSupport implements ModelDriven<Post> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;
	
	private Post post= new Post();

	private List<Category> categories;

	private List<String> cats=new ArrayList<String>();
	
	private String categoryName;

	private List<Post> posts=new ArrayList<Post>();

	private long idPost;
	
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public long getIdPost() {
		return idPost;
	}

	public void setIdPost(long idPost) {
		this.idPost = idPost;
	}

	public List<String> getCats() {
		return cats;
	}

	public void setCats(List<String> cats) {
		this.cats = cats;
	}

	@Override
	public Post getModel() {
		return post;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

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

	public String newPost() {
		setCategories(categoryService.findAll());
		for(Category cat:getCategories())
			cats.add(cat.getName());
        return SUCCESS;
	}
	
	public String save() {
//		Category cat=categoryService.findByName(categoryName);
//		post.setCategory(cat);
//		post.setUser(userService.findByUsername(userName));
		postService.save(post);
        return SUCCESS;
	}
	
	public String posts() {
		setPosts(postService.findAll());
        return SUCCESS;
	}
	
	public String deletePost() {
		postService.delete(idPost);
		return SUCCESS;
	}
	
	public String verPost() {
		post=postService.findOne(idPost);
		return SUCCESS;
	}

	
	
//	public void validate(){
//	if(post.getTitle()!=null){
//		System.out.println(post.getCategory());
//		if (post.getDescription().equals(""))
//			addFieldError("description", "Se requiere una descripción del post");
////		if (post.getCategory()==null)
////			addFieldError("category", "Se requiere una categoria");
//		if (post.getContent().equals(""))
//			addFieldError("content","Se requiere un contenido");
//		if (post.getTitle().equals(""))
//			addFieldError("title", "Se requiere un título");
//	}
//	}
}
