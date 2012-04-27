package test.spring.data.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

@SuppressWarnings("serial")
@Entity(name="BuyProduct")
public class BuyProduct extends AbstractPersistable<Long>{
	
	public BuyProduct() {
	}
	
	public BuyProduct(User user, Product product) {
		this.user = user;
		this.product = product;
		this.buyPrice = product.getPrice();
	}

	@ManyToOne
	private User user;
	
	@ManyToOne
	private Product product;
	
	private int buyPrice;
	
	public User getUser() {
		return user;
	}

	public Product getProduct() {
		return product;
	}
	
	public int getBuyPrice() {
		return buyPrice;
	};

	
}
