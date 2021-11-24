package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.mybatis.BoardDAO;
import dto.Board;

class BoardTestCase {
	
	@BeforeEach
	void 선행작업() {
		
		Board board = new Board();
		board.setbNo("10001");
		board.setWriter("ALICE");
		board.setContent("만나서 반갑습니다.");
		
		int result = BoardDAO.getInstance().insertBoard(board);
		assertEquals(1, result,"등록 오류");
	}
	
	@AfterEach
	void 후처리작업() {
		int result = BoardDAO.getInstance().deleteBoard("10001");
		assertEquals(1, result, "알 수 없는 오류");
	}

	// @Test	// 이 메소드는 JUnit 테스트 할 때 실행되는 메소드이다.
	void 게시글_목록_가져오기_테스트() { // 테스트 코드 메소드 명은 "한글"로 해도 된다.
		// 게시글 목록 가져와서 현재 개수 맞는지 점검
		// assertEquals("기대한 값", "실제 값", [에러 메세지]);
		assertEquals(2, BoardDAO.getInstance().selectBoardList().size());
	}

	@Test
	void 게시글_가져오기_테스트() {
		// 게시글 10000인 게시글을 가져와서 null 유무 점검하기
		assertNotNull(BoardDAO.getInstance().selectBoardBybNo("10001"));

	}
	
}