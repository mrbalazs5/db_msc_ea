package task2;

import org.apache.ibatis.session.SqlSession;

public class UserReadBookDAO {
	public void insertUserReadBook(UserReadBook userReadBook) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("UserReadBookMapper.insert", userReadBook);
		session.commit();
		session.close();
	}
}
