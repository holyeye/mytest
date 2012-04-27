package test.spring.data.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity(name="USER")
public class User extends AbstractAuditable<User,Long>{

	private static final long serialVersionUID = 2472544022364917547L;
	
	@Column(unique = true)
	private String loginId;
	
	@Column(length=10)
	private String name;
	
	@OneToMany(mappedBy="user")
	private List<BuyProduct> buys;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BuyProduct> getBuys() {
		return buys;
	}

	public void setBuys(List<BuyProduct> buys) {
		this.buys = buys;
	}

	
}
