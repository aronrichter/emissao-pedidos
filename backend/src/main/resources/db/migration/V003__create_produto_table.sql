CREATE TABLE produto(
    id       INTEGER(10) NOT NULL,
    nome     VARCHAR(50) NOT NULL,
    preco    FLOAT(12,2) NOT NULL,
    multiplo INTEGER(3)
);

ALTER TABlE produto
    ADD CONSTRAINT produto_pk
            PRIMARY KEY(id);