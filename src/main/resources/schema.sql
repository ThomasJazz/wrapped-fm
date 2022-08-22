CREATE TABLE userAccount
(
    userAccountId SERIAL PRIMARY KEY,
    username VARCHAR(30) NOT NULL UNIQUE,
    emailAddress VARCHAR(50) NOT NULL UNIQUE,
    birthDate DATE
);
