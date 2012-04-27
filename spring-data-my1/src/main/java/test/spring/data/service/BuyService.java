package test.spring.data.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.spring.data.domain.BuyProduct;
import test.spring.data.domain.Product;
import test.spring.data.domain.User;
import test.spring.data.repository.BuyProductRepository;

@Service
@Transactional
public class BuyService {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired BuyProductRepository buyProductRepository;
	
	public void buyProduct(User user, Product product){
		
		log.info("buy user={}, product={}", user, product);
		
		BuyProduct buyProduct = new BuyProduct(user, product);
		buyProductRepository.save(buyProduct);
		
	}
	

}
