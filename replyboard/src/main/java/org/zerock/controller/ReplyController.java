package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.BoardService;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/replies")
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService service;
	private BoardService boardService;

	//리플등록 API
	@PostMapping(value="/new",
			consumes="application/json", //보내는 데이터 타입과 동일한지 체크. : 미일치 415 에러
										 //consumes가 없고 내용이 다르면 400(잘못된요청)에러
			produces="text/plain; charset=UTF-8")
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		log.info("리플작성 작성내용은: "+vo);
		return service.register(vo)==true ?
				new ResponseEntity<>("sucess",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		//참일 때 : //거짓일 때
		
		//성공시에는 sucess 문자 전송, 실패시에는 아무것도 보내지 않음
		//추가로 성공시에는 200 상태, 실패시에는 418(나는차주전자) 상태를 보내자
	}
	
	//리플수정 API ex> replies/65
	@RequestMapping(value="/{rno}",
			method= {RequestMethod.PUT, RequestMethod.PATCH},
			consumes="application/json", produces="text/plain; charset=UTF-8")
	public ResponseEntity<String> modify(@PathVariable("rno") Long rno, @RequestBody ReplyVO vo) {
		log.info("리플을 수정합니다. 수정할 리플번호는 "+rno+" 내용은 "+vo);
		System.out.println("리플을 수정합니다. 수정할 리플번호는 "+rno+" 내용은 "+vo);
		vo.setRno(rno);
		
		return service.modify(vo)==true ?
				new ResponseEntity<>("sucess",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
	}
	
	//리플삭제 API
	@RequestMapping(value="/{rno}",
			method= RequestMethod.DELETE,
			produces="text/plain; charset=UTF-8")
	public ResponseEntity<String> delete(@PathVariable("rno") Long rno) {
		log.info("리플을 삭제합니다. 삭제할 리플번호는 "+rno);
		
		return service.remove(rno)==true ?
				new ResponseEntity<>("sucess",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
	}
	
	//게시글에 대한 리플목록보기 API  ex> replies/bno/2
	@RequestMapping(value="/bno/{bno}",
			method= RequestMethod.GET ,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") Long bno, Model model, Criteria cri) {
		//model.addAttribute("list", boardService.getList(cri));
		//log.info("보여줘야할 게시글 정보 "+boardService.getList(cri));		
		log.info(bno+"번 게시글에 대한 리플을 요청합니다.");
		log.info("log.info:cri = "+ cri);
		PageDTO dto = new PageDTO(cri, service.getCount(bno));
		model.addAttribute("pageMaker", dto);
		log.info("보내는 페이지 정보들 "+ dto);
		//페이지바를 만들기 위한 추가정보 추가		
		
		//없는 게시물에 대한 요청일 경우 상태코드는 418 정상일 때는 200 으로 전송
		
		//1.게시물이 존재하는 지 확인
		log.info("없는 게시물은? "+boardService.get(bno));
		if(boardService.get(bno)!=null) {
			//log.info(dto);
			//return new ResponseEntity<>(service.getList(bno), HttpStatus.OK);
			return new ResponseEntity<>(service.getListWithPaging(bno, cri), HttpStatus.OK);			
		} else {
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
	}
	
 /*
	//게시글에 대한 리플목록보기 API  ex> replies/bno/2
	@RequestMapping(value="/bno/{bno}",
			method= RequestMethod.GET ,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReplyVO>> listPaging(@PathVariable("bno") Long bno, Model model, Criteria cri) {
		log.info(bno+"번 게시글에 대한 리플을 요청합니다.");
		
		//없는 게시물에 대한 요청일 경우 상태코드는 418 정상일 때는 200 으로 전송
		
		//1.게시물이 존재하는 지 확인
		log.info("없는 게시물은? "+boardService.get(bno));
		if(boardService.get(bno)!=null) {
			return new ResponseEntity<>(service.getListWithPaging(bno, cri), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
	}
*/
	
}
