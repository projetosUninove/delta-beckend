package br.com.delta.catalogo.domain.service;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(){
        super("Usuário não encontrado");
    }
}