package ttps.access.impl.hiberjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import ttps.access.api.GenericDAO;

@Transactional
public abstract class GenericDAOhiberjpa<T> implements GenericDAO<T>{
	
	private EntityManager entityManager;
		
	protected Class<T> type;
	
	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

	public GenericDAOhiberjpa(Class<T> t) {
	        type = t;
	}

	public List<T> list() {
		//TypedQuery<T> q = EMF.getEMF().createEntityManager().createQuery("from "+getType().getSimpleName(), getType());
		TypedQuery<T> q = this.getEntityManager().createQuery("from "+getType().getSimpleName(), getType());
		List<T> result = q.getResultList();
		return result;
	}


	public void persist(T entity) {
//		EntityManager em= EMF.getEMF().createEntityManager();
//		EntityTransaction tx=null;
//		try{
//			tx=em.getTransaction();
//			tx.begin();
//			em.persist(entity);
//			tx.commit();
//		}
//		catch(RuntimeException e){
//			tx.rollback();
//			System.out.println("Rolled back");
//			e.printStackTrace();
//		}
//		finally{
//			em.close();
//		}
		this.getEntityManager().persist(entity);
	}

//	public void remove(long id) {
//		T entity=EMF.getEMF().createEntityManager().find(this.getType(),id);
//		if(entity !=null) {
//			this.remove(id);
//		}
//	}


	public T find(long id) {
		//return EMF.getEMF().createEntityManager().find(this.getType(),id);
		return this.getEntityManager().find(this.getType(),id);
	}


	public void merge(T entity) {
//		EntityManager em= EMF.getEMF().createEntityManager();
//		EntityTransaction tx=null;
//		try{
//			tx=em.getTransaction();
//			tx.begin();
//			em.merge(entity);
//			tx.commit();
//		}
//		catch(RuntimeException e){
//			tx.rollback();
//			e.printStackTrace();
//		}
//		finally{
//			em.close();
//		}
		this.getEntityManager().merge(entity);
	}



	public void remove(long id) {
//		EntityManager em= EMF.getEMF().createEntityManager();
//		EntityTransaction tx=null;
//		try{
//			tx=em.getTransaction();
//			tx.begin();
//			em.remove(em.getReference(type, id));
//			tx.commit();
//		}
//		catch(RuntimeException e){
//			tx.rollback();
//			e.printStackTrace();
//		}
//		finally{
//			em.close();
//		}
		this.getEntityManager().remove(entityManager.getReference(type, id));
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
