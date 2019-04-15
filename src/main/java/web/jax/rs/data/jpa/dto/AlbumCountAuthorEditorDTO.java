package web.jax.rs.data.jpa.dto;

import web.jax.rs.data.jpa.domain.Editeur;
import web.jax.rs.data.jpa.domain.Personne;

public class AlbumCountAuthorEditorDTO {
    long count;
    web.jax.rs.data.jpa.domain.Editeur editeur;
    web.jax.rs.data.jpa.domain.Personne personne;

    public AlbumCountAuthorEditorDTO(long count, Editeur editeur, Personne personne) {
        this.count = count;
        this.editeur = editeur;
        this.personne = personne;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}
