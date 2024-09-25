package br.com.delta.catalogo.domain.service;

import br.com.delta.catalogo.domain.dto.CriarUsuarioDto;
import br.com.delta.catalogo.domain.dto.UsuarioRespostaDto;
import br.com.delta.catalogo.domain.model.Usuario;
import br.com.delta.catalogo.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public UsuarioRespostaDto buscarUsuarioPorId(Long id){
        return new UsuarioRespostaDto(repository.findById(id).orElseThrow());
    }

    public UsuarioRespostaDto cadastrarUsuario(CriarUsuarioDto criarUsuarioDto){
         Usuario usuario = repository.save(new Usuario(criarUsuarioDto));
        return new UsuarioRespostaDto(usuario);

    }
}
