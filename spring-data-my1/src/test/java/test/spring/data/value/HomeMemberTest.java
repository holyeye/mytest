package test.spring.data.value;

import static org.junit.Assert.*;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import test.spring.data.onetomany.AppleDevice;
import test.spring.data.onetomany.AppleUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:auditing-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class HomeMemberTest {

	@PersistenceContext EntityManager em;
	
	@Test
	public void testValue() {
		HomeMember member = new HomeMember();
		member.setName("KKK");
		
		Address address = createAdd1();
		member.setAddress(address);
		
		em.persist(member);
		
		em.flush();
		em.clear();
		
		HomeMember findMember = em.find(HomeMember.class, member.getId());
		
	}
	
	@Test
	public void testCollectionValue() {
		
		GoodMember member = new GoodMember();
		member.setName("KKK");
		
		Address address1 = createAdd1();
		
		
		member.addAddress(address1);
		member.addComment("좋아요");
		
		em.persist(member);
		
		em.flush();
		em.clear();
		
		GoodMember findMember = em.find(GoodMember.class, member.getId());
		
		
		Address address2 = createAdd2();
		
		findMember.addAddress(address2);
		findMember.addComment("싫어요");
		
		
		em.persist(findMember);
		
		em.flush();
		em.clear();
		
		GoodMember findMember2 = em.find(GoodMember.class, member.getId());
		
		Collection<Address> addresses = findMember2.getAddresses();
		for (Address address : addresses) {
			System.out.println(address);
		}
		
	}

	private Address createAdd1() {
		Address address1 = new Address();
		address1.setCity("서울");
		address1.setStreet("용산구");
		address1.setZipcode("123-123");
		return address1;
	}

	private Address createAdd2() {
		Address address2 = new Address();
		address2.setCity("진주");
		address2.setStreet("상대동");
		address2.setZipcode("100-200");
		return address2;
	}
	
}
