package entity;
import javax.persistence.*;

@Entity
public class Notes {
	@Id
	@GeneratedValue
	private etudiant etd;
	private Matiere matiere;
	private Double note;
	public Notes() {
	}
	
	public Notes(etudiant etd, Matiere matiere, Double note) {
		this.etd = etd;
		this.matiere = matiere;
		this.note = note;
	}
	
	
	public etudiant getEtd() {
		return etd;
	}

	public void setEtd(etudiant etd) {
		this.etd = etd;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Double getNote() {
		return note;
	}
	public void setNote(Double note) {
		this.note = note;
	}
	
	

}
