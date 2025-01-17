GRANT  ALL PRIVILEGES   ON SCHEMA public  TO transfer;
ALTER ROLE transfer LOGIN;
GRANT REFERENCES ON ALL TABLES IN SCHEMA public TO transfer;

-- TODO: Select on table

-- sources: https://stackoverflow.com/questions/17338621/what-does-grant-usage-on-schema-do-exactly
--          https://stackoverflow.com/questions/35254786/postgresql-role-is-not-permitted-to-log-in