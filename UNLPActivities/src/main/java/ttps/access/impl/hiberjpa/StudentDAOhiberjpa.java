package ttps.access.impl.hiberjpa;

import ttps.model.Student;
import ttps.access.api.StudentDAO;

public class StudentDAOhiberjpa extends GenericDAOhiberjpa<Student> implements
		StudentDAO {

	public StudentDAOhiberjpa() {
		super(Student.class);
		// TODO Auto-generated constructor stub
	}
}
