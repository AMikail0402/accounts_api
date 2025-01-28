CREATE USER createuser WITH PASSWORD 'createuser';

ALTER ROLE createuser LOGIN;

GRANT CONNECT ON DATABASE datenbank TO createuser;

-- in database datenbank

GRANT CREATE ON SCHEMA public TO createuser;

GRANT USAGE ON SCHEMA public TO createuser;
