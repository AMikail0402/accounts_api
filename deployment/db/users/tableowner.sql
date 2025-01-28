CREATE ROLE towner WITH PASSWORD 'towner';

ALTER ROLE towner LOGIN;

GRANT CONNECT ON DATABASE datenbank TO towner;

-- In database ''datenbank''
grant create on schema public to towner;