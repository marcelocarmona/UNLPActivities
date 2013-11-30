package ttps.access.impl.hiberjpa;

import ttps.model.Category;
import ttps.access.api.CategoryDAO;

public class CategoryDAOhiberjpa extends GenericDAOhiberjpa<Category> implements CategoryDAO {

	public CategoryDAOhiberjpa() {
		super(Category.class);
		//this.type=Category.class;
	}
}
