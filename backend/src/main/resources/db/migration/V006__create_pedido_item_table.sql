CREATE TABLE pedido_item(
    id             INTEGER(10) AUTO_INCREMENT,
    pedido_id      INTEGER(10),
    produto_id     INTEGER(10),
    quantidade     INTEGER(10),
    preco_unitario FLOAT(12,2),
    rentabilidade  CHAR(1),
    PRIMARY KEY (id)
);

ALTER TABLE pedido_item
    ADD CONSTRAINT produto_item_pedido_id_fk
        FOREIGN KEY (pedido_id) REFERENCES pedido (id);

ALTER TABLE pedido_item
    ADD CONSTRAINT produto_item_produto_id_fk
        FOREIGN KEY (produto_id) REFERENCES produto (id);
