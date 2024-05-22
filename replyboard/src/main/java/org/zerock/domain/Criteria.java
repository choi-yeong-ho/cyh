package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Criteria {
	//페이지번호
	private int pageNum=1;
	//한페이지에 보여줄 개수
	private int amount=10;

	//검색종류(제목-T,내용-C,작성자-W 조합)
	String type;   //T,C,W, TC,TW,CW, TCW
	//검색어
	String keyword;
	
	//검색종류 문자를 한 글자씩 분해하기 위한 메소드
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split(""); //한 글자씩 자름
	}
	
}
