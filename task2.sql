CREATE TABLE books
( 
	isbn VARCHAR(14) PRIMARY KEY,
	title VARCHAR(50),
	price NUMERIC CHECK(price > 0)
);

CREATE TABLE users
( 
	id INT PRIMARY KEY,
	fullName VARCHAR(50),
	age NUMERIC CHECK(age > 0)
);

CREATE TABLE user_read_book
( 
	userId INT,
	FOREIGN KEY(userId) REFERENCES users(id),
	bookIsbn VARCHAR(14),
	FOREIGN KEY(bookIsbn) REFERENCES books(isbn)
);