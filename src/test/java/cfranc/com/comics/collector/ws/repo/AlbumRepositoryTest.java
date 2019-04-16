package cfranc.com.comics.collector.ws.repo;

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
	
		Query q = (Query) em.getEntityManager().createQuery("SELECT a FROM Album a");
		
		List<Album> r =  q.getResultList();
		int expected = 207;
		int actual = r.size();
		assertEquals(expected, actual);
	
	}
	
	@Test
	public void allAlbumsShort_ALL_207(){
		Query q = (Query) em.getEntityManager().createQuery("SELECT NEW\r\n" + 
				"cfranc.com.comics.collector.ws.dto.AlbumShortDTO(a.titreAlbum,\r\n" + 
				"s.titreSerie) FROM Album a, Serie s WHERE a.serie = s");
		
		List<AlbumShortDTO> r =  q.getResultList();
		int expected = 207;
		int actual = r.size();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getAlbumsShort_Brigande_1(){
		
		Query q = (Query) em.getEntityManager().createQuery("SELECT NEW\r\n" + 
				"cfranc.com.comics.collector.ws.dto.AlbumShortDTO(a.titreAlbum,\r\n" + 
				"s.titreSerie) FROM Album a, Serie s WHERE a.serie = s AND\r\n" + 
				"a.titreAlbum= :titreAlbum").setParameter("titreAlbum", "Brigande");
		
		List<AlbumShortDTO> r = q.getResultList();
		int expected = 1;
		int actual = r.size();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getCouple_Asterix_UderzoGoscinny(){
		/*
		Query q = (Query) em.getEntityManager().createQuery("SELECT NEW cfranc.com.comics.collector.ws.dto.AlbumShortDTO(\r\n" + 
				
				"(SELECT ap.metier.libelleMetier FROM Albumpersonne ap JOIN personne.nomUsuel a2\r\n" + 
				"WHERE a2 = 'Goscinny' AND ap = 'Scenario'),\r\n" + 
				
				"(SELECT ap.metier.libelleMetier FROM Albumpersonne ap JOIN personne.nomUsuel a2\r\n" + 
				"WHERE a2 = 'Uderzo' AND ap = 'Dessin'),\r\n" + 

				"a.titreAlbum, s.titreSerie)\r\n" + 
				"FROM Album a\r\n" + 
				"LEFT JOIN a.serie s");
		*/
		Query q = (Query) em.getEntityManager().createQuery("SELECT NEW cfranc.com.comics.collector.ws.dto.AlbumShortDTO(\r\n" + 
		"(SELECT titre_album , ID_ALBUM from ALBUM where ID_SERIE IN  ( \r\n" +
		"     SELECT ID_SERIE FROM SERIE where ID_SERIE =  3 AND ID_ALBUM IN( \r\n" +
		"         SELECT ID_ALBUM FROM ALBUMPERSONNE WHERE ALBUMPERSONNE.ID_ALBUM = ALBUM.ID_ALBUM \r\n" +
		"         AND ID_PERSONNE IN(5,6)) \r\n" +
		"     ) \r\n" +
		")");
		
		
		/* TEST SQL
			SELECT titre_album , ID_ALBUM from ALBUM where ID_SERIE IN  (
			     SELECT ID_SERIE FROM SERIE where ID_SERIE =  3 AND ID_ALBUM IN( 
			         SELECT ID_ALBUM FROM ALBUMPERSONNE WHERE ALBUMPERSONNE.ID_ALBUM = ALBUM.ID_ALBUM 
			         AND ID_PERSONNE IN(5,6)
			     )
			)
		 */
		
		List<AlbumShortDTO> r =  q.getResultList();
		int expected = 7;
		int actual = r.size();
		assertEquals(expected, actual);
	}
	
	@Test
	public void nbAlbums_All_39(){
		
		Query q = (Query) em.getEntityManager().createQuery("SELECT NEW\r\n" + 
				"cfranc.com.comics.collector.ws.dto.AlbumCountAuthorEditorDTO(count(a),\r\n" +
				"a.editeur, ap.personne)\r\n" + 
				"FROM Album a\r\n" + 
				"LEFT JOIN a.albumpersonnes ap\r\n" + 
				"GROUP BY a.editeur.nomEditeur, ap.personne.nomUsuel\r\n" + 
				"ORDER BY count(a)");
		
		
		List<AlbumShortDTO> r =  q.getResultList();
		int expected = 39;
		int actual = r.size();
		assertEquals(expected, actual);
	}
	
}
