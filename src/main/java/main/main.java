package main;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.*;
import rep.*;


public class main {

    public static void main(String[] args) {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("NotePu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        personneRep persRep = new personneRep();
        EtudiantRep etudiantRep = new EtudiantRep();
        administrateurRep admin = new administrateurRep();
       	administrateurRep admin2 = new administrateurRep(etudiantRep);
       	MatiereRep matierRep= new MatiereRep();
       	NoteRep noteRep =new NoteRep();
       	EnseignantRep enseignantRep= new EnseignantRep();
        etudiant etd = new etudiant("salma", "elmeslih", "CD6789", 22,"salma@gmail.com", "123","N34567");
        etudiant etd2 = new etudiant("hajar", "moslih", "CD469", 22,"hajar@gmail.com", "456","N234567");
        etudiant etd3 = new etudiant("Youness", "Meriaf", "CD63333", 21,"youness@gmail.com", "222","N1323234");
        administrateur admin1 = new administrateur("Hamza", "Chakir", "CD5678", 40,"Hamza@gmail.com", "432","surveillant general");
        Matiere m1= new Matiere(null,"Dba","24/08/2019","20/08/2021");
        //List<Matiere> matieres= new ArrayList<>();
        //matieres.add(m1);
        //Enseignant es1=new Enseignant("Youness","Meriaf","Cd94949",22,"youness.meriaf@gmail.com","123",matieres);
        List<Matiere> matieres = new ArrayList<>();
        matieres.add(new Matiere(null,"Dba","24/08/2019","20/08/2021"));
        matieres.add(new Matiere(null,"NoSql","24/08/2019","20/08/2021"));
        Enseignant enseignant = new Enseignant("test", "test", "CIN", 25, "email@example.com", "password", matieres);
        Notes note = new Notes(17.0, m1, etd3, enseignant);
        Notes note2 = new Notes(17.0, m1, etd3, enseignant);

        // Sauvegarder dans la base de données
        	
        etudiantRep.save(etd);
        etudiantRep.save(etd3);
        admin.save(admin1);
        matierRep.save(m1);
        enseignantRep.save(enseignant);
        noteRep.save(note);
        


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
