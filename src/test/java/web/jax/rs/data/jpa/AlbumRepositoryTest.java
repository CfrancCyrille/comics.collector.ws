package web.jax.rs.data.jpa;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import web.jax.rs.data.jpa.domain.Album;

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
		Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dto.AlbumShortDTO(a.titreAlbum, s.titreSerie) FROM Album a, Serie s WHERE a.serie = s");
		List<Album> r = q.getResultList();
		int expected = 207;
		int actual = r.size();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getAlbumsShort_Brigande_1() {
		Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dto.AlbumShortDTO(a.titreAlbum, s.titreSerie) FROM Album a, Serie s WHERE a.serie = s AND a.titreAlbum = :titreAlbum");
		q.setParameter("titreAlbum", "Brigande");
		List<Album> r = q.getResultList();
		int expected = 1;
		int actual = r.size();
		assertEquals(expected, actual);
	}

	@Test
	public void getCouple_Asterix_UderzoGoscinny() {
		Query q = em.getEntityManager().createQuery("SELECT NEW web.jax.rs.data.jpa.dto.AlbumShortDTO(\n" +
                "(SELECT ap.personne.nomUsuel FROM Albumpersonne ap JOIN ap.album a2\n" +
                "WHERE a2 = a AND ap.metier.libelleMetier = 'Goscinny, René'),\n" +
                "(SELECT ap.personne.nomUsuel FROM Albumpersonne ap JOIN ap.album a2\n" +
                "WHERE a2 = a AND ap.metier.libelleMetier = 'Uderzo, Albert'),a.titreAlbum, s.titreSerie)\n" +
                "FROM Album a\n" +
                "LEFT JOIN a.serie s");
		List<Album> r = q.getResultList();
		int expected = 7;
		int actual = r.size();
		assertEquals(expected, actual);
	}
	
}
