SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'datenbank'
AND pid <> pg_backend_pid();

CREATE ROLE admin WITH LOGIN PASSWORD 'admin';

CREATE DATABASE datenbank with OWNER admin;

-- end all sessions

