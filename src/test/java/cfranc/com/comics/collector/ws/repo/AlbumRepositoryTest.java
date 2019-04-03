package cfranc.com.comics.collector.ws.repo;

import cfranc.com.comics.collector.ws.dto.AlbumCountAuthorEditorDTO;
import cfranc.com.comics.collector.ws.dto.AlbumShortDto;
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
    public void testFindAllAlbum() {
        Query requete = em.getEntityManager().createQuery("SELECT a FROM Album a");
        List<Album> r = requete.getResultList();
        int expected = 207;
        int actual = r.size();
        assertEquals(expected, actual);
    }

    @Test
    public void allAlbumsShort_ALL_207() {
        Query q = em.getEntityManager().createQuery("SELECT NEW cfranc.com.comics.collector.ws.dto.AlbumShortDto(a.titreAlbum, s.titreSerie) FROM Album a, Serie s WHERE a.serie = s");
        List<AlbumShortDto> r = q.getResultList();
        int expected = 207;
        int actual = r.size();
        assertEquals(expected, actual);
    }

    @Test
    public void getAlbumsShort_Brigande_1() {
        Query q = em.getEntityManager().createQuery("SELECT NEW cfranc.com.comics.collector.ws.dto.AlbumShortDto(a.titreAlbum, s.titreSerie) FROM Album a, Serie s WHERE a.serie = s AND a.titreAlbum = :album");
        q.setParameter("album", "Novgora");
        List<AlbumShortDto> r = q.getResultList();
        int expected = 1;
        int actual = r.size();
        assertEquals(expected, actual);
    }

    @Test
    public void getCouple_Asterix_UderzoGoscinny() {
        Query q = em.getEntityManager().createQuery(
                "SELECT NEW cfranc.com.comics.collector.ws.dto.AlbumShortDto(\n" +
                        "(SELECT ap.personne.nomUsuel FROM Albumpersonne ap JOIN ap.album a2 WHERE a2 = a AND ap.metier.libelleMetier = 'Scenario'),\n" +
                        "(SELECT ap.personne.nomUsuel FROM Albumpersonne ap JOIN ap.album a2 WHERE a2 = a AND ap.metier.libelleMetier = 'Dessin'),\n" +
                        "a.titreAlbum, s.titreSerie)\n" +
                        "FROM Album a\n" +
                        "LEFT JOIN Serie s ON a.serie = s " /*+*/
//                        "JOIN Albumpersonne ap ON a = ap.album " +
//                        "WHERE " +
//                        "(ap.personne.prenom = 'Goscinny' AND ap.metier.libelleMetier = 'Scenario' AND ap.personne.prenom LIKE 'Uderzo' AND ap.metier.libelleMetier = 'Dessin')" +
//                        "OR " +
//                        "(ap.personne.prenom = 'Uderzo' AND ap.metier.libelleMetier = 'Scenario' AND ap.personne.prenom LIKE 'Goscinny' AND ap.metier.libelleMetier = 'Dessin')"
        );
        List<AlbumShortDto> r = q.getResultList();
        int expected = 7;
        int actual = r.size();
        assertEquals(expected, actual);
    }

    @Test
    public void nbAlbums_All_39() {
        Query q = em.getEntityManager().createQuery("SELECT NEW\n" +
                "cfranc.com.comics.collector.ws.dto.AlbumCountAuthorEditorDTO(count(a),\n" +
                "a.editeur, ap.personne)\n" +
                "FROM Album a\n" +
                "LEFT JOIN a.albumpersonnes ap\n" +
                "GROUP BY a.editeur.nomEditeur, ap.personne.nomUsuel\n" +
                "ORDER BY count(a)");

        List<AlbumCountAuthorEditorDTO> r = q.getResultList();
        int expected = 39;
        int actual = r.size();
        assertEquals(expected, actual);
    }

}