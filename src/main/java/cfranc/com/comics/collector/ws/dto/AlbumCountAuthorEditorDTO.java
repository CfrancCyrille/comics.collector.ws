package cfranc.com.comics.collector.ws.dto;

import cfranc.com.comics.collector.ws.model.Editeur;
import cfranc.com.comics.collector.ws.model.Personne;

public class AlbumCountAuthorEditorDTO {
	long nb;
	Editeur editeur;
	Personne personne;
	public AlbumCountAuthorEditorDTO(long nb, Editeur editeur, Personne personne) {
		super();
		this.nb = nb;
		this.editeur = editeur;
		this.personne = personne;
	}
	
	
}
