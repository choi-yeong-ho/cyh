package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.RankVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Service
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper; //생성자 주입

	@Override
	public int register(BoardVO vo) {
		log.info("글 등록 서비스 등록할 내용은: "+vo);
		//mapper.insert(vo);
		return mapper.insertSelectKey(vo); //글번호 알아오기 위해서
	}

	@Override
	public BoardVO updateGet(Long bno) {
		mapper.updateViews(bno); //조회수 업데이트
		return mapper.read(bno);
	}
	
	@Override
	public BoardVO get(Long bno) {
		log.info("상세보기 서비스 요청글번호는: "+bno);
		//mapper.updateViews(bno); //조회수 업데이트
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO vo) {
		log.info("수정 서비스 수정할 내용은: "+vo);
		//return mapper.update(vo)==1 ? true : false;
		return mapper.update(vo)==1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("삭제 서비스 삭제할 번호는: "+bno);
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("목록보기 서비스");
		return mapper.getList(cri);
	}

	@Override
	public int quiz1(int num1) {
		Long num2 = mapper.count(new Criteria());
		int sum = 0;
		for(int i=num1; i<=num2; i++) {
			sum += i;
		}
		return sum;
	}

	@Override
	public int dice() {
		int num =(int)(Math.random()*6)+1;
		return num;
	}

	@Override
	public int percent() {
		//전체글개수
		//Long count = mapper.count();
		
		//가장 많이 쓴 작성자의 글개수
		//List<RankVO> list = mapper.rank();
		//RankVO vo = list.get(0);
		//int num = vo.getCn();
		//int num = mapper.rank().get(0).getCn();

		//return (int)(num*100/count);
		return (int)(mapper.rank().get(0).getCn()*100/mapper.count(new Criteria()));
	}

	@Override
	public List<BoardVO> todayList() {
		return mapper.todayList();
	}

	@Override
	public long count(Criteria cri) {
		return mapper.count(cri);
	}

	@Override
	public long todayCount() {
		return mapper.todayCount();
	}

	@Override
	public List<RankVO> rank() {
		return mapper.rank();
	}

	@Override
	public int insertSelectKey(BoardVO vo) {
		log.info("글 등록 서비스 등록할 내용은: "+vo);
		return mapper.insert(vo);
	}

	@Override
	public boolean updateGood(Long bno) {
		log.info("좋아요 등록할 글번호: "+bno);
		return mapper.updateGood(bno)==1;
	}

	@Override
	public boolean updateHate(Long bno) {
		log.info("싫어요 등록할 글번호: "+bno);
		return mapper.updateHate(bno)==1;
	}

}
