package rep;

import entity.administrateur;
import entity.etudiant;

public class administrateurRep extends rep<administrateur,String>{

	private EtudiantRep etudiantRep;
	
		
	public administrateurRep() {
		super(administrateur.class);
		// TODO Auto-generated constructor stub
	}

	public administrateurRep(EtudiantRep etudiantRep) {		
		super(administrateur.class);	
		 this.etudiantRep = etudiantRep;
	}
	
	
	

	    public String ajouterEtudiant(etudiant etudiant) {
	    	etudiantRep.save(etudiant);
	        return "L'administrateur ajoute l'étudiant " + etudiant.getNom();
	    }

	    public String modifierEtudiant(etudiant etudiant) {
	    	etudiantRep.modify(etudiant);
	        return "L'administrateur a modifier l'étudiant " + etudiant.getNom();
	    }
	    
	    public String deleteEtudiant(etudiant etudiant) {
	    	etudiantRep.delete(etudiant);
	        return "L'administrateur a modifier l'étudiant " + etudiant.getNom();
	    }

	   

}
