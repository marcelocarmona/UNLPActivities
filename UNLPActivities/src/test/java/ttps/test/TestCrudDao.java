package ttps.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ttps.model.*;
import ttps.access.api.*;
import ttps.access.impl.hiberjpa.*;

public class TestCrudDao {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDAO objetoDAO = context.getBean("userDao", UserDAOhiberjpa.class);User objeto;
		//PostDAO objetoDAO = context.getBean("postDao", PostDAOhiberjpa.class);Post objeto;
		//EventDAO objetoDAO = context.getBean("eventDao", EventDAOhiberjpa.class);Event objeto;
		//TagDAO objetoDAO = context.getBean("tagDao", TagDAOhiberjpa.class);Tag objeto;
		//CommentDAO objetoDAO = context.getBean("commentDao", CommentDAOhiberjpa.class);Comment objeto;
		//CategoryDAO objetoDAO = context.getBean("categoryDao", CategoryDAOhiberjpa.class);Category objeto;
		//StudentDAO objetoDAO = context.getBean("studentDao", StudentDAOhiberjpa.class);Student objeto;
		//AdministratorDAO objetoDAO = context.getBean("adminDao", AdministratorDAOhiberjpa.class);Administrator objeto;
		//ModeratorDAO objetoDAO = context.getBean("moderatorDao", ModeratorDAOhiberjpa.class);Moderator objeto;
		//GuestDAO objetoDAO = context.getBean("guestDao", GuestDAOhiberjpa.class);Guest objeto;
		
		long id=1; //reemplazar por id que este persistido para modificar y/o eliminar
		
		System.out.println("-----------------Listar------------------");
		for(Object obj: objetoDAO.list())
			System.out.println(obj);
		
		System.out.println("-----------------Encontrar------------------");
		objeto = objetoDAO.find(id);
		System.out.println(objeto);
		
		System.out.println("-----------------Modificar------------------");
		//modificar el objeto. En este caso un evento entiende setTitle
		//objeto.setName("name");
		//objetoDAO.merge(objeto);
		System.out.println(objeto);
		
//		System.out.println("-----------------Eliminar------------------");
//		objetoDAO.remove(id);
		
	}
}
