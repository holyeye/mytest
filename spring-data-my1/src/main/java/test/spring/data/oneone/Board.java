package test.spring.data.oneone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Board implements Serializable {

	@Id @GeneratedValue
	private Long id;

	private String title;

	@OneToOne(cascade=CascadeType.ALL, mappedBy="board")
	BoardDetail boardDetail;

	public void setBoardDetail(BoardDetail boardDetail) {
		this.boardDetail = boardDetail;
		boardDetail.setBoard(this);
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

	public BoardDetail getBoardDetail() {
		return boardDetail;
	}


}
