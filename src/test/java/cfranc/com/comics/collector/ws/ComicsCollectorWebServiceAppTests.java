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

package cfranc.com.comics.collector.ws;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import cfranc.com.comics.collector.ws.dto.AlbumShortDTO;
import cfranc.com.comics.collector.ws.model.Album;

/**
 * Integration test to run the application.
 * 
 * @author Oliver Gierke
 */
//@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:test-app-context.xml")
@SpringBootTest
// Separate profile for web tests to avoid clashing databases
public class ComicsCollectorWebServiceAppTests {

	@Autowired
	private TestEntityManager em;
	
	/*
		@Test
		public void contextLoads() {
		}
	*/
	
}
