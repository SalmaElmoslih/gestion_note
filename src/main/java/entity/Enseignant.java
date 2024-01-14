package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import rep.NoteRep;

@Entity
public class Enseignant extends personne {
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "enseignant")
    private List<Notes> notes = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "enseignant_id")
    private List<Matiere> matieres = new ArrayList<>();
	private String matiere;
    
   

    public Enseignant(String nom, String prenom, String cIN, int age, String email, String password, List<Matiere> matieres) {
        super(nom, prenom, cIN, age, email, password);
        this.matieres = matieres;
      
    }
    
    
// un enseignant peut 1 seul matiere
    public Enseignant(String nom, String prenom, String cIN, int age, String email, String password, String matiere) {
        super(nom, prenom, cIN, age, email, password);    
        Matiere m = new Matiere(null, matiere, null, null);
        this.matieres.add(m);
       
    }
    
   
    /*public String ajouterNote(NoteRep noteRep,etudiant etd, Matiere matiere, double note) {   	
        Notes nouvelleNote = new Notes(etd, matiere, note, this);
        noteRep.save(nouvelleNote);
        return "note ajouter " +getNotes();
    }*/

    public List<Notes> getNotes() {
        return notes;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    @Override
    public void consulterNotes(Matiere matiere, etudiant etudiant) {
if (matiere != null && etudiant == null) {
            
            System.out.println("Notes pour la matière " + matiere.getNomMatiere() + ":");
        } else if (matiere == null && etudiant != null) {

            System.out.println("Notes pour l'étudiant " + etudiant.getNom() + " " + etudiant.getPrenom() + ":");
        } else {
            System.out.println("Veuillez spécifier soit une matière, soit un étudiant.");
        }
    }
}
