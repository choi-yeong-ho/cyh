package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {
	
	private ReplyMapper mapper;

	@Override
	public boolean register(ReplyVO vo) {
		log.info("리플 등록 서비스 호출 등록할 리플은: "+vo);
		return mapper.insert(vo) == 1;
	}

	@Override
	public boolean modify(ReplyVO vo) {
		log.info("리플 수정 서비스 호출 수정할 리플은: "+vo);
		return mapper.update(vo) == 1;
	}

	@Override
	public boolean remove(Long rno) {
		log.info("리플 삭제 서비스 호출 삭제할 리플은: "+rno);
		return mapper.delete(rno) == 1;
	}

	@Override
	public List<ReplyVO> getList(Long bno) {
		log.info(bno+ "번 게시글 리플 전체 호출 서비스");
		return mapper.getList(bno);
	}

	@Override
	public List<ReplyVO> getListWithPaging(Long bno, Criteria cri) {
		log.info(bno+ "번 게시글 리플 전체 호출 서비스(페이징)");
		return mapper.getListWithPaging(bno, cri);
	}

	@Override
	public int getCount(Long bno) {
		log.info(bno+ "번 게시글 리플 전체 리플 수 호출 서비스");
		return mapper.getCount(bno);
	}

}

