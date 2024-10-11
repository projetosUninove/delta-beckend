package br.com.delta.catalogo.domain.exception;

public class CarrinhoNaoEncontradoException extends RuntimeException {

    public CarrinhoNaoEncontradoException() {
        super("Carrinho de compras não encontrado");
    }
}
