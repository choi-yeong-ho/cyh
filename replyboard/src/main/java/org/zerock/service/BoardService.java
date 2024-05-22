package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.RankVO;

public interface BoardService {
	//서비스(비지니스 로직) - 즉, 사용자 관점에서 단위
	//1.게시글 등록
	int register(BoardVO vo);
	
	int insertSelectKey(BoardVO vo);
	
	//2.게시글 읽기(조회수)
	BoardVO updateGet(Long bno);
	
	//2.게시글 읽기
	BoardVO get(Long bno);
	
	//3.게시글 수정
	boolean modify(BoardVO vo);

	//좋아요 수정
	boolean updateGood(Long bno);
	
	//싫어요 수정
	boolean updateHate(Long bno);
	
	//4.게시글 삭제
	boolean remove(Long bno);
	
	//5.게시글 목록보기
	List<BoardVO> getList(Criteria cri);
	
	//6.전체글 개수
	long count(Criteria cri);
	
	
	//퀴즈1. 서비스 하나 만들어 보고 이를 테스트 하시오.
	//이 서비스는 사용자가 숫자 하나를 알려주면 입력한 숫자 부터 게시글의 갯수 사이의 모든
	//숫자를 더해서 알려주는 서비스 입니다.
	//예> 입력 1, 게시글 갯수는 10 이며 즉, 1-10까지 모두 더한값은 55 리턴
	
	int quiz1(int num1);
	
	//퀴즈2
	//주사위 서비스 (요청하면 1~6 사이의 값 중 하나를 돌려주기)를 만들고 테스트 하시오.
	int dice();
	
	//퀴즈3
	//주의! 있는 mapper만 활용해서 구현하시오.(전체글개수, 사용자별 글개수 순위)
	//가장 많이 글을 쓴 사용자가 전체 게시글에 대한 %를 알려주는 서비스
	//예> 전체 게시글 10, aaa 5 -> 응닶 50
	int percent();
	
	//퀴즈4
	/* 당일에 쓴 게시물만 최신글 순서대로 가져올 수 있는 서비스를 구현하시오.
	 * 필요시 mapper도 구현(필요할 듯 ㅋㅋ)
	*/
	List<BoardVO> todayList();

	//오늘 쓴 글 개수
	long todayCount();

	//작성자별 글 개수(글 개수가 많은 사람부터) - (옵션>1등 부터 3등 까지만)
	List<RankVO> rank();
	
}
