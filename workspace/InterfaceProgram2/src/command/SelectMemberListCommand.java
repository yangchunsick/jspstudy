package command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.MemberDao;
import dto.Member;

public class SelectMemberListCommand implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		List<Member> list = MemberDao.getInstance().selectMemberList();
		
		JSONArray members = new JSONArray(list);	// list를 JSON Array에 members로 저장 
		
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(members);	// success function() 괄호 안으로 가는 거임
		out.close();
	}

}
