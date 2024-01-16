package entity;

import javax.persistence.*;

@Entity
public class Matiere {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String date_ratt;
	private String controlle;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enseignant_id")
	private Enseignant enseignant;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "module_id")
	private Modules module;
	
	
	public Matiere() {
	}
	
	public Matiere(Long id, String nom, String date_ratt, String controlle,Enseignant enseignant,Modules module) {
		this.id = id;
		this.nom = nom;
		this.date_ratt = date_ratt;
		this.controlle = controlle;
		this.enseignant=enseignant;
		this.module=module;
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
	public String getDate_ratt() {
		return date_ratt;
	}
	public void setDate_ratt(String date_ratt) {
		this.date_ratt = date_ratt;
	}
	public String getControlle() {
		return controlle;
	}
	public void setControlle(String controlle) {
		this.controlle = controlle;
	}
	@Override
	public String toString() {
		return "Matiere [id=" + id + ", nom=" + nom + ", date_ratt=" + date_ratt + ", controlle=" + controlle + "]";
	}

	public String getNomMatiere() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
