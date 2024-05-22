package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;


//컨트롤러를 테스트하기 위해서는 어노테이션 1개 추가, 설정 1개 추가 p214
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTests {

	@Autowired
	private WebApplicationContext ctx; //mockMvc 객체를 만들기 위해서 필요한 객체
	private MockMvc mockMvc;   //브라우저 처럼 테스트하기 위해서
	
	@Before //junit으로 테스트전 항상 먼저 실행할 메소드
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		log.info("리스트보기 url이 잘 동작되나 페이지로 보내는 값은: "+
		mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
		.andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testRegister() throws Exception {
		log.info("수행후 가야할 페이지는 : "+
		mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "컨트롤러 테스트")
				.param("content", "junit를 이용해서 컨트롤러를 테스트중입니다.")
				.param("writer", "작성자 테스트"))
		.andReturn().getModelAndView().getViewName());
	}

	@Test
	public void testGet() throws Exception {
		log.info("글 하나 보기: "+
		mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("bno", "5"))
		.andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testRemove() throws Exception {
		log.info("수행후 가야할 페이지는 : "+
		mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "14"))
		.andReturn().getModelAndView().getViewName());
	}

	@Test
	public void testModify() throws Exception {
		log.info("수행후 가야할 페이지는 : "+
		mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "15")
				.param("title", "이걸로 수정2 title")
				.param("content", "이걸로 수정2 content")
				.param("writer", "이걸로 수정2 writer"))
		.andReturn().getModelAndView().getViewName());
	}
	
	@Test
	public void testUrlMove() throws Exception {
		log.info("열어야할 페이지1: "+
		mockMvc.perform(MockMvcRequestBuilders.get("/board/register"))
		.andReturn().getModelAndView().getModelMap());

		log.info("열어야할 페이지2: "+
		mockMvc.perform(MockMvcRequestBuilders.get("/board/remove"))
		.andReturn().getModelAndView().getModelMap());		

		log.info("열어야할 페이지3: "+
		mockMvc.perform(MockMvcRequestBuilders.get("/board/modify"))
		.andReturn().getModelAndView().getModelMap());		
	}

}
