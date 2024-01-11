package rep;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class rep<T , U> {
	private Class<T> EntityClass;
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public rep(Class<T> entityClass) {
		this.EntityClass = entityClass;
		emf = Persistence.createEntityManagerFactory("NotePu");
		em = emf.createEntityManager();
	}

	 
	public void save (T t) {
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public T findById(U CIN) {
		return em.find(EntityClass, CIN);
	}
	
	public List<T> findAll(){
		return em.createQuery("FROM " + EntityClass.getSimpleName(), EntityClass).getResultList();

	}
	
	public void deleteById(U CIN) {
		T t = em.find(EntityClass, CIN);
		if(t != null) {
			try {
				em.getTransaction().begin();
				em.remove(t);
				em.getTransaction().commit();
			}catch(Exception e) {
				em.getTransaction().rollback();
			}
		}
	}
	
	public void delete(T t) {
		
		if(t != null) {
			try {
				em.getTransaction().begin();
				em.remove(t);
				em.getTransaction().commit();
			}catch(Exception e) {
				em.getTransaction().rollback();
			}
		}
	}
	
	public void modify(T t) {
		
		if(t != null) {
			try {
				em.getTransaction().begin();			
				em.merge(t);
				em.getTransaction().commit();
			}catch(Exception e) {
				em.getTransaction().rollback();
			}
		}
	}

}
