package ttps.action.post;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import ttps.model.Post;
import ttps.service.PostService;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/post")
public class ListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Autowired private PostService postService;
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	private List<Post> posts;

	@Override
	public String execute() throws Exception {
		setPosts(postService.findAll());
		return super.execute();
	}

}
