package test.spring.data.value;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.UniqueConstraint;

@Entity
public class GoodMember {

	@Id @GeneratedValue
	private Long id;

	private String name;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="GOODMEMBER_ID")
	private List<AddressEntity> addresses = new ArrayList<AddressEntity>();
	
	@ElementCollection
	@OrderColumn
	private Set<String> comments = new HashSet<String>();
	
	public void addAddress(AddressEntity address) {
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

	public Collection<AddressEntity> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressEntity> addresses) {
		this.addresses = addresses;
	}

	public Set<String> getComments() {
		return comments;
	}

	public void setComments(Set<String> comments) {
		this.comments = comments;
	}
	
	

		
}
