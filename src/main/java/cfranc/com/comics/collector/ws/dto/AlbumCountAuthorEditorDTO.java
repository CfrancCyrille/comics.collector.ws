package cfranc.com.comics.collector.ws.dto;

import cfranc.com.comics.collector.ws.model.Editeur;
import cfranc.com.comics.collector.ws.model.Personne;

public class AlbumCountAuthorEditorDTO {

	long con;
	Editeur editeur;
	Personne personne;
	
	public AlbumCountAuthorEditorDTO(long con, Editeur editeur, Personne personne) {
		super();
		this.con = con;
		this.editeur = editeur;
		this.personne = personne;
	}
	
	
	
}
