CREATE TABLE user_account
(
    user_account_id SERIAL PRIMARY KEY,
    username VARCHAR(30),
    email_address VARCHAR(50),
    birth_date DATE
);