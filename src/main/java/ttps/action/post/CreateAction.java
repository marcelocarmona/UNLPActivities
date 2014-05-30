package ttps.action.post;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import ttps.model.Category;
import ttps.service.CategoryService;



import com.opensymphony.xwork2.ActionSupport;

@Namespace("/post")
public class CreateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;


	@Autowired private CategoryService categoryService;
	private List<Category> categories;


	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String execute() throws Exception {
		categories = categoryService.findAll();
		return SUCCESS;
	}


}
