package ttps.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ttps.access.impl.hiberjpa.GuestDAOhiberjpa;
import ttps.access.impl.hiberjpa.ModeratorDAOhiberjpa;
import ttps.access.impl.hiberjpa.StudentDAOhiberjpa;
import ttps.access.impl.hiberjpa.UserDAOhiberjpa;
import ttps.model.*;

public class TestInit {

	public static void main(String[] args) {
		
		Comment c1= new Comment();
		c1.setContent("comentario 1");
		Comment c2= new Comment();
		c2.setContent("comentario 2");
			
		Tag t1= new Tag();
		t1.setName("tagName1");
		Tag t2= new Tag();
		t2.setName("tagName2");
			
		Category cat1=new Category();
		cat1.setName("categoryName1");
			
		Post p1= new Post();
		p1.setPrivacity(false);
		Post p2= new Post();
		p2.setPrivacity(true);
		p1.setCategory(cat1);
		p2.setCategory(cat1);
			
		Event e1=new Event();
		Event e2=new Event();
		e1.setCategory(cat1);
		e2.setCategory(cat1);
		e1.setDate(new Date(System.currentTimeMillis()));
		e2.setDate(new Date(System.currentTimeMillis()));
		e1.setPlace("La Plata");
		e2.setPlace("Bs As");
			
	    List<Comment> comments = new ArrayList<Comment>();
	    comments.add(c1);
	    comments.add(c2);
	    p1.setComments(comments);
			
		List<Tag> tags = new ArrayList<Tag>();
		tags.add(t1);
		tags.add(t2);
		p1.setTags(tags);
		p2.setTags(tags);      
			
		Administrator ad=new Administrator();
		User u=new User();
		u.setName("admin");
		u.setLastName("lastName");
		u.setPassword("password");
		u.setProfile(ad);
			
		/*List<AbstractPublic> publics = new ArrayList<AbstractPublic>();
		publics.add(p1);
		publics.add(p2);
		publics.add(e1);
		publics.add(e2);
		u.setPublics(publics);*/
		
		List<Post> posts = new ArrayList<Post>();
		posts.add(p1);
		posts.add(p2);
		u.setPosts(posts);
		
		List<Event> events = new ArrayList<Event>();
		events.add(e1);
		events.add(e2);
		u.setEvents(events);
			
		c1.setPost(p1);
		c2.setPost(p1);
		
		p1.setUser(u);
		p2.setUser(u);
		e1.setUser(u);
		e2.setUser(u);
		
		Student stu= new Student();
		Moderator m= new Moderator();
		Guest g= new Guest();
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDAOhiberjpa user = context.getBean("userDao", UserDAOhiberjpa.class);
		StudentDAOhiberjpa s = context.getBean("studentDao", StudentDAOhiberjpa.class);
		ModeratorDAOhiberjpa moderator = context.getBean("moderatorDao", ModeratorDAOhiberjpa.class);
		GuestDAOhiberjpa guest = context.getBean("guestDao", GuestDAOhiberjpa.class);		
		
		user.persist(u);
		s.persist(stu);	
		moderator.persist(m);	
		guest.persist(g);
		
		context.close();
	}
}
