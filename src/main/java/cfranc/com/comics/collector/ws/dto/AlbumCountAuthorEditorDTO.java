package cfranc.com.comics.collector.ws.dto;

import cfranc.com.comics.collector.ws.model.Editeur;
import cfranc.com.comics.collector.ws.model.Personne;

public class AlbumCountAuthorEditorDTO {
    Long count;
    Editeur editeur;
    Personne personne;

    public AlbumCountAuthorEditorDTO(Long count, Editeur editeur, Personne personne) {
        this.count = count;
        this.editeur = editeur;
        this.personne = personne;
    }
}
