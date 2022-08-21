# music-gator-springboot

### Apache Kafka Commands
- Start **Apache** Web Server
  > net start

- Stop **Apache** Web Server (Run cmd/other terminal as administrator)
  > TASKKILL /F /IM httpd.exe /T

### Postgres Commands
- Start Postgres server (Must do this before any of the below commands will work):
  > pg_ctl -D "C:\Program Files\PostgreSQL\14\data" start

- Stop Postgres server:
  > pg_ctl -D "C:\Program Files\PostgreSQL\14\data" stop

- Open command-line tool (`postgres` is the username for my local database admin account):
  > psql -U postgres

- Connect to a database
    > \c wrapped_fm

### Meta-commands
- List DB's and some meta info
  > \list