package org.mitre.dtf.repository;

import static org.junit.Assert.*;
import static org.mitre.dtf.test.TestData.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mitre.dtf.test.TestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * WARNING: This unit test currently uses actual application context for testing.
 * This may have undesirable results on your persistent data store.
 * 
 * @author wkim
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/application-context.xml")
public class JpaInstanceRepositoryTest {

	@Autowired
	InstanceRepository instanceRepository;

	// get testing data from with static import from TestData.java
	
	@Before
	public void setUp() throws Exception {
		TestData.initialize();
	}

	@Test
	public void testRoundTrip() {
		instanceRepository.save(INSTANCE1);
		
		assertEquals(INSTANCE1, instanceRepository.getById(1));
	}

}
