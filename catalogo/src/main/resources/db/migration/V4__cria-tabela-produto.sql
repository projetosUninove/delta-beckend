CREATE TABLE tb_produto(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR,
    descricao VARCHAR,
    preco NUMERIC(10, 2),
    imagem VARCHAR,
    quantidade INT
);