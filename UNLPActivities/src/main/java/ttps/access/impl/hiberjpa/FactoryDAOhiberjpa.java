package ttps.access.impl.hiberjpa;

import ttps.access.*;
import ttps.access.api.AdministratorDAO;
import ttps.access.api.CategoryDAO;
import ttps.access.api.CommentDAO;
import ttps.access.api.EventDAO;
import ttps.access.api.GuestDAO;
import ttps.access.api.ModeratorDAO;
import ttps.access.api.PostDAO;
import ttps.access.api.StudentDAO;
import ttps.access.api.TagDAO;
import ttps.access.api.UserDAO;

public class FactoryDAOhiberjpa  {

	public static UserDAO getUserDAO() {
		return new UserDAOhiberjpa();
	}

	public static TagDAO getTagDAO() {
		return new TagDAOhiberjpa();
	}

	public static CommentDAO getCommentDAO() {
		return new CommentDAOhiberjpa();
	}

	public static PostDAO getPostDAO() {
		return new PostDAOhiberjpa();
	}

	public static EventDAO getEventDAO() {
		return new EventDAOhiberjpa();
	}

	public static CategoryDAO getCategoryDAO() {
		return new CategoryDAOhiberjpa();
	}
	
	public static StudentDAO getStudentDAO() {
		return new StudentDAOhiberjpa();
	}
	public static AdministratorDAO getAdministratorDAO() {
		return new AdministratorDAOhiberjpa();
	}
	public static ModeratorDAO getModeratorDAO() {
		return new ModeratorDAOhiberjpa();
	}
	public static GuestDAO getGuestDAO() {
		return new GuestDAOhiberjpa();
	}
}