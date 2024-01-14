package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Enseignant extends personne {
    private int idEnseignant;
    private String nom;
    private String prenom;
    private List<Matiere> matieresEnseignees;

    public Enseignant(String nom, String prenom, String cIN, int age, String email, String password, int idEnseignant,
			List<Matiere> matieresEnseignees) {
    	
		super(nom, prenom, cIN, age, email, password);
		this.idEnseignant = idEnseignant;
		this.nom = nom;
		this.prenom = prenom;
		this.matieresEnseignees =new ArrayList<>();
	}

    public void ajouterNote(etudiant etd, Matiere matiere, double note) {
        Notes nouvelleNote = new Notes(etd, matiere, note);
        
    }

    public void consulterNotes(Matiere matiere, etudiant etudiant) {
        if (matiere != null && etudiant == null) {
            
            System.out.println("Notes pour la matière " + matiere.getNomMatiere() + ":");
        } else if (matiere == null && etudiant != null) {

            System.out.println("Notes pour l'étudiant " + etudiant.getNom() + " " + etudiant.getPrenom() + ":");
        } else {
            System.out.println("Veuillez spécifier soit une matière, soit un étudiant.");
        }
    }

    @Override
    public void consulterNotes(String matiere) {
        // TODO Auto-generated method stub
    }
}
