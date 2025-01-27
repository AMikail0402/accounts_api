-- end all sessions

-- SELECT pg_terminate_backend(pid)
-- FROM pg_stat_activity
-- WHERE datname = 'datenbank'
-- AND pid <> pg_backend_pid();

-- delete all tables

DO $$ DECLARE
    r RECORD;
BEGIN
    FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = current_schema()) LOOP
        EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(r.tablename) || ' CASCADE';
    END LOOP;
END $$;



-- sources
-- https://www.dbvis.com/thetable/how-to-kill-all-connections-to-a-database-in-postgresql/
-- https://stackoverflow.com/questions/3327312/how-can-i-drop-all-the-tables-in-a-postgresql-database