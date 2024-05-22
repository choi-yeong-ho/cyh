package edu.mit.quiz;

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
public class QuizControllerTests {

	@Autowired
	private WebApplicationContext ctx; //mockMvc 객체를 만들기 위해서 필요한 객체
	private MockMvc mockMvc;   //브라우저 처럼 테스트하기 위해서
	
	@Before //junit으로 테스트전 항상 먼저 실행할 메소드
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testQuiz1() throws Exception {
		log.info("quiz1 페이지로 보내는 값은: "+
		mockMvc.perform(MockMvcRequestBuilders.get("/quiz1"))
		.andReturn().getModelAndView().getModelMap());
	}
	
}
