package test.spring.data.onetomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class BadaUser {

	@Id @GeneratedValue
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="badaUser")
	Collection<BadaDevice> BadaDevices = new ArrayList<BadaDevice>();
	
	public void addBadaDevice(BadaDevice badaDevice) {
		badaDevice.setBadaUser(this);
		this.BadaDevices.add(badaDevice);
	}
	
	public Long getId() {
		return id;
	}
	
	public Collection<BadaDevice> getBadaDevices() {
		return BadaDevices;
	}
}