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
	
	public T findById(U id) {
		return em.find(EntityClass, id);
	}
	
	public List<T> findAll(){
		return em.createQuery("FROM " + EntityClass.getSimpleName(), EntityClass).getResultList();

	}
	
	public void deleteById(U id) {
		T t = em.find(EntityClass, id);
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

}
