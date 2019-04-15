package cfranc.com.comics.collector.ws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the personne database table.
 * 
 */
@Entity
@NamedQuery(name="Personne.findAll", query="SELECT p FROM Personne p")
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPersonne;

	private String prenom;

	private String nom;

	private String nomUsuel;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDeces;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateNaissance;

	//bi-directional many-to-one association to Albumpersonne
	@OneToMany(mappedBy="personne")
	private List<Albumpersonne> albumpersonnes;

	public Personne() {
	}

	public int getIdPersonne() {
		return this.idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomUsuel() {
		return this.nomUsuel;
	}

	public void setNomUsuel(String nomUsuel) {
		this.nomUsuel = nomUsuel;
	}

	public Date getDateDeces() {
		return this.dateDeces;
	}

	public void setDateDeces(Date dateDeces) {
		this.dateDeces = dateDeces;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<Albumpersonne> getAlbumpersonnes() {
		return this.albumpersonnes;
	}

	public void setAlbumpersonnes(List<Albumpersonne> albumpersonnes) {
		this.albumpersonnes = albumpersonnes;
	}

	public Albumpersonne addAlbumpersonne(Albumpersonne albumpersonne) {
		getAlbumpersonnes().add(albumpersonne);
		albumpersonne.setPersonne(this);

		return albumpersonne;
	}

	public Albumpersonne removeAlbumpersonne(Albumpersonne albumpersonne) {
		getAlbumpersonnes().remove(albumpersonne);
		albumpersonne.setPersonne(null);

		return albumpersonne;
	}

}