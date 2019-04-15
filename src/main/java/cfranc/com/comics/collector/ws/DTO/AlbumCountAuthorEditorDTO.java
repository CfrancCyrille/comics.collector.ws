package cfranc.com.comics.collector.ws.DTO;

public class AlbumCountAuthorEditorDTO {
    long count;
    String editeur;
    String personne;

    public AlbumCountAuthorEditorDTO(long count, String editeur, String personne) {
        this.count = count;
        this.editeur = editeur;
        this.personne = personne;
    }
}

