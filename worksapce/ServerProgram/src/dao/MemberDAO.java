package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.MemberDTO;
import mybatis.config.DBService;

public class MemberDAO {

	private SqlSessionFactory factory;
	
	private static MemberDAO instance;
	private MemberDAO() {
		factory = DBService.getInstance().getFactory();
	}
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;		
	}
	
	/* Member List를 가져오는 */
	public List<MemberDTO> selectAllMember(){
		SqlSession ss = factory.openSession();
		List<MemberDTO> list = ss.selectList("dao.members.selectAllMember");
		ss.close();
		return list;
	}
	/* 추가 */
	public int insertMember(MemberDTO memberDTO) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.members.insertMember", memberDTO);
		ss.commit();
		ss.close();
		return result;
	}
	/* 삭제 */
	public int deleteMember(int no) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.members.deleteMember", no);
		if(result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	/* 상세 정보 들어가기 */
	public MemberDTO selectMemberInfoByNum(int no) {
		SqlSession ss = factory.openSession();
		MemberDTO member = ss.selectOne("dao.members.selectMemberInfoByNum", no);
		ss.close();
		return member;
	}
	
	
	
	
	
	
	
	
}
