package entity;
import java.util.*;
import javax.persistence.*;
@Entity
public class Modules {
	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	private List<Notes> notes=new ArrayList<>();
	public Modules() {
	}
	public Modules(Integer id, String nom, List<Notes> notes) {
		this.id = id;
		this.nom = nom;
		this.notes = notes;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Notes> getNotes() {
		return notes;
	}
	public void setNotes(List<Notes> notes) {
		this.notes = notes;
	}
	public double calculateAverageNote() {
        if (notes == null || notes.isEmpty()) {
            return 0.0;
        }

        double sum = notes.stream()
                .mapToDouble(Notes::getNote)
                .sum();

        return sum / notes.size();
    }
	@Override
	public String toString() {
		return "Modules [calculateAverageNote()=" + calculateAverageNote() + "]";
	}
}
