package org.zerock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/boardapi")
@AllArgsConstructor
public class BoardControllerAPI {
	
	private BoardService service;

	//게시물 등록
	@PostMapping(value="/new",
			consumes="application/json", //보내는 데이터 타입과 동일한지 체크. : 미일치 415 에러
										 //consumes가 없고 내용이 다르면 400(잘못된요청)에러
			produces="text/plain; charset=UTF-8")
	public ResponseEntity<String> create(@RequestBody BoardVO board) {
		log.info("게시물 등록 작성내용은: "+board);
		return service.register(board) == 1 ?
				new ResponseEntity<>("sucess",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		//참일 때 : //거짓일 때
		
		//성공시에는 sucess 문자 전송, 실패시에는 아무것도 보내지 않음
		//추가로 성공시에는 200 상태, 실패시에는 418(나는차주전자) 상태를 보내자
	}
	
	//게시물 수정
	//... 다음에...
	
	//게시물 삭제

	
	// http://localhost:8080/boardapi/320
	//게시물 한행보기
	@RequestMapping(value="/{bno}",
			method= RequestMethod.GET ,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BoardVO> get(@PathVariable("bno") Long bno) {
		log.info(bno+"번 게시글 보기 ");
		
		//없는 게시물에 대한 요청일 경우 상태코드는 418 정상일 때는 200 으로 전송
		
		//1.게시물이 존재하는 지 확인
		log.info("없는 게시물은? "+service.get(bno));
		if(service.get(bno)!=null) {
			return new ResponseEntity<>(service.get(bno), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
	}	
	
	//게시물 전체목록보기
	
}
