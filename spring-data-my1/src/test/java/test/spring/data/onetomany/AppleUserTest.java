package test.spring.data.onetomany;

import java.util.Collection;

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
	
	@Test
	public void testJoinBi() {
		BadaUser user = new BadaUser();
		user.addBadaDevice(new BadaDevice());
		user.addBadaDevice(new BadaDevice());
		
		em.persist(user);
		
		em.flush();
		em.clear();
		
		BadaUser findUser = em.find(BadaUser.class, user.getId());
		Collection<BadaDevice> badaDevices = findUser.getBadaDevices();
		for (BadaDevice badaDevice : badaDevices) {
			System.out.println("id = " + badaDevice.getId() + " / "  + badaDevice.getBadaUser().getId());
		}
		
	}
	
	@Test
	public void testJoinUni() {
		DaumUser user = new DaumUser();
		user.addDaumDevice(new DaumDevice());
		user.addDaumDevice(new DaumDevice());
		
		em.persist(user);
		
		em.flush();
		em.clear();
		
		DaumUser findUser = em.find(DaumUser.class, user.getId());
		Collection<DaumDevice> daumDevices = findUser.getDaumDevices();
		for (DaumDevice daumDevice : daumDevices) {
			System.out.println("id = " + daumDevice.getId());
		}
		
	}

}
