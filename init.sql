CREATE TABLE IF NOT EXISTS users (
    id_user INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

INSERT INTO users (name, email, password, role) VALUES ("Tiago", "tiago@email.com", "$2a$10$ccOdQijprWoRyqQZyTwN/uSFBzPPcqfnkTstnvhShuLPfLysPfVLW", 1); -- Senha Shigueo