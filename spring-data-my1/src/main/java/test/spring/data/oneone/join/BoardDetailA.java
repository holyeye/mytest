package test.spring.data.oneone.join;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class BoardDetailA {

	@Id @GeneratedValue
	private Long id;

	@Column(length=4000)
	private String content;
	
	@OneToOne
	@JoinColumn
	private BoardA boardA;
	
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

	public void setBoardA(BoardA boardA) {
		this.boardA = boardA;
	}
	public BoardA getBoardA() {
		return boardA;
	}

}
