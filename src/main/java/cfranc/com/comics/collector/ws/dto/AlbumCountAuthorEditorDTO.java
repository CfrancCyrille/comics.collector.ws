package cfranc.com.comics.collector.ws.dto;

import cfranc.com.comics.collector.ws.model.Editeur;
import cfranc.com.comics.collector.ws.model.Personne;

public class AlbumCountAuthorEditorDTO {
	
	long number;
	Editeur editorName;
	Personne authorName;
	
	public AlbumCountAuthorEditorDTO(long number, Editeur editorName, Personne authorName) {
		super();
		this.number = number;
		this.editorName = editorName;
		this.authorName = authorName;
	}
	
}
