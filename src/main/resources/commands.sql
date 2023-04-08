CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    order_type VARCHAR(255) NOT NULL,
    order_price DOUBLE NOT NULL,
    order_amount INT NOT NULL,
    order_status VARCHAR(255) NOT NULL,
    order_date VARCHAR(255) NOT NULL,
    order_book_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (order_book_id) REFERENCES order_book(order_book_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE order_book (
    order_book_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE users (
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL
);
