package test.spring.data.oneone.join;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BoardB implements Serializable {

	@Id @GeneratedValue
	private Long id;

	private String title;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	BoardDetailB boardDetailB;

	public void setBoardDetailB(BoardDetailB boardDetail) {
		this.boardDetailB = boardDetail;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BoardDetailB getBoardDetailB() {
		return boardDetailB;
	}


}
