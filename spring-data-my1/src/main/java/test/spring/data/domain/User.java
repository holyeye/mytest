package test.spring.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity(name="USER_TEST")
public class User extends AbstractAuditable<User,Long>{

	private static final long serialVersionUID = 2472544022364917547L;
	
	@Column(unique = true)
	private String userId;
	
	private String userName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
