package web.jax.rs.data.jpa.dto;

import web.jax.rs.data.jpa.domain.Editeur;
import web.jax.rs.data.jpa.domain.Personne;

public class AlbumCountAuthorEditorDTO {

    private long nbPersonne;
    private Editeur unEditeur;
    private Personne unePersonne;

    public AlbumCountAuthorEditorDTO(long nbPersonne, Editeur unEditeur, Personne unePersonne) {
        this.nbPersonne = nbPersonne;
        this.unEditeur = unEditeur;
        this.unePersonne = unePersonne;
    }
}
