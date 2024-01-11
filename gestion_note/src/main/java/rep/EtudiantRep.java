package rep;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.etudiant;

public class EtudiantRep extends rep<etudiant,Integer> {
	 
	public EtudiantRep() {
		super(etudiant.class);
		// TODO Auto-generated constructor stub
	}
}
