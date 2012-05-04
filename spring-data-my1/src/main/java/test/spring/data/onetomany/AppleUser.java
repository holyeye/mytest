package test.spring.data.onetomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class AppleUser {

	@Id @GeneratedValue
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="appleUser_id")
	Collection<AppleDevice> appleDevices = new ArrayList<AppleDevice>();
	
	public void addAppleDevice(AppleDevice appleDevice) {
		this.appleDevices.add(appleDevice);
	}
	
	public Long getId() {
		return id;
	}
}