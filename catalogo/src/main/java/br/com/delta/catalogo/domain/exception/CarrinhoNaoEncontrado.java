package br.com.delta.catalogo.domain.exception;

public class CarrinhoNaoEncontrado extends RuntimeException {

    public CarrinhoNaoEncontrado() {
        super("Carrinho de compras não encontrado");
    }
}
