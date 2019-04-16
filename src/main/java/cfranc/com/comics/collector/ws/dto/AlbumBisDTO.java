package cfranc.com.comics.collector.ws.dto;

public class AlbumBisDTO {
	long count;
	String editeur;
	String personne;
	

	public AlbumBisDTO(
			long count,
			String editeur,
			String personne) {
		super();
		this.count=count;
		this.editeur=editeur;
		this.personne=personne;

	}
}
