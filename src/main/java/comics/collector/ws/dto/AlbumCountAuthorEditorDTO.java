package comics.collector.ws.dto;

import comics.collector.ws.domain.Editeur;
import comics.collector.ws.domain.Personne;

public class AlbumCountAuthorEditorDTO {
	private Editeur editeur;
	private Personne personne;
	private long countAE;

	public AlbumCountAuthorEditorDTO(long countAE) {
		super();
		this.countAE = countAE;
	}

	public AlbumCountAuthorEditorDTO(long countAE, Editeur editeur, Personne personne) {
		super();
		this.editeur = editeur;
		this.personne = personne;
		this.countAE = countAE;
	}
}
