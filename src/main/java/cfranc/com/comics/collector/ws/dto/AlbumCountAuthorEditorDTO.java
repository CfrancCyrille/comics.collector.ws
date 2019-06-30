package cfranc.com.comics.collector.ws.dto;

public class AlbumCountAuthorEditorDTO {
	
	String editor;
	String personne;
	int count;
	
	
	public AlbumCountAuthorEditorDTO(String editor, String personne) {
		super();
		this.editor = editor;
		this.personne = personne;
		// this(editor, personne, "", "");
	}

	public AlbumCountAuthorEditorDTO(String editor, String personne, int count) {
		super();
		this.editor = editor;
		this.personne = personne;
		this.count = count;
	}
	
	
}
