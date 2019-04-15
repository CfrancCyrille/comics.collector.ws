package cfranc.com.comics.collector.ws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the editeur database table.
 * 
 */
@Entity
@NamedQuery(name="Editeur.findAll", query="SELECT e FROM Editeur e")
public class Editeur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEditeur;

	private String nomEditeur;

	//bi-directional many-to-one association to Album
	@OneToMany(mappedBy="editeur")
	private List<Album> albums;

	public Editeur() {
	}

	public int getIdEditeur() {
		return this.idEditeur;
	}

	public void setIdEditeur(int idEditeur) {
		this.idEditeur = idEditeur;
	}

	public String getNomEditeur() {
		return this.nomEditeur;
	}

	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
	}

	public List<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public Album addAlbum(Album album) {
		getAlbums().add(album);
		album.setEditeur(this);

		return album;
	}

	public Album removeAlbum(Album album) {
		getAlbums().remove(album);
		album.setEditeur(null);

		return album;
	}

}