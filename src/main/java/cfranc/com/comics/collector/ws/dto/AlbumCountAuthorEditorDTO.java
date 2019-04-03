package cfranc.com.comics.collector.ws.dto;

import cfranc.com.comics.collector.ws.model.Editeur;
import cfranc.com.comics.collector.ws.model.Personne;

public class AlbumCountAuthorEditorDTO {

	long coun;
	Editeur editeurName;
	Personne personne;
	
	public AlbumCountAuthorEditorDTO(long coun, Editeur editeurName, Personne personne) {
		super();
		this.coun = coun;
		this.editeurName = editeurName;
		this.personne = personne;
	}
	
	
}
