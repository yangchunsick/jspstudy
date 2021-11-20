package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;

public class MemberDeleteService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		Optional<String> optNo = Optional.ofNullable(request.getParameter("no"));
		int result = MemberDAO.getInstance().deleteMember(no);
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("confirm('탈퇴 하시겠습니까 ?')");
			out.println("location.href='/ServerProgram/deletesuccess.jsp'");
			out.println("</script>");
			out.close();
		}else {
			out.println("<script>");
			out.println("alert('삭제 실패')");
			out.println("history.back()'");
			out.println("</script>");
			out.close();
		}
		
		
		
		
		
		
		return null;
	}

}
