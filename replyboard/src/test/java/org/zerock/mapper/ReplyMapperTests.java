package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Autowired
	ReplyMapper mapper;
	
	@Test
	public void testInsert() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(1L);
		vo.setReply("리플내용 juit 으로");
		vo.setReplyer("junit");
		mapper.insert(vo);
	}
	
	@Test
	public void all() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(1L);
		vo.setReply("수정1 수정1");
		//수정
		log.info("수정확인 1 나오면 정상: "+mapper.update(vo));
		//글 한 개 보고
		log.info("1번글 보기: "+mapper.get(1L));
		//삭제
		log.info("1번글 삭제 1 나오면 정상: "+mapper.delete(1L));
		//전체보고
		log.info("전체 리스트 보기: "+mapper.getList(1L));
	}
	
	@Test
	public void testUpdate() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(1L);
		vo.setReply("수정1 수정1");
		log.info("수정확인 1 나오면 정상: "+mapper.update(vo));
	}
	
	@Test
	public void testGet() {
		log.info("1번글 보기: "+mapper.get(1L));
	}
	
	@Test
	public void testDelete() {
		log.info("1번글 삭제 1 나오면 정상: "+mapper.delete(1L));
	}
	
	@Test
	public void testGetList() {
		log.info("전체 리스트 보기: "+mapper.getList(1L));
	}
	
	@Test
	public void testGetListWithPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(2);
		cri.setAmount(10);
		log.info("리플보자: "+mapper.getListWithPaging(1L, cri));
	}
	
}












