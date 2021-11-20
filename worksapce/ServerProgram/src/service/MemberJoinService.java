package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class MemberJoinService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id	= request.getParameter("id");
		String name = request.getParameter("name");	

		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setName(name);
	
		int result = MemberDAO.getInstance().insertMember(member);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("location.href='/ServerProgram/views/loginsuccess.jsp'");
			out.println("</script>");
			out.close();
		}else {
			out.println("<script>");
			out.println("alert('등록 실패')");
			out.println("history.back()'");
			out.println("</script>");
			out.close();
		}
		
		return null;
	}

}