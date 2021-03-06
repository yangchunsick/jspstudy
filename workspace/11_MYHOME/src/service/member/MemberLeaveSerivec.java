package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDao;
import dto.Member;

public class MemberLeaveSerivec implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 탈퇴하고자 하는 mNo, id 가져오기
		
		// Session에 저장 되어 있음
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		
		// 삭제
		// MemberDao.getInstance().deleteMemberLog(loginUser.getId());
		int result = MemberDao.getInstance().deleteMember(loginUser.getmNo());
		
		// 해당 회원의 계정이 삭제되면 알려주기
		PrintWriter out = response.getWriter();
		if(result > 0) {
			// Session 정보 제거
			session.invalidate();
			// script
			out.println("<script>");
			out.println("alert('회원 탈퇴 성공')");
			out.println("location.href='index.jsp'");
			out.println("</script>");
			out.close();
		}else {
			out.println("<script>");
			out.println("alert('회원 탈퇴 실패')");
			out.println("history.back()'");
			out.println("</script>");
			out.close();
		}
		
		return null;
	}

}
