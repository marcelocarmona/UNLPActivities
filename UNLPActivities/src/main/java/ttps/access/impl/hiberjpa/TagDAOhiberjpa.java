package ttps.access.impl.hiberjpa;

import java.util.LinkedList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ttps.model.Post;
import ttps.model.Tag;
import ttps.access.api.TagDAO;

public class TagDAOhiberjpa extends GenericDAOhiberjpa<Tag> implements TagDAO {

	public TagDAOhiberjpa(){
		super(Tag.class);
	}
	@Override
	public void remove(long id) {
//		EntityManager em= EMF.getEMF().createEntityManager();
//		EntityTransaction tx=null;
//		try{
//			tx=em.getTransaction();
//			tx.begin();
//			Tag t= em.getReference(Tag.class, id);
//			
//		//	em.remove(t);
//			for (Post p : t.getPosts()) {
//			     p.getTags().remove(t);
//			}
//					
//			
////			t.setPosts(new LinkedList<Post>());
//			//t.getPosts().clear();
//			em.merge(t);
//			em.remove(t);
//			tx.commit();
//		}
//		catch(RuntimeException e){
//			tx.rollback();
//			e.printStackTrace();
//		}
//		finally{
//			em.close();
//		}
		Tag t=getEntityManager().getReference(Tag.class, id);
		for (Post p : t.getPosts()) {
		     p.getTags().remove(t);
		}
		getEntityManager().merge(t);
		getEntityManager().remove(t);
	}	
}
