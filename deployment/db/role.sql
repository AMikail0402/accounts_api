GRANT  ALL PRIVILEGES   ON SCHEMA public  TO transfer;

ALTER ROLE transfer LOGIN;

GRANT REFERENCES ON ALL TABLES IN SCHEMA public TO transfer;

-- User neu erstellen --> Usage on Schema  --> MAINTAIN auf Tabellen
 -- Alternativ --> Nur mit SELECT-Privilegien --> Internet-Quelle wieder finden (Suchwort: "pgdump LOCK does not work")

-- TODO: MAINTAIN on table

-- sources: https://stackoverflow.com/questions/17338621/what-does-grant-usage-on-schema-do-exactly
--          https://stackoverflow.com/questions/35254786/postgresql-role-is-not-permitted-to-log-in