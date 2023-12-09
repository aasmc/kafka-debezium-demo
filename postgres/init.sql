CREATE TABLE IF NOT EXISTS products(
    PRODUCT_ID BIGINT GENERATED ALWAYS AS IDENTITY,
    NAME TEXT NOT NULL,
    DESCRIPTION TEXT NOT NULL,
    PRICE NUMERIC(100, 5),
    PRIMARY KEY (PRODUCT_ID)
);

ALTER TABLE products REPLICA IDENTITY FULL;

INSERT INTO products(NAME, DESCRIPTION, PRICE)
VALUES ('Product One', 'Description One', 10.9);

CREATE PUBLICATION products_publication FOR TABLE products;

SELECT pg_create_logical_replication_slot('postgres_debezium', 'pgoutput');