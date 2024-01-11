package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.etudiant;
import entity.personne;
import rep.EtudiantRep;
import rep.personneRep;

public class main {

    public static void main(String[] args) {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("NotePu");
        EntityManager em = emf.createEntityManager();

        
    	
        // Créer une instance de personneRep
        personneRep persRep = new personneRep();
       EtudiantRep etudiantRep = new EtudiantRep();

        // Créer une nouvelle instance de personne
        //personne nouvellePersonne = new personne("salma", "elmeslih", "CD6789", 22,"salma@gmail.com", "123");
        etudiant etd = new etudiant("salma", "elmeslih", "CD6789", 22,"salma@gmail.com", "123", "N2345");

        // Sauvegarder la nouvelle personne dans la base de données
        //persRep.save(nouvellePersonne);
        etudiantRep.save(etd);

        // Trouver une personne par son id
        personne personneTrouvee = persRep.findById(1);

        // Afficher le nom de la personne trouvée
        if (personneTrouvee != null) {
            System.out.println(personneTrouvee.getNom());
        }

        // Supprimer une personne par son id
        //persRep.deleteById(1);
    }
}
