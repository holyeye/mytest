package test.spring.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
	
	@Id
	private String id;
	
	@Column
	private String name;
	
	@Column(length=4000)
	private String description;
	
	@Column(unique=true, length=11)
	private String hp;
	
	@Column
	private int age;
	
	@Column(name="MONEY_TOTAL")
	private long money;
	
	
}
