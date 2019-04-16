package cfranc.com.comics.collector.ws;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import cfranc.com.comics.collector.ws.dto.AlbumShortDTO;
import cfranc.com.comics.collector.ws.model.Album;

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
	public void allAlbumsShort_ALL_207() {
	Query q = em.getEntityManager().createQuery("SELECT NEW\r\n" + 
			"cfranc.com.comics.collector.ws.dto.AlbumShortDTO(a.titreAlbum,\r\n" + 
			"s.titreSerie) FROM Album a, Serie s WHERE a.serie = s");
	List<Album> r = q.getResultList();
	int expected = 207;
	int actual = r.size();
	assertEquals(expected, actual);
    }
    
    @Test
  	public void getAlbumsShort_Brigande_1() {
  	Query q = em.getEntityManager().createQuery("SELECT a FROM Album a WHERE a.titreAlbum = :titre");
  	q.setParameter("titre","Brigande");
  	List<AlbumShortDTO> r = q.getResultList();
  	int actual = r.size();
  	assertEquals(actual,1);
  	}
    
    @Test
  	public void Asterix_UderzoGoscinny(){
  	Query q = em.getEntityManager().createQuery("SELECT NEW cfranc.com.comics.collector.ws.dto.AlbumShortDTO(\r\n " + 
  			" (SELECT ap.personne.nomUsuel FROM Albumpersonne ap JOIN ap.album a2\r\n " + 
  			" WHERE a2 = a AND ap.metier.libelleMetier = 'Scenario'),\r\n " + 
  			" (SELECT ap.personne.nomUsuel FROM Albumpersonne ap JOIN ap.album a2\r\n " + 
  			" WHERE a2 = a AND ap.metier.libelleMetier = 'Dessin'),\r\n " + 
  			" a.titreAlbum, s.titreSerie)\r\n" + 
  			" FROM Album a\r\n" + 
  			" LEFT JOIN a.serie s ");
  	List<Album> r = q.getResultList();
  	int expected = 207;
  	int actual = r.size();
  	assertEquals(expected, actual);
  	}
    
    @Test
  	public void nbAlbums_All_39() {
  	Query q = em.getEntityManager().createQuery("SELECT NEW\r\n" + 
  			" cfranc.com.comics.collector.ws.dto.AlbumBisDTO(count(a),\r\n" + 
  			" a.editeur.nomEditeur, ap.personne.nom)\r\n" + 
  			" FROM Album a\r\n" + 
  			" LEFT JOIN a.albumpersonnes ap\r\n" + 
  			" GROUP BY a.editeur.nomEditeur, ap.personne.nomUsuel\r\n" + 
  			" ORDER BY count(a)");
  	List<Album> r = q.getResultList();
  	int expected = 39;
  	int actual = r.size();
  	assertEquals(expected, actual);
  	}
    

}
