package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	//리플 작성
	boolean register(ReplyVO vo);
	//리플 수정
	boolean modify(ReplyVO vo);
	//리플 삭제
	boolean remove(Long rno);
	//게시글 리플보기
	List<ReplyVO> getList(Long bno);
	//한 게시글에 대한 리플 수 가져오기
	int getCount(Long bno);	
	//게시글 리플보기(페이징)
	List<ReplyVO> getListWithPaging(Long bno, Criteria cri);	
}
