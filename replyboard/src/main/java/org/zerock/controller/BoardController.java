package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	//전체목록
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		model.addAttribute("list", service.getList(cri));
		log.info("보여줘야할 게시글 정보 "+service.getList(cri));
		//model.addAttribute("count", service.count());
		PageDTO dto = new PageDTO(cri,service.count(cri));
		model.addAttribute("pageMaker", dto);
		log.info("보내는 페이지 정보들 "+ dto);
		//페이지바를 만들기 위한 추가정보 추가
		
		// -> /board/list.jsp
	}
	
	//오늘쓴 글 목록
	@GetMapping("/today")
	public void today(Model model) {
		model.addAttribute("todaylist", service.todayList());
		model.addAttribute("todaycount", service.todayCount() );		
		// -> /board/today.jsp
	}
	
	//작성자별 게시글 수 : 도넛 그래프 랭크 찍기 위한 처리
	@GetMapping("/rank")
	public void rank(Model model) {
		model.addAttribute("data", service.rank());
		// -> /board/rank.jsp
	}
	
	//등록처리
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		service.register(board);
		//몇번글이 등록되었습니다 보내기 한번만
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	//등록을 위한 입력 화면
	@GetMapping({"/register"})
	public void urlMove() {
		
	}
	
	//조회하기 위한 화면
	@GetMapping({"/get"})
	public void get(Long bno, Criteria cri, Model model) {
		model.addAttribute("board", service.updateGet(bno));
		model.addAttribute(cri);
	}
	
	//수정하기 위한 화면
	@GetMapping({"/modify"})
	public void modify(Long bno, Criteria cri, Model model) {
		model.addAttribute("board", service.get(bno));
		model.addAttribute(cri);
	}
	
	//좋아요 처리..
	@PostMapping("/good")
	public String good(Long bno, Criteria cri) {
		boolean good = service.updateGood(bno);
		log.info("좋아요 처리 결과 : "+good);
		return "redirect:/board/list?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount()+"&type="+cri.getType()+"&keyword="+cri.getKeyword();
	}
	
	//싫어요 처리..
	@PostMapping("/hate")
	public String hate(Long bno, Criteria cri) {
		boolean hate = service.updateHate(bno);
		log.info("싫어요 처리 결과 : "+hate);
		return "redirect:/board/list?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount()+"&type="+cri.getType()+"&keyword="+cri.getKeyword();
	}

	//삭제처리
	@PostMapping("/remove")
	public String remove(Long bno, Criteria cri) {
		service.remove(bno);
		return "redirect:/board/list?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount()+"&type="+cri.getType()+"&keyword="+cri.getKeyword();
	}

	//수정처리
	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri) {
		service.modify(board);
		return "redirect:/board/list?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount();
	}

	
}
