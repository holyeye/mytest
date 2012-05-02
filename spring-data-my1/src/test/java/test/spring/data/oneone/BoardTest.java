package test.spring.data.oneone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import test.spring.data.repository.BoardDetailRepository;
import test.spring.data.repository.BoardRepository;
import test.spring.data.repository.ListingRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:auditing-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class BoardTest {

	@Autowired BoardRepository boardRepository;
	@Autowired BoardDetailRepository boardDetailRepository;
	@Autowired ListingRepository listingRepository;
	@PersistenceContext EntityManager em;
	
	@Autowired ListingRepository repository;
	
	@Test
	public void test() {
		
		Board board = new Board();
		board.setTitle("hello");
		BoardDetail boardDetail = new BoardDetail();
		boardDetail.setContent("hello content!!!");
		board.setBoardDetail(boardDetail);
		boardRepository.save(board);
		
		
		em.flush();
		em.clear();
		
		boardRepository.findOne(board.getId());
		
	}
	

}
