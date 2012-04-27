package test.spring.data.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

@SuppressWarnings("serial")
@Entity(name="Product")
public class Product extends AbstractPersistable<Long>{

	private String name;
	private int price;
	
	@OneToMany(mappedBy="product")
	List<BuyProduct> buyProducts;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
