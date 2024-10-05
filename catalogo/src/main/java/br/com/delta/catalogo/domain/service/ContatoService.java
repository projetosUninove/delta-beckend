package br.com.delta.catalogo.domain.service;

import br.com.delta.catalogo.domain.model.Contato;
import br.com.delta.catalogo.domain.model.Usuario;
import br.com.delta.catalogo.domain.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository repository;

    @Autowired
    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(List<Contato> contatos, Usuario usuario) {
        contatos.forEach(contato -> repository.save(contato.setUsuario(usuario)));
    }
}