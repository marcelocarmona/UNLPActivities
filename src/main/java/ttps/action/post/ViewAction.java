package ttps.action.post;


import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import ttps.model.Post;
import ttps.service.PostService;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/post")
public class ViewAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PostService postService;
	private long idPost;
	private Post post;

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

	@Override
	public String execute() throws Exception {
		post = postService.findOne(idPost);
		return SUCCESS;
	}

}
