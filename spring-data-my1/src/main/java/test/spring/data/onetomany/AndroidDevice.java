package test.spring.data.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AndroidDevice {

	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn
	AndroidUser androidUser;
	
	public void setAndroidUser(AndroidUser androidUser) {
		this.androidUser = androidUser;
	}
}
