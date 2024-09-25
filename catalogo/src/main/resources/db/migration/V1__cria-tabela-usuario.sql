CREATE TABLE tb_usuario(
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    cnpj VARCHAR(255) UNIQUE NOT NULL,
    razao_social VARCHAR(255) NOT NULL,
    nome_fantasia VARCHAR(255) NOT NULL,
    inscricao_estadual VARCHAR(255),
    inscricao_ccm VARCHAR(255),
    codigo_contabil VARCHAR(255),
    senha VARCHAR(255) NOT NULL,
    tipo VARCHAR(6) NOT NULL
 );