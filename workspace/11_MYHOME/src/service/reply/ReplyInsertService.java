package service.reply;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.ReplyDao;
import dto.Reply;

public class ReplyInsertService implements ReplyService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// request를 받아 온다.
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		Long nNo = Long.parseLong(request.getParameter("nNo"));
		String ip = request.getRemoteAddr();
		
		Reply reply = new Reply();
		reply.setWriter(writer);
		reply.setContent(content);
		reply.setnNo(nNo);
		reply.setIp(ip);
		
		int result = ReplyDao.getInstance().insertReply(reply);
		
		if(result > 0) {
			// 댓글이 삽입되면 댓글 리스트 (replyList)를 DB에서 새로 가져와야한다.
			// 따라서, 댓글리스트(replyList)를 DB에서 가져오는 서비스인 NoticeViewService를
			// 실행할 수 있는 "view.notice" 맵핑으로 이동한다.
			
			// "view.notice"로 Redirect로 이동을 해야하는데 이유는 삽입, 수정, 삭제 이후에는 Redirect를 해야되기 때문에)
			
			// "view.notice"로 이동하려면 항상 nNo를 파라미터로 전달 해야한다.
			
			
			return new ModelAndView("view.notice?nNo=" + nNo, true);
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('댓글달기 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			return null;			
		}
		
	}

}
