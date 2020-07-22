package cfranc.com.comics.collector.ws.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

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
	public void allAlbumShort_ALL_207() {
		Query q = em.getEntityManager().createQuery("SELECT NEW vriz.com.dto.AlbumShortDTO(a.titreAlbum, s.titreSerie) FROM Album a, Serie s WHERE a.serie = s");
		List<Album> r = q.getResultList();
		int expected = 207;
		int actual = r.size();
		assertEquals(expected, actual);
		
	}
	
	@Test 
	public void getAlbumShort_Brigande_1() {
		Query q = em.getEntityManager().createQuery("SELECT NEW vriz.com.dto.AlbumShortDTO(a.titreAlbum, s.titreSerie) "
				+ "FROM Album a, Serie s WHERE a.serie = s "
				+ "AND a.titreAlbum= :titreAlbum");
		q.setParameter("titreAlbum", "Les Couloirs de l Entretemps");
		List<Album> r = q.getResultList();
		int expected = 1;
		int actual = r.size();
		assertEquals(expected, actual);
	}
	
	@Test 
	public void getCouple_Asterix_UderzoGoscinny() {
		Query q = em.getEntityManager().createQuery("SELECT NEW vriz.com.dto.AlbumShortDTO(select ap.personne.nomUsuel "
				+ "FROM Albumpersonne ap JOIN ap.album a2"
				+ " WHERE a2 = a AND ap.metier.libelleMetier = 'scenario'), "
				+ "(select ap.personne.nomUsuel "
				+ "FROM Albumpersonne ap JOIN ap.album a2 "
				+ "WHERE a2 = a AND ap.metier.libelleMetier = 'dessin'), a.titreAlbum, s.titreSerie) "
				+ "FROM ALBUM a LEFT JOIN a.serie s");
		
		/*q.setParameter("titreAlbum", "Les Couloirs de l Entretemps");
		q.setParameter("titreSerie", "Astérix");*/
		List<Album> r = q.getResultList();
		int expected = 207;
		int actual = r.size();
		assertEquals(expected, actual);
		
	}
	
	
	
}
