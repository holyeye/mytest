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
public class AndroidUser {

	@Id @GeneratedValue
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="androidUser")
	Collection<AndroidDevice> androidDevices = new ArrayList<AndroidDevice>();
	
	public void addAndroidDevice(AndroidDevice androidDevice) {
		androidDevice.setAndroidUser(this);
		this.androidDevices.add(androidDevice);
	}
	
	public Long getId() {
		return id;
	}
}