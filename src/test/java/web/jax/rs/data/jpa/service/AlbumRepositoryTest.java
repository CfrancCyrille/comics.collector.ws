package web.jax.rs.data.jpa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import web.jax.rs.data.jpa.domain.Album;
import web.jax.rs.data.jpa.dto.AlbumCountAuthorEditorDTO;
import web.jax.rs.data.jpa.dto.AlbumShortDTO;

import javax.persistence.Query;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AlbumRepositoryTest {
    @Autowired
    private TestEntityManager em;

    @Test
    public void testFindAllShort(){
        Query q = em.getEntityManager().createQuery("SELECT a FROM Album a");
        List<Album> r = q.getResultList();
        int expected = 207;
        int actual = r.size();
        assertEquals(expected, actual);
    }

    @Test
    public void allAlbumsShort_ALL_207(){
        Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dto.AlbumShortDTO(a.titreAlbum, s.titreSerie) FROM Album a, Serie s WHERE a.serie = s");
        List<AlbumShortDTO> r = q.getResultList();
        int expected = 207;
        int actual = r.size();
        assertEquals(expected, actual);
    }

    @Test
    public void getAlbumsShort_Brigande_1() {
        Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dto.AlbumShortDTO(a.titreAlbum, s.titreSerie) FROM Album a, Serie s WHERE a.serie = s AND a.titreAlbum= :titreAlbum");
        q.setParameter("titreAlbum", "Brigande");
        List<AlbumShortDTO> r = q.getResultList();
        int expected = 1;
        int actual = r.size();
        assertEquals(expected, actual);
    }

    @Test
    public void getCouple_Asterix_UderzoGoscinny(){
        Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dto.AlbumShortDTO(" +
                "(SELECT ap.personne.nomUsuel FROM web.jax.rs.data.jpa.domain.Albumpersonne ap JOIN ap.album a2 " +
                "WHERE a2 = a AND ap.metier.libelleMetier = 'Scenario' AND ap.personne.nomUsuel = :senariste), " +
                "(SELECT ap.personne.nomUsuel FROM web.jax.rs.data.jpa.domain.Albumpersonne ap JOIN ap.album a2 " +
                "WHERE a2 = a AND ap.metier.libelleMetier = 'Dessin' AND ap.personne.nomUsuel = :dessinateur)," +
                " a.titreAlbum, a.serie.titreSerie) " +
                "FROM Album a " +
                "LEFT JOIN a.serie " +
                "WHERE a.serie.titreSerie = :titreSerie");
        q.setParameter("senariste", "Goscinny, René");
        q.setParameter("dessinateur", "Uderzo, Albert");
        q.setParameter("titreSerie", "Astérix");
        List<AlbumShortDTO> r = q.getResultList();
        int expected = 7;
        int actual = r.size();
        assertEquals(expected, actual);
    }

    @Test
    public void nbAlbums_All_39(){

        Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dto.AlbumCountAuthorEditorDTO(count(a), a.editeur, ap.personne) FROM Album a LEFT JOIN a.albumpersonnes ap GROUP BY a.editeur.nomEditeur, ap.personne.nomUsuel ORDER BY count(a)");
        List<AlbumCountAuthorEditorDTO> r = q.getResultList();
        int expected = 39;
        int actual = r.size();
        assertEquals(expected, actual);
    }
}
