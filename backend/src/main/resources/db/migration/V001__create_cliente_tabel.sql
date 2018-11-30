CREATE TABLE cliente (
    id   INTEGER(10) NOT NULL,
    nome VARCHAR(50) NOT NULL
);

ALTER TABLE cliente
    ADD CONSTRAINT cliente_pk
        PRIMARY KEY(id);