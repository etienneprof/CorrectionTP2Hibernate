package bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "films")
public class Film {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String titre;
	
	private int annee;
	
	@ManyToOne
	@JoinColumn(name = "id_style")
	private Style style;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Realisateur real;
	
	private int duree;
	
	private boolean vu;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_film")
	private List<Acteur> acteurs;
	
	private String synopsis;
	
	public Film() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Realisateur getReal() {
		return real;
	}

	public void setReal(Realisateur real) {
		this.real = real;
	}

	public int getDuree() {
		return duree;
	}
	
	/*
	public String getDuree() {
		return duree / 60 + ":" + duree % 60;
	}*/

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public boolean isVu() {
		return vu;
	}

	public void setVu(boolean vu) {
		this.vu = vu;
	}

	public List<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
}
