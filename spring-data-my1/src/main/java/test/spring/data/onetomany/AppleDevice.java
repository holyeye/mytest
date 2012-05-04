package test.spring.data.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AppleDevice {

	@Id @GeneratedValue
	private Long id;
	
}
