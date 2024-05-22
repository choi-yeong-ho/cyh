package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	//한행쓰기(리플작성)
	int insert(ReplyVO vo);
	//한행수정(리플수정)
	int update(ReplyVO vo);
	//한행삭제(리플삭제)
	int delete(Long rno);
	//한 게시글에 대한 리플목록 가져오기
	List<ReplyVO> getList(Long bno);
	//한 게시글에 대한 리플 수 가져오기
	int getCount(Long bno);
	//한행읽기(리플읽기)
	ReplyVO get(Long rno);
	
	//리플을 페이지 처리 한다면(Mybatis에서 두 개 이상의 파라미터를 전달시 @Param을 이용해서 지정)
	List<ReplyVO> getListWithPaging(@Param("bno") Long bno, @Param("cri") Criteria cri);
}
