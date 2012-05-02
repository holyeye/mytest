package test.spring.data.oneone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class BoardDetail {

	@Id @GeneratedValue(generator="foreignGenerator")
	@GenericGenerator(name="foreignGenerator", strategy="foreign", parameters=@Parameter(name="property", value="board"))
	private Long id;

	@Column(length=4000)
	private String content;
	
	
	@OneToOne(mappedBy="boardDetail")
	@PrimaryKeyJoinColumn
	private Board board;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	public Board getBoard() {
		return board;
	}
	
	
}
