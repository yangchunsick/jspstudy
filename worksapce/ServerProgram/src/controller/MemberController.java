package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import service.MemberDeleteService;
import service.MemberDetailService;
import service.MemberJoinService;
import service.MemberListService;
import service.MemberService;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String requestURI = request.getRequestURI();
		String ContextPath = request.getContextPath();
		String command = requestURI.substring(ContextPath.length() + 1);

		ModelAndView mav = null;

		MemberService memberService = null;
		
		switch (command) {
		/* 목록으로 가는 */
		case "list.do":
			memberService = new MemberListService();	
			break;
			
		/* 로그인 화면이 나오는 */
		case "loginPage.do":
			mav = new ModelAndView("views/loginpage.jsp", false);
			break;
		/* 로그인을 했을 때 */
		case "login.do":
			memberService = new MemberDetailService();
			break;
		/* 회원가입 완료 */
		case "join.do":
			memberService = new MemberJoinService();
			break;
			
		/* 회원 탈퇴 */
		case "delete.do":
			memberService = new MemberDeleteService();
			break;	
			
		}
		
		
		
		
		
		
		if(memberService != null) {
			try {
				mav = memberService.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(mav != null) {
			if(mav.isRedirect()) {
				response.sendRedirect(mav.getView());
			}else {
				request.getRequestDispatcher(mav.getView()).forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
