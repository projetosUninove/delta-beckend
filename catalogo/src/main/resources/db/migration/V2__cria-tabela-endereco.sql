CREATE TABLE tb_endereco (
    id BIGSERIAL PRIMARY KEY,
    cep VARCHAR(20) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    numero VARCHAR(50),
    complemento VARCHAR(255),
    bairro VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(50),
    tipo_endereco VARCHAR(50) NOT NULL,
    id_usuario BIGINT NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES tb_usuario (id) ON DELETE CASCADE
);