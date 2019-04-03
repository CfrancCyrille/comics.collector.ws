package cfranc.com.comics.collector.ws.dto;

import cfranc.com.comics.collector.ws.model.Editeur;
import cfranc.com.comics.collector.ws.model.Personne;

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
