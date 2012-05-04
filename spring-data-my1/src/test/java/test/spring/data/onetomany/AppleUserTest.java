package test.spring.data.onetomany;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:auditing-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class AppleUserTest {

	@PersistenceContext EntityManager em;
	
	@Test
	public void testUni() {
		AppleUser user = new AppleUser();
		user.addAppleDevice(new AppleDevice());
		user.addAppleDevice(new AppleDevice());
		
		em.persist(user);
		
		em.flush();
		em.clear();
		
		AppleUser find = em.find(AppleUser.class, user.getId());
		
	}
	
	@Test
	public void testBi() {
		AndroidUser user = new AndroidUser();
		user.addAndroidDevice(new AndroidDevice());
		user.addAndroidDevice(new AndroidDevice());
		
		em.persist(user);
		
		em.flush();
		em.clear();
		
		AndroidUser find = em.find(AndroidUser.class, user.getId());
		
	}

}
