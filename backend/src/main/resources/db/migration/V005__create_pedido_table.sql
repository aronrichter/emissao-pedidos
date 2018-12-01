CREATE TABLE pedido(
    id         INTEGER(10) NOT NULL AUTO_INCREMENT,
    cliente_id INTEGER(10),
    PRIMARY KEY (id)
);


ALTER TABLE pedido
    ADD CONSTRAINT pedido_cliente_id_fk
        FOREIGN KEY (cliente_id) REFERENCES cliente (id);
