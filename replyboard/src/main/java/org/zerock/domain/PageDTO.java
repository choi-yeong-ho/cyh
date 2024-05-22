package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	//페이지에 관련된 모든 정보
	private Criteria cri; //기본페이지 정보(페이지번호, 내용개수(뷰페이지수))
	
	//* 페이지바 정보
	private int startPage, endPage; //페이지바 시작 및 끝 숫자
	private boolean prev, next;     //다음페이지 및 이전페이지로 가기
	
	private long total; //마지막 페이지 계산을 위한 전체 글개수
	
	public PageDTO(Criteria cri, long total) { //페이지번호와 내용개수 그리고 전체글개수를 넣어서 페이지 만들기
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)Math.ceil(cri.getPageNum() / 10.0) * 10;
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)Math.ceil(total*1.0 / cri.getAmount());
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = (startPage != 1); //(startPage > 1) //페이지바가 1로 시작하지 않는다면 prev true
		this.next = (this.endPage != realEnd); //(this.endPage < realEnd) //마지막페이지가 있는 페이지바라면 next가 false
	}
	
}
