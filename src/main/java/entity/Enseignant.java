package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Enseignant extends personne {
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "enseignant")
    private List<Notes> notes = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "enseignant_id")
    private List<Matiere> matieres = new ArrayList<>();


	public Enseignant(String nom, String prenom, String cIN, int age, String email, String password, List<Matiere> matieres) {
			super(nom, prenom, cIN, age, email, password);
	        this.matieres = matieres;	
		}
	 
	 
	public List<Notes> getNotes() {
        return notes;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    // Method to add a Note
    public void addNote(Notes note) {
        notes.add(note);
        note.setEnseignant(this);
    }

    // Other methods if needed

    @Override
    public String toString() {
        return "Enseignant{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", CIN='" + CIN + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

	@Override
	public void consulterNotes(Matiere matiere, etudiant etudiant) {
		// TODO Auto-generated method stub
		
	}
}

