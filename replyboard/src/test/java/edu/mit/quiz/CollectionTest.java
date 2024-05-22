package edu.mit.quiz;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class CollectionTest {

	@Test
	public void testList() {
		//list 순서가 있는(인덱스) 객체 집합
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		for(String temp : list) {
			log.info("출력 " + temp);
		}
	}
	
	@Test
	public void testSet() {
		//set 순서가 없고 중복을 허용하지 않는 객체의 집합
		Set<String> set = new HashSet<>();
		set.add("aaa");
		set.add("aaa");
		set.add("bbb");
		for(String temp : set) {
			log.info("출력 " + temp);
		}		
	}
	
	@Test
	public void testMap() {
		//맵은 키와 값(객체)으로 이루어진 데이터 집합
		Map<String, String> map = new HashMap<>();
		map.put("a", "aaa");
		map.put("b", "bbb");
		map.put("c", "ccc");
		log.info(map.get("a"));
		for( String key  : map.keySet()) {
			log.info("모든키 " + key);
			log.info("모든데이터"+map.get(key));
		}
	}
	
	@Test
	public void testSplit() {
		String a = "abcdef";
		for(String temp : a.split("")) {
			log.info(temp);
		}
	}
	
	
}


