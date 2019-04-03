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

import DTO.AlbumShortDTO;
import cfranc.com.comics.collector.ws.model.Album;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AlbumRepositoryTest {
	
	@Autowired
	private TestEntityManager em;

	@Test
	public void testFindAllSort() 
	{
		Query q = em.getEntityManager().createQuery("SELECT a FROM Album a");
		List<Album> r = q.getResultList();
		
		int expected = 207;
		int actual = r.size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void allAlbumShort_ALL_207() 
	{
		
		Query query = em.getEntityManager().createQuery("SELECT NEW DTO.AlbumShortDTO(a.titreAlbum, s.titreSerie) FROM Album a, Serie s WHERE a.serie = s");
		List<AlbumShortDTO> albums = query.getResultList();
		
		int expected = 207;
		int actual = albums.size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getAlbumsShort_Brigande_1() 
	{
		Query query = em.getEntityManager().createQuery("SELECT NEW DTO.AlbumShortDTO(a.titreAlbum, s.titreSerie) FROM Album a, Serie s WHERE a.serie = s AND a.titreAlbum= :titreAlbum");
		query.setParameter("titreAlbum", "Sanctions");
		List<AlbumShortDTO> albums = query.getResultList();
		
		int expected = 1;		
		int actual = albums.size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getCouple_Asterix_UderzoGoscinny()
	{
		Query query = em.getEntityManager().createQuery("SELECT NEW DTO.AlbumShortDTO((SELECT ap.personne.nomUsuel FROM Albumpersonne ap JOIN ap.album a2 WHERE a2 = a AND ap.metier.libelleMetier = 'Scenario'), (SELECT ap.personne.nomUsuel FROM Albumpersonne ap JOIN ap.album a2 WHERE a2 = a AND ap.metier.libelleMetier = 'Dessin'), a.titreAlbum, s.titreSerie) FROM Album a LEFT JOIN a.serie s");
		List<AlbumShortDTO> albums = query.getResultList();
		
		int expected = 207;		
		int actual = albums.size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void nbAlbums_All_39()
	{
		Query query = em.getEntityManager().createQuery("SELECT NEW DTO.AlbumCountAuthorEditorDTO(count(a), a.editeur, ap.personne) FROM Album a LEFT JOIN a.albumpersonnes ap GROUP BY a.editeur.nomEditeur, ap.personne.nomUsuel ORDER BY count(a)");
		List<AlbumShortDTO> albums = query.getResultList();
		
		int expected = 39;		
		int actual = albums.size();
		
		assertEquals(expected, actual);
	}
	
	
}
