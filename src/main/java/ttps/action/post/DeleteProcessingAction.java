package ttps.action.post;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import ttps.service.PostService;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteProcessingAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Autowired
	private PostService postService;
	private long idPost;

	public long getIdPost() {
		return idPost;
	}

	public void setIdPost(long idPost) {
		this.idPost = idPost;
	}


	@Action(results = { @Result(name = SUCCESS, location = "list", type = "redirect") })
	public String execute() throws Exception {
		postService.delete(idPost);
		return SUCCESS;
	}

}
