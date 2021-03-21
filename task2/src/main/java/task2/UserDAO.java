package task2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserDAO {

	public void insertUser(User user) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("UserMapper.insert", user);
		session.commit();
		session.close();
	}

	public void updateUser(User user) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("UserMapper.update", user);
		session.commit();
		session.close();
	}

	public void deleteUser(int id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("UserMapper.deleteById", id);
		session.commit();
		session.close();
	}

	public User findById(int id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		User user = session.selectOne("UserMapper.findById", id);
		session.close();
		return user;
	}

	public List<User> findAll() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<User> users = session.selectList("UserMapper.findAll");
		session.close();
		return users;
	}

	public List<Book> getReadBooks(int id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Book> books = session.selectList("UserMapper.getReadBooks", id);
		session.close();
		return books;
	}

}
