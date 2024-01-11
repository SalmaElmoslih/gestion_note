package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.administrateur;
import entity.etudiant;
import entity.personne;
import rep.EtudiantRep;
import rep.administrateurRep;
import rep.personneRep;


public class main {

    public static void main(String[] args) {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("NotePu");
        EntityManager em = emf.createEntityManager();

        personneRep persRep = new personneRep();
       EtudiantRep etudiantRep = new EtudiantRep();
       administrateurRep admin = new administrateurRep();
       administrateurRep admin2 = new administrateurRep(etudiantRep);
       

        etudiant etd = new etudiant("salma", "elmeslih", "CD6789", 22,"salma@gmail.com", "123","N34567");
        etudiant etd2 = new etudiant("hajar", "moslih", "CD469", 22,"hajar@gmail.com", "456","N234567");
        administrateur admin1 = new administrateur("Hamza", "Chakir", "CD5678", 40,"Hamza@gmail.com", "432","surveillant general");

        // Sauvegarder dans la base de données

        etudiantRep.save(etd);
        etudiantRep.save(etd2);
        admin.save(admin1);
        
        

        // Trouver une personne par son CIN
        etudiant etdTrouvee = etudiantRep.findById("CD6789");

         //Afficher le nom de la personne trouvée
        if (etdTrouvee != null) {
            System.out.println(etdTrouvee.getNom());
        }
        etudiant etdd = new etudiant("sara", "mosliih", "CD4567", 22,"sara@gmail.com", "567","N34678");
        admin2.ajouterEtudiant(etdd);
        
        // Supprimer une personne par son id
        //etudiantRep.deleteById("CD6789");
        
        //la liste des etudiant
        System.out.println("Liste de tous les etudiants :");
        List<etudiant> etudiants = etudiantRep.findAll();
        etudiants.forEach(System.out::println);
        
    }
}
