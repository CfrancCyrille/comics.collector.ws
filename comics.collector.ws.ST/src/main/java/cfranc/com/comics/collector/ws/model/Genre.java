package cfranc.com.comics.collector.ws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the genre database table.
 * 
 */
@Entity
@NamedQuery(name="Genre.findAll", query="SELECT g FROM Genre g")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idGenre;

	private String libelleGenre;

	//bi-directional many-to-one association to Album
	@OneToMany(mappedBy="genre")
	private List<Album> albums;

	//bi-directional many-to-one association to Serie
	@OneToMany(mappedBy="genre")
	private List<Serie> series;

	public Genre() {
	}

	public int getIdGenre() {
		return this.idGenre;
	}

	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}

	public String getLibelleGenre() {
		return this.libelleGenre;
	}

	public void setLibelleGenre(String libelleGenre) {
		this.libelleGenre = libelleGenre;
	}

	public List<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public Album addAlbum(Album album) {
		getAlbums().add(album);
		album.setGenre(this);

		return album;
	}

	public Album removeAlbum(Album album) {
		getAlbums().remove(album);
		album.setGenre(null);

		return album;
	}

	public List<Serie> getSeries() {
		return this.series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public Serie addSery(Serie sery) {
		getSeries().add(sery);
		sery.setGenre(this);

		return sery;
	}

	public Serie removeSery(Serie sery) {
		getSeries().remove(sery);
		sery.setGenre(null);

		return sery;
	}

}