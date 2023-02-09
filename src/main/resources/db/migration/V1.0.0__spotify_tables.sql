DROP TABLE IF EXISTS spotify_listen;
DROP TABLE IF EXISTS user_account;

CREATE TABLE user_account (
  id UUID NOT NULL,
   username VARCHAR(255),
   email_address VARCHAR(255),
   birth_date TIMESTAMP WITHOUT TIME ZONE,
   modified_date TIMESTAMP WITHOUT TIME ZONE,
   create_date TIMESTAMP WITHOUT TIME ZONE,
   CONSTRAINT pk_user_account PRIMARY KEY (id)
);

CREATE TABLE spotify_listen (
    id UUID NOT NULL,
   user_account_id UUID NOT NULL,
   modified_date TIMESTAMP WITHOUT TIME ZONE,
   create_date TIMESTAMP WITHOUT TIME ZONE,
   CONSTRAINT pk_spotify_listen PRIMARY KEY (id)
);

ALTER TABLE spotify_listen ADD CONSTRAINT FK_SPOTIFY_LISTEN_ON_USER_ACCOUNT FOREIGN KEY (user_account_id) REFERENCES user_account (id);