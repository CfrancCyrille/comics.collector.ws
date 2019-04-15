/*Modifications thought and done by Samy TAYACH */
package cfranc.com.comics.collector.ws.model;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AlbumTest {

	@Autowired
	private TestEntityManager em;

	@Test
	public void test() {
		Album a=em.find(Album.class, 0);
		assertNull(a);
	}

}
