package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.DataSourceTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void test1() {
		Criteria cri = new Criteria();
		log.info(service.getList(cri)); //목록보기
		
		BoardVO vo = new BoardVO();
		vo.setTitle("서비스 테스트");
		vo.setContent("성공인가요???");
		vo.setWriter("테스트3");
		service.register(vo); //등록
	}
	
	@Test
	public void test2() {
		log.info("글 하나 가져오기? "+service.get(4L)); //상세보기
		BoardVO vo = new BoardVO();
		vo.setTitle("수정 서비스 테스트");
		vo.setContent("수정 성공인가요??");
		vo.setWriter("수정 테스트2");
		vo.setBno(4L);
		log.info("수정성공? "+service.modify(vo)); //수정
		log.info("삭제성공? "+service.remove(4L)); //삭제
	}
	
	@Test
	public void testQuiz1() {
		log.info("모두 더한 값은 : "+service.quiz1(2));
	}
	
	@Test
	public void testDice() {
		log.info("주사위 : "+service.dice());
	}
	
	@Test
	public void testPercent() {
		log.info("점유 퍼센트 : "+service.percent());
	}
	
	@Test
	public void testTodayList() {
		service.todayList().forEach(x->log.info(x));
	}

}
