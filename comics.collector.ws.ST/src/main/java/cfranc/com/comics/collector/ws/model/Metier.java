package cfranc.com.comics.collector.ws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the metier database table.
 * 
 */
@Entity
@NamedQuery(name="Metier.findAll", query="SELECT m FROM Metier m")
public class Metier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMetier;

	private String libelleMetier;

	//bi-directional many-to-one association to Albumpersonne
	@OneToMany(mappedBy="metier")
	private List<Albumpersonne> albumpersonnes;

	public Metier() {
	}

	public int getIdMetier() {
		return this.idMetier;
	}

	public void setIdMetier(int idMetier) {
		this.idMetier = idMetier;
	}

	public String getLibelleMetier() {
		return this.libelleMetier;
	}

	public void setLibelleMetier(String libelleMetier) {
		this.libelleMetier = libelleMetier;
	}

	public List<Albumpersonne> getAlbumpersonnes() {
		return this.albumpersonnes;
	}

	public void setAlbumpersonnes(List<Albumpersonne> albumpersonnes) {
		this.albumpersonnes = albumpersonnes;
	}

	public Albumpersonne addAlbumpersonne(Albumpersonne albumpersonne) {
		getAlbumpersonnes().add(albumpersonne);
		albumpersonne.setMetier(this);

		return albumpersonne;
	}

	public Albumpersonne removeAlbumpersonne(Albumpersonne albumpersonne) {
		getAlbumpersonnes().remove(albumpersonne);
		albumpersonne.setMetier(null);

		return albumpersonne;
	}

}