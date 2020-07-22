package cfranc.com.comics.collector.ws.dto;

import cfranc.com.comics.collector.ws.model.Editeur;
import cfranc.com.comics.collector.ws.model.Personne;

public class AlbumCountAuthorEditorDTO {
	private long count;
	private Editeur editeur;
	private Personne personne;
	
	public AlbumCountAuthorEditorDTO(long count, Editeur editeur, Personne personne) {
		super();
		this.count = count;
		this.editeur = editeur;
		this.personne = personne;
	}
}
