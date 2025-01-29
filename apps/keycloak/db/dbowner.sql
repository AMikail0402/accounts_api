CREATE USER keycloak WITH PASSWORD 'keycloak';

ALTER ROLE keycloak LOGIN;

GRANT CONNECT ON DATABASE keycloak TO keycloak;
