-- Publication of db 1

-- password of db 1 ZpcZWZNzMP

CREATE PUBLICATION pub_pri1 FOR ALL TABLES;

-- Subscription for DB 2
CREATE SUBSCRIPTION sub_pri2_pri1
CONNECTION 'dbname=datenbank host=accounts-db-postgresql.db user=postgres password=VkaINLojQ2'
PUBLICATION pub_pri1 WITH (origin = NONE, copy_data = false, synchronous_commit = 'on');

-- set wal level, then restart for both nodes
ALTER SYSTEM SET wal_level = logical;


-- publication for DB 2 
CREATE PUBLICATION pub_pri2 FOR ALL TABLES;

-- Subscription for DB 1
CREATE SUBSCRIPTION sub_pri1_pri2
CONNECTION 'dbname=datenbank host=accounts-db-2-postgresql.db-2 user=postgres password=3D8SZZLpOx'
PUBLICATION pub_pri2 WITH (origin = NONE, copy_data = false, synchronous_commit = 'on');

-- synchronous commits for node 1 
ALTER SYSTEM SET synchronous_commit = 'on';
ALTER SYSTEM SET synchronous_standby_names = 'sub_pri2_pri1';
SELECT pg_reload_conf();

-- synchronous commits for node 2
ALTER SYSTEM SET synchronous_commit = 'on';
ALTER SYSTEM SET synchronous_standby_names = 'sub_pri1_pri2';
SELECT pg_reload_conf();
