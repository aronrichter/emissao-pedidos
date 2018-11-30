CREATE TABLE pedido(
    id         INTEGER(10),
    cliente_id INTEGER(10)
);

ALTER TABLE pedido
    ADD CONSTRAINT pedido_pk
            PRIMARY KEY(id);

ALTER TABLE pedido
    ADD CONSTRAINT pedido_cliente_id_fk
        FOREIGN KEY (cliente_id) REFERENCES cliente (id);
