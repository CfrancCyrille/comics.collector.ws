package cfranc.com.comics.collector.ws.dto;

import cfranc.com.comics.collector.ws.model.Personne;
import cfranc.com.comics.collector.ws.model.Editeur;

public class AlbumCountAuthorEditorDTO {
    private long nombreAlbum;
    private Editeur editeur;
    private Personne personne;

    public  AlbumCountAuthorEditorDTO(long nba,Editeur e, Personne p){
        super();
        this.nombreAlbum = nba;
        this.personne = p;
        this.editeur = e;
    }

    public long getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(long nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public Personne getPrsonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}
