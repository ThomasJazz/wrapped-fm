# wrapped-fm
- [Trello tasks](https://trello.com/b/iajPz5r5/wrappedfm-dev)
- [Swagger API Docs](http://localhost:8081/swagger-ui/index.html)

## Environment Setup
### Java
- [JDK 11.0.15](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html#license-lightbox)

### Flyway
- [Writing flyway scripts](https://flywaydb.org/documentation/database/postgresql)

### Postgres GUI
- PGAdmin 14

### Postgres Commands
- Start Postgres server [Must do this before any of the below commands will work]:
  > pg_ctl -D "C:\Program Files\PostgreSQL\14\data" start

- Stop Postgres server:
  > pg_ctl -D "C:\Program Files\PostgreSQL\14\data" stop

- Open command-line tool [`postgres` is the username for my local database admin account]:
  > psql -U postgres

- Connect to a database
    > \c wrapped_fm

### Meta-commands
- List DB's and some meta info
  > \list