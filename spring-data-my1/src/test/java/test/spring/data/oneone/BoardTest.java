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

import test.spring.data.oneone.join.BoardA;
import test.spring.data.oneone.join.BoardB;
import test.spring.data.oneone.join.BoardDetailA;
import test.spring.data.oneone.join.BoardDetailB;
import test.spring.data.oneone.table.Item;
import test.spring.data.oneone.table.Shipment;
import test.spring.data.repository.BoardARepository;
import test.spring.data.repository.BoardBRepository;
import test.spring.data.repository.BoardDetailRepository;
import test.spring.data.repository.BoardRepository;
import test.spring.data.repository.ListingRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:auditing-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class BoardTest {

	@Autowired BoardRepository boardRepository;
	@Autowired BoardARepository boardARepository;
	@Autowired BoardBRepository boardBRepository;
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
	
	/**
	 * 1:1조인 양방향
	 */
	@Test
	public void testA() {
		
		BoardA board = new BoardA();
		board.setTitle("hello");
		BoardDetailA boardDetail = new BoardDetailA();
		boardDetail.setContent("hello content!!!");
		board.setBoardDetailA(boardDetail);
		boardARepository.save(board);
		
		
		em.flush();
		em.clear();
		
		boardARepository.findOne(board.getId());
		
	}
	
	/**
	 * 1:1조인 단방향
	 */
	@Test
	public void testB() {
		
		BoardB board = new BoardB();
		board.setTitle("hello");
		BoardDetailB boardDetail = new BoardDetailB();
		boardDetail.setContent("hello content!!!");
//		board.setBoardDetailB(boardDetail);
		boardBRepository.save(board);
		
		
		em.flush();
		em.clear();
		
		boardARepository.findOne(board.getId());
		
	}
	
	/**
	 * 1:1 테이블 사용, 양방향
	 */
	@Test
	public void testC() {
		
		Item item = new Item();
		item.setTitle("hello");
		Shipment shipment = new Shipment();
		item.setShipment(shipment);
		em.persist(item);
		
		em.flush();
		em.clear();
		
		em.find(Item.class, item.getId());
		
	}
	

}
