package test.spring.data.oneone;

import java.io.Serializable;

import javax.persistence.Id;

public class BoardPK implements Serializable{
	
	@Id
	private Long id1;
	
	@Id
	private Long id2;
	
	
}
