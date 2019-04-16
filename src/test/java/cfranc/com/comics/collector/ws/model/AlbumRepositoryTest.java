package cfranc.com.comics.collector.ws.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import cfranc.com.comics.collector.ws.dto.AlbumCountAuthorEditorDTO;
import cfranc.com.comics.collector.ws.dto.AlbumShortDTO;


@RunWith(SpringRunner.class)
@DataJpaTest //sert à expliquer au prog que l'on est en test
public class AlbumRepositoryTest {
  @Autowired
  private TestEntityManager em;

  @Test
  public void test_FindAllSort() {
    Query q = em.getEntityManager().createQuery("SELECT a FROM Album a"); //création objet qui contient la requete à la base de donnée
    List<Album> r = q.getResultList();
    int expected = 207;
    int actual = r.size();
    assertEquals(expected, actual);
    }
  @Test
  public void test_allAlbumsShort_ALL_207() {
    Query q = em.getEntityManager().createQuery("SELECT NEW "
    		+ "cfranc.com.comics.collector.ws.dto.AlbumShortDTO(a.titreAlbum, s.titreSerie)"
    		+ " FROM Album a, Serie s"
    		+ " WHERE a.serie = s ");
    List<AlbumShortDTO> lad = q.getResultList();
    int expected = 207;
    int actual = lad.size();
    assertEquals(expected, actual);
  }
  @Test
  public void test_getAlbumsShort_Brigande_1() {
	  Query q = em.getEntityManager().createQuery("SELECT NEW "
	  		+ "cfranc.com.comics.collector.ws.dto.AlbumShortDTO(a.titreAlbum, s.titreSerie)"
	  		+ " FROM Album a, Serie s"
	  		+ " WHERE a.serie = s"
	  		+ " AND a.titreAlbum= :titreAlbum ");
	  q.setParameter("titreAlbum", "Brigande");
	  List<AlbumShortDTO> lad1 = q.getResultList();
	  int expected = 1;
	  int actual = lad1.size();
	  assertEquals(expected, actual);
  }
  @Test
  public void test_nbAlbums_All_39() {
	  Query q = em.getEntityManager().createQuery("SELECT NEW "
	  		+ "cfranc.com.comics.collector.ws.dto.AlbumCountAuthorEditorDTO(count(a), a.editeur, ap.personne)"
	  		+ " FROM Album a LEFT JOIN a.albumpersonnes ap GROUP BY a.editeur.nomEditeur, ap.personne.nomUsuel ORDER BY count(a)");
	  List<AlbumCountAuthorEditorDTO> lad2 = q.getResultList();
	  int expected = 39;
	  int actual = lad2.size();
	  assertEquals(expected, actual);
  }
  @Test
  public void test_getCouple_Asterix_UderzoGoscinny()
 {
	  Query q = em.getEntityManager().createQuery("SELECT NEW cfranc.com.comics.collector.ws.dto.AlbumShortDTO((SELECT ap.personne.nomUsuel FROM Albumpersonne ap JOIN ap.album a2 WHERE a2 = a AND ap.metier.libelleMetier = 'Scenario'),(SELECT ap.personne.nomUsuel FROM Albumpersonne ap JOIN ap.album a2 WHERE a2 = a AND ap.metier.libelleMetier = 'Dessin'),a.titreAlbum, s.titreSerie)FROM Album a LEFT JOIN a.serie s WHERE a.titreAlbum LIKE :titreAlbum ");
	  q.setParameter("titreAlbum", "Astérix%");
	  q.setParameter("nomUsuel", "%Uderzo%");
	  q.setParameter("nomUsuel", "%Goscinny%");
	  List<AlbumCountAuthorEditorDTO> lad3 = q.getResultList();
	  int expected = 7;
	  int actual = lad3.size();
	  assertEquals(expected, actual);
  }
}
