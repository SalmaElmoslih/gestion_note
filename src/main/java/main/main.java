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
    	
    	
       
        personneRep persRep = new personneRep();
        EtudiantRep etudiantRep = new EtudiantRep();
        administrateurRep admin = new administrateurRep();
       	administrateurRep admin2 = new administrateurRep(etudiantRep);
       	MatiereRep matierRep= new MatiereRep();
       	NoteRep noteRep =new NoteRep();
       	EnseignantRep enseignantRep= new EnseignantRep();
       	EnseignantRep enseignantRep2= new EnseignantRep(noteRep);
       	
       	
        etudiant etd = new etudiant("salma", "elmeslih", "CD6789", 22,"salma@gmail.com", "123","N34567");
        etudiant etd2 = new etudiant("hajar", "moslih", "CD469", 22,"hajar@gmail.com", "456","N234567");
        etudiant etd3 = new etudiant("Youness", "Meriaf", "CD63333", 21,"youness@gmail.com", "222","N1323234");
        administrateur admin1 = new administrateur("Hamza", "Chakir", "CD5678", 40,"Hamza@gmail.com", "432","surveillant general");
        
        Matiere m1= new Matiere(null,"Dba","24/08/2019","20/08/2021");
        Matiere m2 = new Matiere(null,"NoSql","24/08/2019","20/08/2021");
        Matiere m3 = new Matiere(null,"python","24/08/2019","20/08/2021");
        Matiere m4 = new Matiere(null,"mobile","24/08/2019","20/08/2021");
        
        List<Matiere> matieres = new ArrayList<>();
        matieres.add(new Matiere(null,"Dba","24/08/2019","20/08/2021"));
        matieres.add(new Matiere(null,"NoSql","24/08/2019","20/08/2021"));
        matieres.add(new Matiere(null,"python","24/08/2019","20/08/2021"));
        
        Enseignant enseignant = new Enseignant("Filali", "Hajar", "CD566", 25, "hajar@example.com", "676", matieres);
        
        Enseignant esgnt2 = new Enseignant("riffi", "mohamed", "CD456", 25, "riffi@example.com", "4567", "mobile");
        
        
        
        
        //Notes note = new Notes(17.0, m1, etd3, enseignant);
        //Notes note2 = new Notes(17.0, m1, etd3, enseignant);

        // Sauvegarder dans la base de données
        etudiantRep.save(etd);
        etudiantRep.save(etd3);
        admin.save(admin1);
        matierRep.save(m1);
        enseignantRep.save(enseignant);
        
        
        
      
        


        // Trouver une personne par son CIN
        etudiant etdTrouvee = etudiantRep.findById("CD6789");

         //Afficher le nom de la personne trouvée
        if (etdTrouvee != null) {
            System.out.println(etdTrouvee.getNom());
        }
        
        //test pour admin
        etudiant etdd = new etudiant("sara", "mosliih", "CD4567", 22,"sara@gmail.com", "567","N34678");
        admin2.ajouterEtudiant(etdd);
        
        
        
        // test pour enseignant
        enseignantRep2.ajouterNote(etdd, m4, 20);
               
 
        System.out.println("Liste de tous les notes :");
        List<Notes> notes = noteRep.findAll();
        notes.forEach(System.out::println);
        
        /*System.out.println("Liste des matières et notes pour un seul enseignant :");
        List<Notes> notesEnseignant = enseignantRep.getNotes(enseignant);
        for (Notes note : notesEnseignant) {
            System.out.println("Étudiant: " + note.getEtudiant().getNom() +
                               ", Matière: " + note.getMatiere().getNom() +
                               ", Note: " + note.getNote());
        }*/

        //test pour etudiant
        // Supprimer une personne par son id
        //etudiantRep.deleteById("CD6789");
        
        //la liste des etudiant
        System.out.println("Liste de tous les etudiants :");
        List<etudiant> etudiants = etudiantRep.findAll();
        etudiants.forEach(System.out::println);
        
    }
}
