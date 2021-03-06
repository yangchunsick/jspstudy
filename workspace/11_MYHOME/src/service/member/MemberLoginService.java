
package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDao;
import dto.Member;

public class MemberLoginService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// DB에 보내기 위해 만듬
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		// ID/PW가 일치한 조회
		Member loginUser = MemberDao.getInstance().selectMember(member);
		
		// null이 아니면 이니까 DB에 회원 정보가 있는 거임
		if(loginUser != null) {
			
			/*★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★*/
			// 회원 정보를 session에 loginUser로 저장함
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			/*★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★*/
			
			// 로그인 기록 남기기
			MemberDao.getInstance().loginLog(id);
			
			// index.jsp로 Redirect로 이동을 할건데 이유는 insert 했기 때문에 바보야
			return new ModelAndView("index.jsp", true);
		}
		// 아니면 없는 거임
		else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('일치하는 회원 정보가 없습니다.')");
			out.println("history.back()");
			out.println("</script>");
			return null;
		}
		
	}

}
