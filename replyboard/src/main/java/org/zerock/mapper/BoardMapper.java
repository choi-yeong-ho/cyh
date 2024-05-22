package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.RankVO;

public interface BoardMapper {
	//글 등록(한행 추가)-등록된 글번호 알수 없음
	int insert(BoardVO vo);
	
	//글등록 등록된 글번호를 알수있게
	int insertSelectKey(BoardVO vo);

	//글 조회(한행 보기)
	BoardVO read(Long bno);
		
	//글 삭제(한행 삭제)
	int delete(Long bno);
	
	//글 수정(한행 수정)
	int update(BoardVO vo);
	
	//조회수 올리기
	int updateViews(Long bno);
	
	//좋아요 수 올리기
	int updateGood(Long bno);
	
	//싫어요 수 올리기
	int updateHate(Long bno);
	
	//글 목록보기
	//@Select("select * from tbl_board")
	List<BoardVO> getList(Criteria cri); //페이지
	
	//글 검색 - 나중에
	
	//원하는 두 개의 글을 알려주는 메소드
	//!!!매개변수 두개 이상일 때 바로 매핑이 안되고 수동으로 매핑해줘야 한다.
	List<BoardVO> twoBoard(@Param("aaa")Long bno1, @Param("bbb")Long bno2);
	
	
	//퀴즈
	//1.전체 글의 개수를 알려주는 메소드 count
	long count(Criteria cri);
	
	//2.가장 마지막에 작성된 글 보기
	BoardVO lastBoard();
	
	//3.작성자별 글 개수(글 개수가 많은 사람부터) - (옵션>1등 부터 3등 까지만)
	List<RankVO> rank();
	
	//4.당일 쓴 게시물 목록 보기
	List<BoardVO> todayList();

	//오늘 쓴 글 개수
	long todayCount();
	
}
