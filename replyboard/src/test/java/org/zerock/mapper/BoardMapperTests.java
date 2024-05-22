package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	BoardMapper mapper;
	
	@Test
	public void testGetList() {
		Criteria cri = new Criteria(1,5,"T","bb");
		//List<BoardVO> list = mapper.getList();
		mapper.getList(cri).forEach(x->log.info(x));
	}
	
	@Test
	public void testRead() {
		log.info("상세보기: "+mapper.read(3L));
	}
	
	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("junit으로 테스트3");
		vo.setContent("성공인가요???");
		vo.setWriter("테스트3");
		mapper.insert(vo);
	}
	
	@Test
	public void testDelete() {
		mapper.delete(2L);
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		vo.setTitle("aaaaa");
		vo.setContent("bbbbb");
		vo.setWriter("ccccc");
		vo.setBno(4L);
		log.info("수정글 개수 : "+mapper.update(vo));
	}
	
	@Test
	public void testCount() {
		Criteria cri = new Criteria();
		log.info("전체 글의 개수 : "+mapper.count(cri));
		Criteria cri2 = new Criteria(1,10,"TC","aa");
		log.info("검색수 개수:"+mapper.count(cri2));		
	}
	
	@Test
	public void testLastBoard() {
		log.info("마지막 글 : "+mapper.lastBoard());
	}
	
	@Test
	public void testRank() {
		mapper.rank().forEach(x->log.info(x));
	}
	
	@Test
	public void testTwoBoard() {
		mapper.twoBoard(3L, 4L).forEach(x->log.info(x));
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO vo = new BoardVO();
		vo.setTitle("junit으로 테스트");
		vo.setContent("성공인가요?");
		vo.setWriter("테스트1");
		log.info("삽입할 vo내용"+vo);
		mapper.insertSelectKey(vo);
		log.info("삽입후 vo내용"+vo);
	}
	
	@Test
	public void testUpdateViews() {
		mapper.updateViews(202L);
	}
	
	@Test
	public void testUpdateGood() {
		mapper.updateGood(2883591L);
	}
	
	
}
