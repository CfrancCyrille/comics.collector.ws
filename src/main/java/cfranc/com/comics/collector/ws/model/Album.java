package cfranc.com.comics.collector.ws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name="Album.findAll", query="SELECT a FROM Album a")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAlbum;

	private String couverture;

	private String cycle;

	@Temporal(TemporalType.TIMESTAMP)
	private Date depotLegal;

	private byte formatAlbum;

	private boolean horsSerie;

	private String idSiteRef;

	private String isbn;

	private String numero;

	private boolean possede;

	private boolean premiereEdition;

	private String titreAlbum;

	//bi-directional many-to-one association to Editeur
	@ManyToOne
	@JoinColumn(name="idEditeur")
	private Editeur editeur;

	//bi-directional many-to-one association to Serie
	@ManyToOne
	@JoinColumn(name="idSerie")
	private Serie serie;

	//bi-directional many-to-one association to Genre
	@ManyToOne
	@JoinColumn(name="idGenre")
	private Genre genre;

	//bi-directional many-to-one association to Albumpersonne
	@OneToMany(mappedBy="album")
	private List<Albumpersonne> albumpersonnes;

	public Album() {
	}

	public int getIdAlbum() {
		return this.idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getCouverture() {
		return this.couverture;
	}

	public void setCouverture(String couverture) {
		this.couverture = couverture;
	}

	public String getCycle() {
		return this.cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public Date getDepotLegal() {
		return this.depotLegal;
	}

	public void setDepotLegal(Date depotLegal) {
		this.depotLegal = depotLegal;
	}

	public byte getFormatAlbum() {
		return this.formatAlbum;
	}

	public void setFormatAlbum(byte formatAlbum) {
		this.formatAlbum = formatAlbum;
	}

	public boolean getHorsSerie() {
		return this.horsSerie;
	}

	public void setHorsSerie(boolean horsSerie) {
		this.horsSerie = horsSerie;
	}

	public String getIdSiteRef() {
		return this.idSiteRef;
	}

	public void setIdSiteRef(String idSiteRef) {
		this.idSiteRef = idSiteRef;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean getPossede() {
		return this.possede;
	}

	public void setPossede(boolean possede) {
		this.possede = possede;
	}

	public boolean getPremiereEdition() {
		return this.premiereEdition;
	}

	public void setPremiereEdition(boolean premiereEdition) {
		this.premiereEdition = premiereEdition;
	}

	public String getTitreAlbum() {
		return this.titreAlbum;
	}

	public void setTitreAlbum(String titreAlbum) {
		this.titreAlbum = titreAlbum;
	}

	public Editeur getEditeur() {
		return this.editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public Serie getSerie() {
		return this.serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Albumpersonne> getAlbumpersonnes() {
		return this.albumpersonnes;
	}

	public void setAlbumpersonnes(List<Albumpersonne> albumpersonnes) {
		this.albumpersonnes = albumpersonnes;
	}

	public Albumpersonne addAlbumpersonne(Albumpersonne albumpersonne) {
		getAlbumpersonnes().add(albumpersonne);
		albumpersonne.setAlbum(this);

		return albumpersonne;
	}

	public Albumpersonne removeAlbumpersonne(Albumpersonne albumpersonne) {
		getAlbumpersonnes().remove(albumpersonne);
		albumpersonne.setAlbum(null);

		return albumpersonne;
	}

}