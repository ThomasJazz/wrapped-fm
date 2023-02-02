# music-gator-springboot
## Links
- (Trello tasks)[https://trello.com/b/iajPz5r5/wrappedfm-dev]


## Environment Setup
### Java
- (Java 17 SDK)[https://www.oracle.com/java/technologies/downloads/#jdk17-windows]

### Docker Desktop
- (Download Docker Desktop)[https://docs.docker.com/desktop/install/windows-install/]
- (Download WSL 2 Linux Kernel)[https://learn.microsoft.com/en-us/windows/wsl/install-manual#step-4---download-the-linux-kernel-update-package]

### Flyway
- (Writing flyway scripts)[https://flywaydb.org/documentation/database/postgresql]

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