package cfranc.com.comics.collector.ws;


import cfranc.com.comics.collector.ws.model.Album;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Query;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AlbumRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Test
    public void testFindAllSort() {
        Query q = em.getEntityManager().createQuery("SELECT a FROM Album a");
        List<Album> r = q.getResultList();
        int expected = 207;
        int actual = r.size();
        assertEquals(expected, actual);

    }

    @Test
    public void testFindAllSort_All_207() {
        Query q = em.getEntityManager().createQuery("SELECT NEW cfranc.com.comics.collector.ws.DTO.AlbumShortDTO(a.titreAlbum, s.titreSerie) FROM Album a, Serie s WHERE a.serie = s");
        List<Album> r = q.getResultList();
        int expected = 207;
        int actual = r.size();
        assertEquals(expected, actual);

    }

    @Test
    public void testFindAllSort_Tempetes_1() {
        Query q = em.getEntityManager().createQuery("SELECT NEW cfranc.com.comics.collector.ws.DTO.AlbumShortDTO(a.titreAlbum, s.titreSerie) FROM Album a, Serie s WHERE a.serie = s AND a.titreAlbum= 'Tempêtes'");
        List<Album> r = q.getResultList();
        int expected = 1;
        int actual = r.size();
        assertEquals(expected, actual);

    }

    @Test
    public void getCouple_Asterix_UderzoGoscinny(){
        Query q = em.getEntityManager().createQuery("SELECT NEW cfranc.com.comics.collector.ws.DTO.AlbumShortDTO(\n" +
                "(SELECT ap.personne.nomUsuel FROM Albumpersonne ap JOIN ap.album a2\n" +
                "WHERE a2 = a AND ap.metier.libelleMetier = 'Goscinny, René'),\n" +
                "(SELECT ap.personne.nomUsuel FROM Albumpersonne ap JOIN ap.album a2\n" +
                "WHERE a2 = a AND ap.metier.libelleMetier = 'Uderzo, Albert'),a.titreAlbum, s.titreSerie)\n" +
                "FROM Album a\n" +
                "LEFT JOIN a.serie s");
        List<Album> r = q.getResultList();
        int expected = 207;
        int actual = r.size();
        assertEquals(expected, actual);
    }

    @Test public void nbAlbums_All_39()
    {
        Query q = em.getEntityManager().createQuery("SELECT NEW \n" +
                "cfranc.com.comics.collector.ws.DTO.AlbumCountAuthorEditorDTO(count(a),a.editeur.nomEditeur, ap.personne.nomUsuel)\n" +
                "FROM Album a\n" +
                "LEFT JOIN a.albumpersonnes ap\n" +
                "GROUP BY a.editeur.nomEditeur, ap.personne.nomUsuel\n" +
                "ORDER BY count(a)");
        List<Album> r = q.getResultList();
        int expected = 39;
        int actual = r.size();
        assertEquals(expected, actual);
    }
}
