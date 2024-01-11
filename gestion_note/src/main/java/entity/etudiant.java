package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etudiant")
public class etudiant extends personne {
	@Id
	@Column(name = "CNE", nullable = false, length = 255) 
    private String CNE;

    
    public etudiant(String nom, String prenom, String CIN,int age , String email , String password, String cNE) {
    	super(nom, prenom,CIN,age,email,password);
		CNE = cNE;
		
        
	}


	@Override
    public void consulterNotes(String matiere) {
        System.out.println("L'étudiant consulte les notes pour la matière " + matiere);
    }
    
    

}
