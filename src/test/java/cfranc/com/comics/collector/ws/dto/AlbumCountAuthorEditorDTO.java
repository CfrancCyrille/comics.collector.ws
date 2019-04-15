package cfranc.com.comics.collector.ws.dto;

import cfranc.com.comics.collector.ws.model.Editeur;
import cfranc.com.comics.collector.ws.model.Personne;

public class AlbumCountAuthorEditorDTO {

	private Editeur editeur;
	private Personne personne;
	private Long a;
	
	public AlbumCountAuthorEditorDTO(Long a, Editeur editeur, Personne personne) {
		super();
		this.a = a;
		this.editeur = editeur;
		this.personne = personne;
	}
}
