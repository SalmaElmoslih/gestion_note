package entity;
import javax.persistance.*;

public class Enseignant extends personne {
    private int idEnseignant;
    private String nom;
    private String prenom;
    private List<Matiere> matieresEnseignees;
    // Autres attributs...

    public Enseignant(int idEnseignant, String nom, String prenom) {
        this.idEnseignant = idEnseignant;
        this.nom = nom;
        this.prenom = prenom;
        this.matieresEnseignees = new ArrayList<>();
    }

    public void ajouterNote(Etudiant etudiant, Matiere matiere, double valeur) {
        Note nouvelleNote = new Note(etudiant, matiere, valeur);
        etudiant.ajouterNote(nouvelleNote);
    }

public void consulterNotes(Matiere matiere, Etudiant etudiant) {
        if (matiere != null && etudiant == null) {
            
            System.out.println("Notes pour la matière " + matiere.getNomMatiere() + ":");
        } else if (matiere == null && etudiant != null) {

            System.out.println("Notes pour l'étudiant " + etudiant.getNom() + " " + etudiant.getPrenom() + ":");
        } else {
            System.out.println("Veuillez spécifier soit une matière, soit un étudiant.");
        }
    }
}

