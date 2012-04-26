package test.spring.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import test.spring.data.domain.User;
import test.spring.data.infra.AuditorAwareImpl;
import test.spring.data.repository.UserRepository;


/**
 * @author Oliver Gierke
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:auditing-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback=false)
public class AuditableUserSample {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AuditorAwareImpl auditorAware;

    @Test
    public void testname() throws Exception {

        User user = new User();
        user.setUserId("zipkyh");

        auditorAware.setAuditor(user);

        user = repository.save(user);
        user = repository.save(user);
        
        Iterable<User> findAll = repository.findAll();
        for (User user2 : findAll) {
			System.out.println("resultUser = " + user2);
		}
        
        assertEquals(user, user.getCreatedBy());
        assertEquals(user, user.getLastModifiedBy());
    }
}
