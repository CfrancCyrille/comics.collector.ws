package cfranc.com.comics.collector.ws.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the albumpersonne database table.
 * 
 */
@Entity
@NamedQuery(name="Albumpersonne.findAll", query="SELECT a FROM Albumpersonne a")
public class Albumpersonne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAlbumPersonne;

	//bi-directional many-to-one association to Album
	@ManyToOne
	@JoinColumn(name="idAlbum")
	private Album album;

	//bi-directional many-to-one association to Metier
	@ManyToOne
	@JoinColumn(name="idMetier")
	private Metier metier;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name="idPersonne")
	private Personne personne;

	public Albumpersonne() {
	}

	public int getIdAlbumPersonne() {
		return this.idAlbumPersonne;
	}

	public void setIdAlbumPersonne(int idAlbumPersonne) {
		this.idAlbumPersonne = idAlbumPersonne;
	}

	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Metier getMetier() {
		return this.metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}