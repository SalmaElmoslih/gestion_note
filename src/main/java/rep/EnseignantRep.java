package rep;

import entity.Enseignant;
import entity.Matiere;
import entity.Notes;
import entity.etudiant;

public class EnseignantRep extends rep<Enseignant,String> {
	
	private NoteRep noteRep;
	
	public EnseignantRep() {
		super(Enseignant.class);		
	}
	
	public EnseignantRep(NoteRep noteRep) {
		super(Enseignant.class);
		this.noteRep=noteRep;
		
	}
	
	
	public String ajouterNote(Notes nouvelleNote) {
	       // Notes nouvelleNote = new Notes(etd, matiere, note);
	        noteRep.save(nouvelleNote);
	        return "note ajouter " ;	   
	}



	 /*public List<Notes> getNotes(Enseignant enseignant) {
		    return em.createQuery("SELECT n FROM Notes n WHERE n.enseignant = :enseignant", Notes.class)
		             .setParameter("enseignant", enseignant)
		             .getResultList();
		}*/

}
