package entity;
import javax.persistence.*;

@Entity
public class Notes {
	@Id
	@GeneratedValue
	private Integer id;
	private String matiere;
	private Double note;
	public Notes() {
	}
	public Notes(Integer id, String matiere, Double note) {
		this.id = id;
		this.matiere = matiere;
		this.note = note;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public Double getNote() {
		return note;
	}
	public void setNote(Double note) {
		this.note = note;
	}
	
	

}
