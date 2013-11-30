package ttps.access.impl.hiberjpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	
	private EMF(){}
	
	private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("sitioweb");
	
	public static EntityManagerFactory getEMF(){
		return em;
	}
}
