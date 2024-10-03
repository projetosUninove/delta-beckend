package br.com.delta.catalogo.domain.service;

import br.com.delta.catalogo.domain.model.Endereco;
import br.com.delta.catalogo.domain.model.Usuario;
import br.com.delta.catalogo.domain.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public void cadastrar(List<Endereco> enderecos, Usuario usuario) {
        if (enderecos != null) {
            for (Endereco endereco : enderecos) {
                // TODO -> Garantir que tenha apenas 1 endereço de entrega e faturamento por usuario
                repository.save(endereco.setUsuario(usuario));
            }
        }
    }
}