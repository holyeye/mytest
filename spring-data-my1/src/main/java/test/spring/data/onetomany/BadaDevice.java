package test.spring.data.onetomany;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class BadaDevice {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional=false)
	@JoinTable(name = "BadaUser_BadaDevice"
				,joinColumns = { @JoinColumn(name = "badaDevice_id") }
				,inverseJoinColumns = @JoinColumn(name = "badaUser_id"))
	BadaUser badaUser;

	public void setBadaUser(BadaUser badaUser) {
		this.badaUser = badaUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BadaUser getBadaUser() {
		return badaUser;
	}
	
}
