package cfranc.com.comics.collector.ws.dto;

import cfranc.com.comics.collector.ws.model.Editeur;
import cfranc.com.comics.collector.ws.model.Personne;

public class AlbumCountAuthorEditorDTO {
	long numberAlbum;
	Editeur editeur;
	Personne personne;
	
	public AlbumCountAuthorEditorDTO(long numberAlbum, Editeur editeur, Personne personne ) {
		super();
		this.editeur = editeur;
		this.personne = personne;
		this.numberAlbum = numberAlbum;
	}
	
}
