CREATE USER dropuser WITH PASSWORD 'dropuser';

ALTER ROLE dropuser LOGIN;

GRANT CONNECT ON DATABASE datenbank TO dropuser;

-- in database datenbank

GRANT DROP ON SCHEMA public TO dropuser;

GRANT USAGE ON SCHEMA public TO dropuser;


-- https://www.postgresql.org/docs/current/sql-createrole.html