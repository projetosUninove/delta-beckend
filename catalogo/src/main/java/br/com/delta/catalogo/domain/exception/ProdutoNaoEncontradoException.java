package br.com.delta.catalogo.domain.exception;

public class ProdutoNaoEncontradoException extends RuntimeException{

    public ProdutoNaoEncontradoException(){
        super("Produto não encontrado!");
    }
}
