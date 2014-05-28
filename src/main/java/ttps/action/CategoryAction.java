package ttps.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import ttps.model.Category;
import ttps.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/category")
public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private long idCategory;

	@Autowired
	private CategoryService categoryService;
	
	private Category category;

	private List<Category> categories;

	
	//Getters and setters
	
	public long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
	//Actions
	
	@Action("list")
	public String list() {
		setCategories(categoryService.findAll());
        return SUCCESS;
	}

	@Action(value = "create", results = { 
			@Result(name = SUCCESS, location = "list", type = "redirect")})
	public String newCategory() {
		category = categoryService.findOne(idCategory);
		setCategories(categoryService.findAll());
        return SUCCESS;
	}
	
	@Action(value = "save", results = { 
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = "input", location = "edit.jsp")})
	public String saveCategory() {
		categoryService.save(category);
        return SUCCESS;
	}
	

	@Action(value = "delete", results = { @Result(name = SUCCESS, location = "list", type = "redirect") })
	public String deleteCategory() {System.out.println("--- entrando action");
		categoryService.delete(idCategory);
		return SUCCESS;
	}
}
