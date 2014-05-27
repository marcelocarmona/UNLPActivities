package ttps.action;


import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import ttps.model.Category;
import ttps.model.Post;
import ttps.model.Tag;
import ttps.model.User;
import ttps.service.CategoryService;
import ttps.service.PostService;



@Namespace("/post")
public class PostAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	@Autowired private PostService postService;
	@Autowired private CategoryService categoryService;
	private long idPost;
	private Post post;
	private List<Category> categories;
	private List<Post> posts;
	private String tagString1;
	private String tagString2;
	private String tagString3;
	private String tagString4;
	

	//Getter and setters

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
	
	public String getTagString1() {
		return tagString1;
	}

	public void setTagString1(String tagString1) {
		this.tagString1 = tagString1;
	}

	public String getTagString2() {
		return tagString2;
	}

	public void setTagString2(String tagString2) {
		this.tagString2 = tagString2;
	}

	public String getTagString3() {
		return tagString3;
	}

	public void setTagString3(String tagString3) {
		this.tagString3 = tagString3;
	}

	public String getTagString4() {
		return tagString4;
	}

	public void setTagString4(String tagString4) {
		this.tagString4 = tagString4;
	}

	//Actions	

	@Action("list")
	public String list() {
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
		//probando con usuario 3 esto se cambia por el usuario de la session
		User u = new User();
		u.setId(3);
		post.setUser(u);
		
//		Tag tag = tagService.findByName("tag1");
//		if(tag == null){
//			tag = new Tag();
//			tag.setName("tag1");
//		}
//		
//		post.getTags().add(tag);
//		tag.getPosts().add(post);
//		postService.save(post);
		
		postService.savePostWithTags(post,tagString1,tagString2,tagString3,tagString4);
        return SUCCESS;
	}
	

	@Action(value = "delete", results = { @Result(name = SUCCESS, location = "list", type = "redirect") })
	public String deletePost() {
		postService.delete(idPost);
		return SUCCESS;
	}
	
	
}
