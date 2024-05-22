package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static { //static block : new를 통해서 객체가 생성될 때 최초로 한 번만 수행되는 구분
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			
		}
	}
	
	
	@Test
	public void testConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "book_ex", "book_ex");
			
			log.info("연결성공 : "+conn);
			
		} catch (Exception e) {
			//e.printStackTrace();
			log.info("연결실패");
			fail(e.getMessage()); //fail은 junit에서 테스트 실패가 되도록하는 메소드
		}
	}
}
