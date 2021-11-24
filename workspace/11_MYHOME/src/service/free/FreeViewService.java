package service.free;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.FreeDao;
import dto.Free;

public class FreeViewService implements FreeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 파라미터
		Optional<String> opt = Optional.ofNullable(request.getParameter("fNo"));
		Long fNo = Long.parseLong(opt.orElse("0"));
		
		// 조회수 증가
		HttpSession session = request.getSession();
		// 게시글을 열었을 때 Session에 open 속성을 저장해 둠
		// 게시글을 닫지 않으면 Session의 open 속성 값이 계속 유지됨.
		// session의 open 속성 값이 있으면 게시글을 닫지 않았다고 볼 수 있음
		
		if(session.getAttribute("open") == null) {
			session.setAttribute("open", true);
			FreeDao.getInstance().updateHit(fNo);
		}
		
		// 불러오기
		Free free = FreeDao.getInstance().selectFreeByfNo(fNo);
		
		if(free != null) {
			request.setAttribute("free", free);
			return new ModelAndView("free/view.jsp", false);
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('해당 게시글을 찾을 수 없습니다. 다시 시도하세요.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			return null;			
		}
		
		
	}

}
