CREATE TABLE IF NOT EXISTS products(
    ID BIGINT GENERATED ALWAYS AS IDENTITY,
    NAME TEXT NOT NULL,
    DESCRIPTION TEXT NOT NULL,
    PRICE NUMERIC(100, 5),
    PRIMARY KEY (ID)
);

CREATE PUBLICATION products_publication FOR TABLE products;

SELECT pg_create_logical_replication_slot('postgres_debezium', 'pgoutput');