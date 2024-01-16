package entity;
import java.util.*;
import javax.persistence.*;

@Entity
public class Modules {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	public Modules() {
	}
	public Modules(Long id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
