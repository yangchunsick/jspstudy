package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;

public class MemberLogoutService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// session의 모든 정보 초기화
		HttpSession session = request.getSession();
		session.invalidate();
		
		// index.jsp로 forward/Redirect 이동 둘 중 아무거나 해도 상관 없움
		return new ModelAndView("index.jsp", false);
		
	}

}
