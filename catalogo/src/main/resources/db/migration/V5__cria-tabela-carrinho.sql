CREATE TABLE tb_carrinho(
    id BIGSERIAL PRIMARY KEY,
    quantidade INT,
    id_usuario BIGINT NOT NULL,
    id_produto BIGINT NOT NULL,

    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES tb_usuario (id) ON DELETE CASCADE,
    CONSTRAINT fk_produto FOREIGN KEY (id_produto) REFERENCES tb_produto (id) ON DELETE CASCADE
);