package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Notice;
import mybatis.config.DBService;

public class NoticeDao {
	
	/* MyBatis는 SqlSession 객체를 이용해서 DB에 접근한다. */
	/* SqlSession 객체는 메소드 별로 만들고 닫는 것이 좋다. SqlSession.close */
	/* SqlSession 객체를 만들 수 있는 SqlSessionFactory를 준비해 둔다. */
	
	
	/*DBSerivce에서 구현 했음*/
	private SqlSessionFactory factory; 
	
																				/* DBService랑 깐부사이라고 생각하셈 */
	/* singleton noticeDao 자기 자신을 객체로 만드는 행위 */
	private static NoticeDao instance;
	private NoticeDao() {
		factory = DBService.getInstance().getFactory(); /* factory는 DBService로부터 얻어 왔다 */
	}
	public static NoticeDao getInstance() {
		if(instance == null) {
			instance = new NoticeDao();
		}
		return instance;
	}
	
	/* 목록 반환 */
	public List<Notice> selectNoticeList(Map<String, Integer> map){
		SqlSession ss = factory.openSession();
		List<Notice> list = ss.selectList("dao.notice.selectNoticeList", map);
		ss.close();
		return list;
	}
	
	/**/
	public int selectTotalCount(){
		SqlSession ss = factory.openSession();
		int totalCount = ss.selectOne("dao.notice.selectTotalCount");
		ss.close();
		return totalCount;
	}
	
	
	/* 게시물 보기 */
	public Notice selectNoticeView(Long nNo) {
		SqlSession ss = factory.openSession();
		Notice notice = ss.selectOne("dao.notice.selectNoticeView", nNo);
		ss.close();
		return notice;
	}
	
	/* 조회수  증가 */
	public int updateNoticeHit(Long nNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.notice.updateNoticeHit", nNo);
		if(result > 0)ss.commit();
		return result;
	}
	
	/* 게시물 등록 */
	public int insertNotice(Notice notice) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.notice.insertNotice", notice);
		if(result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	/* 게시물 수정 */
	public int updateNotice(Notice notice) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.notice.updateNotice", notice);
		if(result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	/* 게시물 삭제 (댓글이 없어야 지울 수 있음) */
	public int deleteNotice(Long nNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.notice.deleteNotice", nNo);
		if(result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	/**/
	public List<Notice> findNotice(Map<String, String> map){
		SqlSession ss = factory.openSession();
		List<Notice> list = ss.selectList("dao.notice.findNotice", map);
		ss.close();
		return list;
	}	
	
	/* 검색한 목록 가져오기 */
	public int selectFindCount(Map<String, String> map) {
		SqlSession ss = factory.openSession();
		int findCount = ss.selectOne("dao.notice.selectFindCount", map);
		ss.close();
		return findCount;
	}

}
