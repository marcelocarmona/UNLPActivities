package ttps.action;


import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import ttps.model.Category;
import ttps.model.Comment;
import ttps.model.Post;
import ttps.model.Tag;
import ttps.model.User;
import ttps.service.CategoryService;
import ttps.service.PostService;
import ttps.service.CommentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



@Namespace("/post")
public class PostAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	@Autowired private PostService postService;
	@Autowired private CategoryService categoryService;
	@Autowired private CommentService commentService;
	private long idPost;
	private Post post;
	private List<Category> categories;
	private List<Post> posts;
	private String tagStrings;
	private Comment comment;

	//Getter and setters

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
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
	
	public String getTagStrings() {
		return tagStrings;
	}

	public void setTagStrings(String tagStrings) {
		this.tagStrings = tagStrings;
	}

	//Actions	

	@Action("list")
	public String list() {
		setPosts(postService.findAll());
        return SUCCESS;
	}
	
	@Action("view")
	public String view() {
		post = postService.findOne(idPost);
		return SUCCESS;
	}
	
	@Action("edit")
	public String edit() {
		categories = categoryService.findAll();
		post = postService.findOne(idPost);
		//tagStrings = tagsToString();
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
		
		//parcing tagStrings and creates tags
		String[] tagNames = tagStrings.split(",");
		
		//custom save
		postService.savePostWithTags(post,tagNames);

        return SUCCESS;
	}
	

	@Action(value = "delete", results = { @Result(name = SUCCESS, location = "list", type = "redirect") })
	public String deletePost() {
		System.out.println("delete"+"delete     "+idPost);
		postService.delete(idPost);
		return SUCCESS;
	}


	@Action(value = "saveComment", results = { 
			@Result(name = SUCCESS, location = "list", type = "redirect"),//view?idPost=229377
			@Result(name = "input", location = "edit.jsp")})
	public String saveComment() {
		comment.setUser(((User) ((org.springframework.security.core.context.SecurityContext) ActionContext.getContext().getSession().get("SPRING_SECURITY_CONTEXT")).getAuthentication().getPrincipal()));
		commentService.save(comment);
        return SUCCESS;
	}
	
	//parcing tags to a string
	private String tagsToString(){
		String stringTag="";
		for (Tag tag : post.getTags()) {
		 stringTag = stringTag.concat(tag.getName()).concat(",");
		}
		return stringTag;
	}
	
	
}
