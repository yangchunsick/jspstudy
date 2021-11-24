package service.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.NoticeDao;
import dto.Notice;

public class NoticeInsertService implements NoticeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		
		Notice notice = new Notice();
		notice.setWriter(writer);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setIp(ip);
		
		// singletone 작업을 했기 때문에 불러 올 수 있다
		// DAO에서 작업한 insertNotice를 불러옴
		int result = NoticeDao.getInstance().insertNotice(notice);

		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('등록 성공 !')");
			out.println("location.href='list.notice'");
			out.println("</script>");
			out.close();
		}else {
			out.println("<script>");
			out.println("alert('등록 실패..')");
			out.println("history.back()'");
			out.println("</script>");
			out.close();
		}
		
		// 위에 if else 어쩌구로 어디로 갈지 정했기 때문에 리턴 값을 안 적어줘도 됌
		return null;
	}

}
