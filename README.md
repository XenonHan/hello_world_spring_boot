This is a practise for connecting the postgres database with spring boot, following the [tutorial](https://www.youtube.com/watch?v=vtPkZShrvXQ&list=WL&index=18&t=99s)

# Notes to run a docker postgres database

## Docker 
1. docker run --name postgres_db -e POSTGRES_PASSWORD=xenonhan -p 5432:5432 -d first_spring_postgres
2. docker port postgres_db
3. docker exec -it <id> /bin/bash
4. \l
  
## Postgres
1. psql -U postgres
2. CREATE DATABASE demodb
3. \c demodb
4. CREATE TABLE person(id UUID, name VARCHAR(100));
5. \dt

Need to mount the volume manually if the data going to resue next time

