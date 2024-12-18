CREATE TABLE IF NOT EXISTS users (
    id_user INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS banks (
  bank_code INT PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS category (
  id_category INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS transactions (
  id_transaction INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  date DATE NOT NULL,
  type ENUM('ENTRADA', 'SAIDA', 'TRANSFERENCIA') NOT NULL,
  amount DECIMAL(15,2) NOT NULL,
  category_id INT NOT NULL,
  bank_code INT NOT NULL,
  FOREIGN KEY (category_id) REFERENCES category(id_category),
  FOREIGN KEY (bank_code) REFERENCES banks(bank_code)
);

INSERT INTO users (name, email, password, role) VALUES ("Tiago", "tiago@email.com", "$2a$10$ccOdQijprWoRyqQZyTwN/uSFBzPPcqfnkTstnvhShuLPfLysPfVLW", 1); -- Senha Shigueo; role 0 = admin 1 = user

INSERT INTO banks (bank_code, name) VALUES (208, "Banco BTG Pactual S.A.");

INSERT INTO category(name) VALUES ("Presentes");

INSERT INTO transactions (date, type, amount, category_id, bank_code) VALUES ("2024-10-12", "ENTRADA", 250, 1, 208);
