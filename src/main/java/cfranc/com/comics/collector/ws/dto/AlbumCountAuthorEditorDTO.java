package cfranc.com.comics.collector.ws.dto;

import cfranc.com.comics.collector.ws.model.Editeur;
import cfranc.com.comics.collector.ws.model.Personne;

public class AlbumCountAuthorEditorDTO {
    private long numberOfAlbums;
    private Editeur editeur;
    private Personne personne;

    public long getNumberOfAlbums() {
        return numberOfAlbums;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public Personne getPersonne() {
        return personne;
    }

    public AlbumCountAuthorEditorDTO(long numberOfAlbums, Editeur editeur, Personne personne) {
        this.numberOfAlbums = numberOfAlbums;
        this.editeur = editeur;
        this.personne = personne;
    }
}
