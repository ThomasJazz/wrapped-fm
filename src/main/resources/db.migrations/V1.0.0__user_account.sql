CREATE TABLE user_account
(
    user_account_id SERIAL PRIMARY KEY,
    username VARCHAR(30) NOT NULL UNIQUE,
    email_address VARCHAR(50) NOT NULL UNIQUE,
    birth_date DATE
);
