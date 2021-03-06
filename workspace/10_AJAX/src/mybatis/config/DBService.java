package mybatis.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/* SqlSessionFactory를 만들어서 Dao에게 반환하는 클래스 */
/*  */
public class DBService {

	/* SqlSessionFactory */
	private SqlSessionFactory factory;
	public SqlSessionFactory getFactory() {
		return factory;
	}
	
	/* singleton */
	private static DBService instance;
	private DBService() {	/* DBService 생성 시점 */
		/* SqlSessionFactory 빌드 */
		try {
			String resource = "mybatis/config/mybatis-config.xml";	/* DB 접속을 위한 기본 정보는 mybatis-config.xml에 저장함 */
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DBService getInstance() {
		if (instance == null) {
			instance = new DBService();
		}
		return instance;
	}
	
}
