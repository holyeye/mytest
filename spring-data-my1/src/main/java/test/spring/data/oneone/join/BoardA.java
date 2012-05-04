package test.spring.data.oneone.join;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BoardA implements Serializable {

	@Id @GeneratedValue
	private Long id;

	private String title;

	@OneToOne(cascade=CascadeType.ALL, mappedBy="boardA")
	BoardDetailA boardDetailA;

	public void setBoardDetailA(BoardDetailA boardDetail) {
		this.boardDetailA = boardDetail;
		boardDetail.setBoardA(this);
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

	public BoardDetailA getBoardDetail() {
		return boardDetailA;
	}


}
