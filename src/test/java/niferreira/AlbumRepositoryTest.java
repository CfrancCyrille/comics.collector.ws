package niferreira;
import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import cfranc.com.comics.collector.ws.model.Album;
import cfranc.com.comics.collector.ws.repo.AlbumRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AlbumRepositoryTest {
	
	@Autowired
	private TestEntityManager em;

	@Test
	public void FindAllTest() {
		Query q = em.getEntityManager().createQuery("SELECT a FROM Album a");
		List<Album> r = q.getResultList();
		
		int expected = 207;
		int actual = r.size();
		
		assertEquals(expected, actual);
	}

}
