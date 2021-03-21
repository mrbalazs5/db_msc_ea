package task2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BookDAO {

	public void insertBook(Book book) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("BookMapper.insert", book);
		session.commit();
		session.close();
	}

	public void updateBook(Book book) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("BookMapper.update", book);
		session.commit();
		session.close();
	}

	public void deleteBook(String isbn) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("BookMapper.deleteByIsbn", isbn);
		session.commit();
		session.close();
	}

	public Book findByIsbn(String isbn) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Book book = session.selectOne("BookMapper.findByIsbn", isbn);
		session.close();
		return book;
	}

	public List<Book> findAll() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Book> books = session.selectList("BookMapper.findAll");
		session.close();
		return books;
	}

}
