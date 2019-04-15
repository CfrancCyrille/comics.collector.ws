package web.jax.rs.data.jpa.service;


import static org.junit.Assert.assertEquals;
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


@RunWith(SpringRunner.class)
@DataJpaTest

public class AlbumRepositoryTest {
    @Autowired
    private TestEntityManager em;


    @Test
    public void Test_findAllAlbum_207() {
        Query q = em.getEntityManager().createQuery("SELECT a FROM web.jax.rs.data.jpa.domain.Album a");
        List<Album> albumList = q.getResultList();
        int expected = 207;
        int actual = albumList.size();

        assertEquals(expected,actual);
    }


    @Test
    public void allAlbumsShort_ALL_207() {
        Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dto.AlbumShortDTO(a.titreAlbum, s.titreSerie) FROM web.jax.rs.data.jpa.domain.Album a, web.jax.rs.data.jpa.domain.Serie s WHERE a.serie = s");
        List<AlbumShortDTO> albumShortDTOS = q.getResultList();
        int expected = 207;
        int actual = albumShortDTOS.size();

        assertEquals(expected,actual);
    }

    @Test
    public void getAlbumsShort_Brigande_1() {
        Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dto.AlbumShortDTO(a.titreAlbum, s.titreSerie) FROM web.jax.rs.data.jpa.domain.Album a, web.jax.rs.data.jpa.domain.Serie s WHERE a.serie = s AND a.titreAlbum = :titreAlbum");
        q.setParameter("titreAlbum","Brigande");
        List<AlbumShortDTO> albumShortDTOS = q.getResultList();
        int expected = 1;
        int actual = albumShortDTOS.size();

        assertEquals(expected,actual);
    }

    @Test
    public void getCouple_Asterix_15(){
        Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dto.AlbumShortDTO(\n" +
                "(SELECT ap.personne.nomUsuel FROM web.jax.rs.data.jpa.domain.Albumpersonne ap JOIN ap.album a2\n" +
                "WHERE a2 = a AND ap.metier.libelleMetier = 'Scenario' AND ap.personne.nomUsuel = :scenariste),\n" +
                "(SELECT ap.personne.nomUsuel FROM web.jax.rs.data.jpa.domain.Albumpersonne ap JOIN ap.album a2\n" +
                "WHERE a2 = a AND ap.metier.libelleMetier = 'Dessin' AND ap.personne.nomUsuel = :dessinateur),\n" +
                "a.titreAlbum, s.titreSerie)\n" +
                "FROM web.jax.rs.data.jpa.domain.Album a\n" +
                "LEFT JOIN a.serie s\n" +
                "WHERE s.titreSerie = :titreSerie");
        q.setParameter("titreSerie","Astérix");
        q.setParameter("dessinateur","Uderzo, Albert");
        q.setParameter("scenariste","Goscinny, René");
        List<AlbumShortDTO> albumShortDTOS = q.getResultList();
        int expected = 15;
        int actual = albumShortDTOS.size();

        assertEquals(expected,actual);
    }

    @Test
    public void getCouple_Asterix_UderzoGoscinny_9(){
        Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dto.AlbumShortDTO(apde.personne.nomUsuel, apsc.personne.nomUsuel, a.titreAlbum, s.titreSerie)\n" +
                "FROM web.jax.rs.data.jpa.domain.Album a, web.jax.rs.data.jpa.domain.Albumpersonne apde, web.jax.rs.data.jpa.domain.Albumpersonne apsc \n" +
                "LEFT JOIN a.serie s\n" +
                "WHERE apde.album = a AND apsc.album = a \n" +
                "AND apde.metier.libelleMetier = 'Dessin' AND apde.personne.nomUsuel = :dessinateur \n" +
                "AND apsc.metier.libelleMetier = 'Scenario' AND apsc.personne.nomUsuel = :scenariste \n" +
                "AND s.titreSerie = :titreSerie");
        q.setParameter("titreSerie","Astérix");
        q.setParameter("dessinateur","Uderzo, Albert");
        q.setParameter("scenariste","Goscinny, René");
        List<AlbumShortDTO> albumShortDTOS = q.getResultList();
        int expected = 9;
        int actual = albumShortDTOS.size();

        assertEquals(expected,actual);
    }

    @Test
    public void nbAlbums_All_39() {
        Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dto.AlbumCountAuthorEditorDTO(count(a), a.editeur, ap.personne)\n" +
                "FROM web.jax.rs.data.jpa.domain.Album a \n" +
                "LEFT JOIN a.albumpersonnes ap \n" +
                "GROUP BY a.editeur.nomEditeur, ap.personne.nomUsuel \n" +
                "ORDER BY count(a)");

        List<AlbumCountAuthorEditorDTO> albumShortDTOS = q.getResultList();
        int expected = 39;
        int actual = albumShortDTOS.size();

        assertEquals(expected,actual);

    }




}
