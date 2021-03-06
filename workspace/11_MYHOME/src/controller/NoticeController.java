package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import service.notice.NoticeDeleteService;
import service.notice.NoticeFindService;
import service.notice.NoticeInsertService;
import service.notice.NoticeListService;
import service.notice.NoticeService;
import service.notice.NoticeUpdateService;
import service.notice.NoticeViewService;

@WebServlet("*.notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* 요청/응답 처리 */
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		/* JSP 요청 확인 (경로 확인) */
		String requestURI = request.getRequestURI();
		String contextpath = request.getContextPath();
		String command = requestURI.substring(contextpath.length() + 1);

		// 모든 Notice Service들은 인터페이스 NoticeService를 구현하므로
		// NoticeService 타입의 객체이다.

		NoticeService service = null;

		// 단순 이동인 요청을 처리할 ModelAndView 객체 선언
		// 1. 단순 이동 요청을 처리
		// 2. 모든 Model(Service)는 ModelAndView를 반환

		ModelAndView mav = null;
		// 요청을 받은 값의 따라 어떤 동작을 할 것인지 정해주는 switch
		// 해당 요청을 처리할 Model(Service) 선택
		switch (command) {
		case "list.notice":
			service = new NoticeListService();
			break;
			
		case "view.notice":
			service = new NoticeViewService();
			break;
			
		case "insertForm.notice":					   // 단순 이동을 시킬 땐 forward 하는 것이 좋다..!?
			mav = new ModelAndView("notice/insert.jsp",false);
			break;

		case "insert.notice":
			service = new NoticeInsertService();
			break;
			
		case "updateForm.notice":
			mav = new ModelAndView("notice/update.jsp", false);
			break;
		
		case "update.notice":
			service = new NoticeUpdateService();
			break;
			
		case "delete.notice":
			service = new NoticeDeleteService();
			break;
			
		case "find.notice":
			service = new NoticeFindService();
			break;
		}

		// service가 사용되지 않은 경우 (단순 이동) service 실행이 불가능
		if (service != null) {
			try {
				mav = service.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// mav가 null인 경우
		// 1. Model(Service)에서 응답으로 이동하는 경우
		// 2. Model(Service)이 ajax 응답을 하는 경우
		if (mav == null) {
			return;
		}

		// mav가 null이 아닌 경우 : MVC 패턴으로 페이지 이동이 있음.
		if (mav.isRedirect()) {
			response.sendRedirect(mav.getView());
		} else {
			request.getRequestDispatcher(mav.getView()).forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
