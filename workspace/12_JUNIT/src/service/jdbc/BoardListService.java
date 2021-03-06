package service.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.jdbc.BoardDAO;
import dto.Board;

public class BoardListService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 목록을 가져옴
		List<Board> list = BoardDAO.getInstance().selectBoardList();
		
		System.out.println(list.toString());
				
		// JSON 데이터로 변환함
		// 1. Board : JSONObject
		// 2. JSONArray : listt<Board>	
		// JSONArray arr = new JSONArray(list);
		
		// ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ JSON라이브러리 JSONArray가 list를 제대로 가져오지 못 해
		// 비어 있는 JSONArray에 JSONObject arr.put(obj)해서 강제로 넣은 거임
		JSONArray arr = new JSONArray();
		for(Board board : list) {
			JSONObject obj = new JSONObject();
			obj.put("bNo", board.getbNo());
			obj.put("writer", board.getWriter());
			obj.put("content", board.getContent());
			obj.put("bDate", board.getbDate());
			arr.put(obj);
		}
		
		// JSON 데이터로 변환된 목록 반화
		response.setContentType("applecation/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(arr);	// index.jsp의 sucsess : function(arr) {}로 반환됨.
		out.close();
		
		
	}

}
