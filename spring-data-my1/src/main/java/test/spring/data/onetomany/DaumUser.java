package test.spring.data.onetomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class DaumUser {

	@Id @GeneratedValue
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(joinColumns=@JoinColumn(name="daumUser_id"), inverseJoinColumns=@JoinColumn(name="daumDevice_id"))
	Collection<DaumDevice> DaumDevices = new ArrayList<DaumDevice>();
	
	public void addDaumDevice(DaumDevice daumDevice) {
		this.DaumDevices.add(daumDevice);
	}
	
	public Long getId() {
		return id;
	}
	
	public Collection<DaumDevice> getDaumDevices() {
		return DaumDevices;
	}
}