package comics.collector.ws.model;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import comics.collector.ws.domain.Album;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AlbumRepositoryTest {
	@Autowired
	private TestEntityManager em;
//
//	@Test
//	public void testFindAllSort() {
//		Query q = em.getEntityManager().createQuery("SELECT book FROM comics.collector.ws.model.Album book");
//		List<Album> r = q.getResultList();
//		int expected = 207;
//		int actual = r.size();
//		assertEquals(expected, actual);
//		System.out.println("requete 1 : " + actual);
//	}

	@Test
	public void allAlbumShort_ALL_207() {
		Query q = em.getEntityManager().createQuery("SELECT NEW comics.collector.ws.dto.AlbumShortDTO(book.titreAlbum, view.titreSerie) FROM Album book, Serie view WHERE book.serie = view");
		List<Album> r = q.getResultList();
		int expected = 207;
		int actual = r.size();
		assertEquals(expected, actual);
		System.out.println("requete 2 : " + actual);
	}

	@Test
	public void getAlbumsShort_Brigande_1() {
		Query q = em.getEntityManager().createQuery("SELECT NEW comics.collector.ws.dto.AlbumShortDTO(book.titreAlbum, view.titreSerie) FROM Album book, Serie view WHERE book.serie = view AND book.titreAlbum= :titreAlbum");
		q.setParameter("titreAlbum", "Novgora");
		List<Album> r = q.getResultList();
		int expected = 1;
		int actual = r.size();
		assertEquals(expected, actual);
		System.out.println("requete 3 : " + actual);
	}

	@Test
	public void getCouple_Asterix_UderzoGoscinny() {
		Query q = em.getEntityManager().createQuery("SELECT NEW comics.collector.ws.dto.AlbumShortDTO((SELECT name.personne.nomUsuel FROM Albumpersonne name JOIN name.album book2 WHERE book2 = book AND name.metier.libelleMetier = 'Scenario'), (SELECT name.personne.nomUsuel FROM Albumpersonne name JOIN name.album book2 WHERE book2 = book AND name.metier.libelleMetier = 'Dessin'), book.titreAlbum, view.titreSerie) FROM Album book LEFT JOIN book.serie view");
		List<Album> r = q.getResultList();
		int expected = 207;
		int actual = r.size();
		assertEquals(expected, actual);
		System.out.println("requete 4 : " + actual);
	}

	@Test
	public void nbAlbums_All_39() {
		Query q = em.getEntityManager().createQuery("SELECT NEW comics.collector.ws.dto.AlbumCountAuthorEditorDTO(count(book), book.editeur, name.personne) FROM Album book LEFT JOIN book.albumpersonnes name GROUP BY book.editeur.nomEditeur, name.personne.nomUsuel ORDER BY count(book)");
		List<Album> r = q.getResultList();
		int expected = 39;
		int actual = r.size();
		assertEquals(expected, actual);
		System.out.println("requete 5 : " + actual);
	}
}
