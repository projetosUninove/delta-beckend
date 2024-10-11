package br.com.delta.catalogo.domain.exception;

import br.com.delta.catalogo.domain.model.Produto;

import java.text.MessageFormat;

public class ProdutoQuantidadeInsuficienteException extends RuntimeException {

    public ProdutoQuantidadeInsuficienteException(Produto produto) {
        super(MessageFormat.format("O produto: {0} possui apenas {1} {1,choice,1#unidade|1<unidades} disponivel", produto.getNome(), produto.getQuantidade()));
    }
}
