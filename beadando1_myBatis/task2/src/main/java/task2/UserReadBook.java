package task2;

public class UserReadBook {
	private int userId;
	private String bookIsbn;
	
	public UserReadBook(int userId, String bookIsbn) {
		this.userId = userId;
		this.bookIsbn = bookIsbn;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBookIsbn() {
		return bookIsbn;
	}
	
	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
}
