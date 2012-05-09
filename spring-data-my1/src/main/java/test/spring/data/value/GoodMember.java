package test.spring.data.value;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderColumn;

@Entity
public class GoodMember {

	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
	@ElementCollection
	@OrderColumn
	private Set<Address> addresses = new HashSet<Address>();
	
	@ElementCollection
	@OrderColumn
	private Set<String> comments = new HashSet<String>();
	
	public void addAddress(Address address) {
		addresses.add(address);
	}
	
	public void addComment(String comment) {
		comments.add(comment);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<String> getComments() {
		return comments;
	}

	public void setComments(Set<String> comments) {
		this.comments = comments;
	}
	
	

		
}
