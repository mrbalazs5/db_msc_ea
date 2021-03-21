package task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class BookApplication {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			BookDAO bookDAO = new BookDAO();
			UserDAO userDAO = new UserDAO();
			UserReadBookDAO userReadBookDAO = new UserReadBookDAO();

			mainLoop: while (true) {
				System.out.println("--Menu--");
				System.out.println("Add user -> 1");
				System.out.println("Delete user -> 2");
				System.out.println("Update user -> 3");
				System.out.println("Add book -> 4");
				System.out.println("Add which user read which book -> 5");
				System.out.println("List users -> 6");
				System.out.println("List books -> 7");
				System.out.println("List user read books -> 8");
				System.out.println("Quit -> 9");

				int input = Integer.parseInt(reader.readLine());

				try {
					switch (input) {
					case 1: {
						System.out.println("id:");
						int id = Integer.parseInt(reader.readLine());
						System.out.println("fullName:");
						String fullName = reader.readLine();
						System.out.println("age:");
						int age = Integer.parseInt(reader.readLine());

						User user = new User(id, fullName, age);

						userDAO.insertUser(user);
						System.out.println("User inserted successfully.");

						break;
					}
					case 2: {
						System.out.println("id:");
						int id = Integer.parseInt(reader.readLine());

						userDAO.deleteUser(id);
						System.out.println("User deleted successfully.");

						break;
					}
					case 3: {
						System.out.println("id:");
						int id = Integer.parseInt(reader.readLine());
						System.out.println("fullName:");
						String fullName = reader.readLine();
						System.out.println("age:");
						int age = Integer.parseInt(reader.readLine());

						User user = new User(id, fullName, age);

						userDAO.updateUser(user);
						System.out.println("User updated successfully.");

						break;
					}
					case 4: {
						System.out.println("isbn:");
						String isbn = reader.readLine();
						System.out.println("title:");
						String title = reader.readLine();
						System.out.println("price:");
						int price = Integer.parseInt(reader.readLine());

						Book book = new Book(isbn, title, price);

						bookDAO.insertBook(book);
						System.out.println("Book inserted successfully.");

						break;
					}
					case 5: {
						System.out.println("userId:");
						int userId = Integer.parseInt(reader.readLine());
						System.out.println("bookIsbn:");
						String bookIsbn = reader.readLine();

						UserReadBook userReadBook = new UserReadBook(userId, bookIsbn);

						userReadBookDAO.insertUserReadBook(userReadBook);
						System.out.println("User and book connected successfully.");

						break;
					}
					case 6: {
						List<User> users = userDAO.findAll();

						for (User userIterator : users) {
							System.out.println("Id: " + userIterator.getId());
							System.out.println("Name: " + userIterator.getFullName());
							System.out.println("Age: " + userIterator.getAge());
							System.out.println();
						}

						break;
					}
					case 7: {
						List<Book> books = bookDAO.findAll();

						for (Book bookIterator : books) {
							System.out.println("Isbn: " + bookIterator.getIsbn());
							System.out.println("Title: " + bookIterator.getTitle());
							System.out.println("Price: " + bookIterator.getPrice());
							System.out.println();
						}

						break;
					}
					case 8: {
						System.out.println("userId:");
						int userId = Integer.parseInt(reader.readLine());

						List<Book> books = userDAO.getReadBooks(userId);

						for (Book bookIterator : books) {
							System.out.println("Isbn: " + bookIterator.getIsbn());
							System.out.println("Title: " + bookIterator.getTitle());
							System.out.println("Price: " + bookIterator.getPrice());
							System.out.println();
						}

						break;
					}
					case 9:
						break mainLoop;
					default:
						System.out.println("Invalid command.");
					}

					reader.readLine();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
