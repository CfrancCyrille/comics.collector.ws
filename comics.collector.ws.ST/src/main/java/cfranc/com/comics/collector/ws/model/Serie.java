package cfranc.com.comics.collector.ws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the serie database table.
 * 
 */
@Entity
@NamedQuery(name="Serie.findAll", query="SELECT s FROM Serie s")
public class Serie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSerie;

	private int nombreAlbums;

	private boolean termine;

	private String titreSerie;

	//bi-directional many-to-one association to Album
	@OneToMany(mappedBy="serie")
	private List<Album> albums;

	//bi-directional many-to-one association to Genre
	@ManyToOne
	@JoinColumn(name="idGenre")
	private Genre genre;

	public Serie() {
	}

	public int getIdSerie() {
		return this.idSerie;
	}

	public void setIdSerie(int idSerie) {
		this.idSerie = idSerie;
	}

	public int getNombreAlbums() {
		return this.nombreAlbums;
	}

	public void setNombreAlbums(int nombreAlbums) {
		this.nombreAlbums = nombreAlbums;
	}

	public boolean getTermine() {
		return this.termine;
	}

	public void setTermine(boolean termine) {
		this.termine = termine;
	}

	public String getTitreSerie() {
		return this.titreSerie;
	}

	public void setTitreSerie(String titreSerie) {
		this.titreSerie = titreSerie;
	}

	public List<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public Album addAlbum(Album album) {
		getAlbums().add(album);
		album.setSerie(this);

		return album;
	}

	public Album removeAlbum(Album album) {
		getAlbums().remove(album);
		album.setSerie(null);

		return album;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}