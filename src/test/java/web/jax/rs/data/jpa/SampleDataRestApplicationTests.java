/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package web.jax.rs.data.jpa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import dto.AlbumCountEditorAuthor;
import dto.AlbumShortDTO;
import junit.framework.Assert;
import web.jax.rs.data.jpa.domain.Album;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.persistence.Query;

/**
 * Integration test to run the application.
 * 
 * @author Oliver Gierke
 */
@RunWith(SpringRunner.class)
@DataJpaTest
// Separate profile for web tests to avoid clashing databases
public class SampleDataRestApplicationTests {
	@Autowired
	 private TestEntityManager em;
//	@Test
//	public void contextLoads() {
//	}
	
	
	@Test public void
	allAlbumsShort_ALL_207()
	{
		Query q = em.getEntityManager().createQuery("SELECT NEW" + 
				"		dto.AlbumShortDTO(a.titreAlbum," + 
				"		s.titreSerie) FROM Album a, Serie s WHERE a.serie = s");
		 List<AlbumShortDTO> r = q.getResultList();
		Integer expected = 207;
		Integer actual = r.size();
		assertEquals(expected, actual);
	}
	@Test public void
	getAlbumsShort_Brigande_1() {
		Query q = em.getEntityManager().createQuery("SELECT NEW " + 
				"dto.AlbumShortDTO(a.titreAlbum," + 
				"s.titreSerie) FROM Album a, Serie s WHERE a.serie = s AND " + 
				"a.titreAlbum= :titreAlbum");
		q.setParameter("titreAlbum", "Brigande");
		 List<AlbumShortDTO> r = q.getResultList();
			Integer expected = 1;
			Integer actual = r.size();
			assertEquals(expected, actual);
	}
	
	
	
	@Test public void getCouple_Asterix_UderzoGoscinny() {
		
		Query q = em.getEntityManager().createQuery("SELECT new dto.AlbumShortDTO(a.titreAlbum, s.titreSerie) FROM Album a JOIN a.serie s where "
				+ "(SELECT ap.personne.prenom FROM Albumpersonne ap JOIN ap.album a2 " + 
				"			WHERE a2 = a AND ap.metier.libelleMetier = 'Dessin') = 'Uderzo' AND "
				+ "(SELECT ap.personne.prenom FROM Albumpersonne ap JOIN ap.album a2 " + 
				"			WHERE a2 = a AND ap.metier.libelleMetier = 'Scenario') = 'Goscinny' ");
	
		
		
		
		
		List<Album> r = q.getResultList();
		
		Integer expected = 9;
		Integer actual = r.size();
		assertEquals(expected, actual);
		
	}
	
	@Test public void nbAlbums_All_39() {
		Query q = em.getEntityManager().createQuery("SELECT new dto.AlbumCountEditorAuthor(ap.personne.nomUsuel, a.editeur.nomEditeur, count(a)) "
				+ "FROM Album a "
				+ "LEFT JOIN a.albumpersonnes ap "
				+ "GROUP BY ap.personne.nomUsuel, a.editeur.nomEditeur "
				+ "ORDER BY count(a)");
		List<AlbumCountEditorAuthor> r = q.getResultList();	
		Integer expected = 39;
		Integer actual = r.size();
		assertEquals(expected, actual);		
		
	}
	
}
