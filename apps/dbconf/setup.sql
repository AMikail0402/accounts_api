SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'datenbank'
AND pid <> pg_backend_pid();

-- end all sessions

DROP DATABASE datenbank;

CREATE DATABASE datenbank with OWNER admin;


-- sources
-- https://www.dbvis.com/thetable/how-to-kill-all-connections-to-a-database-in-postgresql/