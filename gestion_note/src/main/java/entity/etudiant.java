package entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class etudiant extends personne {
	 @Column
    private String CNE;
    
    
    public etudiant(String nom, String prenom, String cIN, int age, String email, String password,String CNE) {
		super(nom, prenom, cIN, age, email, password);
		// TODO Auto-generated constructor stub
		this.CNE=CNE;
	}

	


	@Override
	public void consulterNotes(String matiere) {
		// TODO Auto-generated method stub
		
	}

    // getters and setters
	
	 @Override
	    public String toString() {
	        return "Etudiant { " +
	               "CNE='" + CNE + '\'' +
	               ", nom='" + nom + '\'' +
	               ", prenom='" + prenom + '\'' +
	               ", CIN='" + CIN + '\'' +
	               ", age=" + age +
	               ", email='" + email + '\'' +
	               ", password='" + password + '\'' +
	               " }";
	    }
}
