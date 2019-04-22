FROM mysql:5.7

COPY spectrumdatadump.sql /docker-entrypoint-initdb.d