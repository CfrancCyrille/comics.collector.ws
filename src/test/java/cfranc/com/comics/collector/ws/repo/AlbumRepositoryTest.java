package cfranc.com.comics.collector.ws.repo;

import static org.junit.Assert.*;

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
import cfranc.com.comics.collector.ws.model.Album;
import cfranc.com.comics.collector.ws.model.Albumpersonne;;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AlbumRepositoryTest {

	@Autowired
	private TestEntityManager em;
	
	@Test
	public void testFindAll() {
		Query requete = em.getEntityManager().createQuery("SELECT a FROM Album a");
		List<Album> r = requete.getResultList();
		int expected = 207;
		int actual = r.size();
		assertEquals(expected, actual);
	}

	//Liste des titres d'albums et du nom de série
	@Test
	public void allAlbumsShort(){
		Query requete = em.getEntityManager().createQuery("SELECT NEW cfranc.com.comics.collector.ws.dto.AlbumShortDTO(a.titreAlbum,s.titreSerie) FROM Album a, Serie s WHERE a.serie = s");
		List<AlbumShortDTO> r = requete.getResultList();
		int expected = 207;
		int actual = r.size();
		assertEquals(expected, actual);
	}
	
	//Liste des albums avec un titre en paramètre
	@Test
	public void getAlbumsShort_Brigande_1() {
		Query requete = em.getEntityManager().createQuery("SELECT NEW "
				+ "cfranc.com.comics.collector.ws.dto.AlbumShortDTO(a.titreAlbum,s.titreSerie) "
				+ "FROM Album a, Serie s WHERE a.serie = s AND a.titreAlbum= :titreAlbum");
		requete.setParameter("titreAlbum", "Tempêtes");
		List<AlbumShortDTO> r = requete.getResultList();
		int expected = 1;
		int actual = r.size();
		assertEquals(expected, actual);
	}

	//Scénaristes et dessinateurs pour chaque album/série (avec sous-requêtes)
	@Test 
	public void getCouple_Asterix_UderzoGoscinny() {
		Query requete = em.getEntityManager().createQuery("SELECT NEW "
				+ "cfranc.com.comics.collector.ws.dto.AlbumShortDTO( "
				+ "(SELECT ap.personne.nomUsuel FROM Albumpersonne ap JOIN ap.album a2 WHERE a2 = a AND ap.metier.libelleMetier = 'Scenario'), "
				+ "(SELECT ap.personne.nomUsuel FROM Albumpersonne ap JOIN ap.album a2 WHERE a2 = a AND ap.metier.libelleMetier = 'Dessin'), "
				+ "a.titreAlbum, s.titreSerie ) FROM Album a LEFT JOIN a.serie s");
		List<AlbumShortDTO> r = requete.getResultList();
		int expected = 207;
		int actual = r.size();
		assertEquals(expected, actual);
	}
	
	//Nombre d'albums par auteur pour chaque éditeur
	@Test
	public void nbAlbums_All_39() {
		Query requete = em.getEntityManager().createQuery("SELECT NEW cfranc.com.comics.collector.ws.dto.AlbumCountAuthorEditorDTO("
				+ "count(a), a.editeur, ap.personne) FROM Album a "
				+ "LEFT JOIN a.albumpersonnes ap "
				+ "GROUP BY a.editeur.nomEditeur, ap.personne.nomUsuel "
				+ "ORDER BY count(a)");
		
		List<AlbumCountAuthorEditorDTO> r = requete.getResultList();
		int expected = 39;
		int actual = r.size();
		assertEquals(expected, actual);
	}
}
