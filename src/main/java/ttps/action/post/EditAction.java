package ttps.action.post;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import ttps.model.Category;
import ttps.model.Post;
import ttps.model.Tag;
import ttps.service.CategoryService;
import ttps.service.PostService;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/post")
public class EditAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired private PostService postService;
	@Autowired private CategoryService categoryService;
	private List<Category> categories;
	private long idPost;
	private Post post;
	private String tagStrings;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
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

	public String getTagStrings() {
		return tagStrings;
	}

	public void setTagStrings(String tagStrings) {
		this.tagStrings = tagStrings;
	}

	@Override
	public String execute() throws Exception {
		post = postService.findOne(idPost);
		categories = categoryService.findAll();
		tagStrings = tagsToString();
		return SUCCESS;
	}

	// parcing tags to a string
	private String tagsToString() {
		String stringTag = "";
		for (Tag tag : post.getTags()) {
			stringTag = stringTag.concat(tag.getName()).concat(",");
		}
		return stringTag;
	}

}
