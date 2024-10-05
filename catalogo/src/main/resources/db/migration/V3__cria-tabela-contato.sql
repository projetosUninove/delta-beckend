CREATE TABLE tb_contato(
    id BIGSERIAL PRIMARY KEY,
    nome_completo VARCHAR,
    telefone VARCHAR,
    celular VARCHAR,
    email VARCHAR,
    cargo VARCHAR,
    area VARCHAR,
    id_usuario BIGINT NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES tb_usuario (id) ON DELETE CASCADE
);
