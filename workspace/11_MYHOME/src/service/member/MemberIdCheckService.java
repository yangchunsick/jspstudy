package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.ModelAndView;
import dao.MemberDao;
import dto.Member;

public class MemberIdCheckService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 가입하고자 하는 ID
		String id = request.getParameter("id");
		
		Member member = new Member();
		member.setId(id);
		
		// 가입하고자 하는 ID와 기존 회원의 ID와 동일한지 확인
		Member user = MemberDao.getInstance().selectMember(member);
		
		// 반환할 JSON 데이터
		// 가입하려는 아이디를 가진 회원이 없으면 (가입 가능)
		// {"result" : true } 데이터를 ajax로 반환함		
		JSONObject obj = new JSONObject();
		obj.put("result", user == null);
		
		// JSON 데이터 반환
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();		
		
		return null;
	}

}
