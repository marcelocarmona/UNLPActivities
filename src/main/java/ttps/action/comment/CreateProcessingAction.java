package ttps.action.comment;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;

import ttps.model.Comment;
import ttps.model.User;
import ttps.service.CommentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class CreateProcessingAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private CommentService commentService;
	private Comment comment;
	private User sessionUser;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	@Action(results = {
			@Result(name = SUCCESS, location = "/post/view", type = "redirect", params = { "idPost","${comment.post.id}"}),// view?idPost=229377
			@Result(name = "input", location = "edit.jsp") })
	public String execute() throws Exception {
		 comment.setUser(sessionUser);
		 commentService.save(comment);
		return SUCCESS;
	}

	// metodo necesario para validar
	@Override
	public void prepare() throws Exception {
		if (ActionContext.getContext().getSession()
				.get("SPRING_SECURITY_CONTEXT") != null)
			sessionUser = ((User) ((SecurityContext) ActionContext.getContext()
					.getSession().get("SPRING_SECURITY_CONTEXT"))
					.getAuthentication().getPrincipal());
	}

}
