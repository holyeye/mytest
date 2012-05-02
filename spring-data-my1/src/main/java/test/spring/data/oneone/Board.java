package test.spring.data.oneone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
//@GenericGenerator(name="Board", strategy="foreign", parameters=@Parameter(name="property", value="boardDetail"))
public class Board implements Serializable {

	@Id @GeneratedValue//(generator="Board")
	private Long id;

	private String title;

//	@PrimaryKeyJoinColumn
//	BoardDetail boardDetail;

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

//	public BoardDetail getBoardDetail() {
//		return boardDetail;
//	}
//
//	public void setBoardDetail(BoardDetail boardDetail) {
//		this.boardDetail = boardDetail;
//	}

}
