package cfranc.com.comics.collector.ws.repo;

import cfranc.com.comics.collector.ws.dto.AlbumShortDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AlbumRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;
    private EntityManager entityManager;

    @Before
    public void setup() {
        if (entityManager != null) clean();
        entityManager = testEntityManager.getEntityManager();
    }

    @After
    public void clean() {
        entityManager = null;
    }

    @Test
    public void findAllClient() {
        Query request = entityManager.createQuery("SELECT album FROM Album album");
        /**
         * SELECT ALL :
         * Query request = testEntityManager.getEntityManager().createQuery("FROM Album");
         */
        List result   = request.getResultList();
        assertNotNull(result);
        int expectedSize = 207;
        int actualSize   = result.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void allAlbumsShortAll207() {
        /**
         * Add empty single quotes to match with the constructors of AlbumShortDTO
         */
        String query = "SELECT NEW cfranc.com.comics.collector.ws.dto.AlbumShortDTO('', '', album.titreAlbum, album.serie.titreSerie) " +
                       "FROM Album album";
        Query request = entityManager.createQuery(query);
        List<AlbumShortDTO> AlbumsShortDTO = request.getResultList();
        assertNotNull(AlbumsShortDTO);
        int expectedSize = 207;
        int actualSize   = AlbumsShortDTO.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getAlbumsShortBrigande1() {
        /**
         * Add empty single quotes to match with the constructors of AlbumShortDTO
         */
        String query = "SELECT NEW cfranc.com.comics.collector.ws.dto.AlbumShortDTO('', '', album.titreAlbum, album.serie.titreSerie) " +
                       "FROM Album album " +
                       "WHERE album.titreAlbum = :titreAlbum";
        Query request = entityManager.createQuery(query);
              request.setParameter("titreAlbum", "Le faucon du temple");
        List<AlbumShortDTO> AlbumsShortDTO = request.getResultList();
        assertNotNull(AlbumsShortDTO);
        int expectedSize = 1;
        int actualSize   = AlbumsShortDTO.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getCoupleAsterixUderzoGoscinny() {
        String query = "SELECT NEW cfranc.com.comics.collector.ws.dto.AlbumShortDTO(" +
                       "(SELECT albumpersonne.personne.nomUsuel " +
                        "FROM Albumpersonne albumpersonne " +
                        "JOIN albumpersonne.album album2 " +
                        "WHERE album2 = album AND albumpersonne.metier.libelleMetier = 'Scenario'), "+
                        "(SELECT albumpersonne.personne.nomUsuel " +
                        "FROM Albumpersonne albumpersonne " +
                        "JOIN albumpersonne.album album2 " +
                        "WHERE album2 = album AND albumpersonne.metier.libelleMetier = 'Dessin') "+
                       ") " +
                       "FROM Album album " +
                       "LEFT JOIN album.serie s";
        Query request = entityManager.createQuery(query);
        List<AlbumShortDTO> AlbumsShortDTO = request.getResultList();
        assertNotNull(AlbumsShortDTO);
        int expectedSize = 207;
        int actualSize   = AlbumsShortDTO.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void nbAlbumsAll39() {
        String query =  "SELECT NEW cfranc.com.comics.collector.ws.dto.AlbumCountAuthorEditorDTO(count(album), " +
                        "album.editeur, albumpersonnes.personne) " +
                        "FROM Album album " +
                        "LEFT JOIN album.albumpersonnes albumpersonnes " +
                        "GROUP BY album.editeur.nomEditeur, albumpersonnes.personne.nomUsuel " +
                        "ORDER BY count(album)";
        Query request = entityManager.createQuery(query);
        List<AlbumShortDTO> AlbumsShortDTO = request.getResultList();
        assertNotNull(AlbumsShortDTO);
        int expectedSize = 39;
        int actualSize   = AlbumsShortDTO.size();
        assertEquals(expectedSize, actualSize);
    }
}