package bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "styles")
@NamedQueries({
	@NamedQuery(
		name = "deleteStyle",
		query = "DELETE FROM Style WHERE id = :id"
	)
})
public class Style {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	
	/*
	 * Obligatoire pour le bon fonctionnement de Hibernate
	 */
	public Style() {}
	
	/*
	 * Constructeur facultatif : me permettra de creer des Styles en renseignant directement le libelle
	 */
	public Style(String libelle) {
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
