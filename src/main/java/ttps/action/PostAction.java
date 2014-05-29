package ttps.action;


import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.PrincipalAware;
import org.apache.struts2.interceptor.PrincipalProxy;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;

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
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;



@Namespace("/post")
public class PostAction extends ActionSupport implements Preparable,SessionAware,PrincipalAware {

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
	private User sessionUser;

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

	@VisitorFieldValidator(message="")
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

	@RequiredStringValidator(message = "se requiere almenos un tag")
	public void setTagStrings(String tagStrings) {
		this.tagStrings = tagStrings;
	}

	//Actions	

	@Action("list")
	@SkipValidation
	public String list() {
		setPosts(postService.findAll());
        return SUCCESS;
	}
	
	@Action("view")
	@SkipValidation
	public String view() {
		post = postService.findOne(idPost);
		return SUCCESS;
	}
	
	@Action("edit")
	@SkipValidation
	public String edit() {
		post = postService.findOne(idPost);
		categories = categoryService.findAll();	
		tagStrings = tagsToString();
        return SUCCESS;
	}
	
	@Action("create")
	@SkipValidation
	public String create() {
		return SUCCESS;
	}
	
	@Action(value = "create-processing", results = {
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = "input", location = "create.jsp")})
	public String createProcessing(){
		 //le agrego al post usuario de session
		post.setUser(sessionUser);
		
		//parcing tagStrings and creates tags
		String[] tagNames = tagStrings.split(",");
		
		//custom save
		postService.savePostWithTags(post,tagNames);
		return SUCCESS;
	}
	
	
	
	@Action(value = "save", results = { 
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = "input", location = "edit.jsp")})
	public String save() {System.out.println("entreo");
		
		//parcing tagStrings and creates tags
		String[] tagNames = tagStrings.split(",");
		
		//custom save
		postService.savePostWithTags(post,tagNames);

        return SUCCESS;
	}
	

	@Action(value = "delete", results = { @Result(name = SUCCESS, location = "list", type = "redirect") })
	@SkipValidation
	public String deletePost() {
		System.out.println("delete"+"delete     "+idPost);
		postService.delete(idPost);
		return SUCCESS;
	}


	@Action(value = "saveComment", results = { 
			@Result(name = SUCCESS, location = "list", type = "redirect"),//view?idPost=229377
			@Result(name = "input", location = "edit.jsp")})
	public String saveComment() {
		comment.setUser(((User) ((SecurityContext) ActionContext.getContext().getSession().get("SPRING_SECURITY_CONTEXT")).getAuthentication().getPrincipal()));
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

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	@Override
	public void prepare() throws Exception {
		categories = categoryService.findAll();
		if(ActionContext.getContext().getSession().get("SPRING_SECURITY_CONTEXT") != null)
		sessionUser = ((User) ((SecurityContext) ActionContext.getContext().getSession().get("SPRING_SECURITY_CONTEXT")).getAuthentication().getPrincipal());
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		
//		sessionUser = ((User) ((SecurityContext) session.get("SPRING_SECURITY_CONTEXT")).getAuthentication().getPrincipal());
		
	}

	@Override
	public void setPrincipalProxy(PrincipalProxy principalProxy) {
		User user = (User) principalProxy.getUserPrincipal();
		System.out.println("--------->"+principalProxy.getUserPrincipal());
		
	}
	
	
}
