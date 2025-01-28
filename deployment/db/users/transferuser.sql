ALTER ROLE transfernew LOGIN;

GRANT  USAGE  ON SCHEMA public  TO transfernew;

GRANT CONNECT ON DATABASE datenbank TO transfernew;

GRANT MAINTAIN ON ALL TABLES IN SCHEMA public TO transfernew;

-- sources: https://stackoverflow.com/questions/17338621/what-does-grant-usage-on-schema-do-exactly
--          https://stackoverflow.com/questions/35254786/postgresql-role-is-not-permitted-to-log-in
--          https://www.postgresql.org/docs/current/ddl-priv.html