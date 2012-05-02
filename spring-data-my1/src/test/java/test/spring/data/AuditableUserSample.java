package test.spring.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import test.spring.data.domain.Product;
import test.spring.data.domain.User;
import test.spring.data.infra.AuditorAwareImpl;
import test.spring.data.repository.ProductRepository;
import test.spring.data.repository.UserRepository;
import test.spring.data.service.BuyService;


/**
 * @author Oliver Gierke
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:auditing-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class AuditableUserSample {

    @Autowired UserRepository userRepository;
    @Autowired ProductRepository productRepository;
    
    @Autowired BuyService buyService;

    @Autowired
    private AuditorAwareImpl auditorAware;

    @Test
    public void testname() throws Exception {
    	
        User user1 = new User();
        user1.setLoginId("zipkyh1");
        user1.setName("김영한");
        auditorAware.setAuditor(user1);
        
        User user2 = new User();
        user2.setLoginId("zipkyh2");
        user2.setName("김영한2");
        
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        userRepository.save(users);
        
        
        Product product = new Product();
        product.setName("명품가방");
        product.setPrice(1000000);
        
        product = productRepository.save(product);
        
        
        User findUser = userRepository.findByLoginId("zipkyh1");
        buyService.buyProduct(findUser, product);
        
//        buyService.buyProductbyLoginId(user1.getLoginId(), product.getId());
        
    }
    
}
