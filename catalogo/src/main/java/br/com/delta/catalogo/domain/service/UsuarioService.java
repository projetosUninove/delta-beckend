package br.com.delta.catalogo.domain.service;

import br.com.delta.catalogo.domain.dto.CriarUsuarioDto;
import br.com.delta.catalogo.domain.dto.UsuarioRespostaDto;
import br.com.delta.catalogo.domain.exception.UsuarioNaoEncontradoException;
import br.com.delta.catalogo.domain.model.Usuario;
import br.com.delta.catalogo.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    EnderecoService enderecoService;

    public UsuarioRespostaDto buscarUsuarioPorId(Long id) {
        return new UsuarioRespostaDto(repository.findById(id).orElseThrow(UsuarioNaoEncontradoException::new));
    }

    @Transactional
    public UsuarioRespostaDto cadastrarUsuario(CriarUsuarioDto criarUsuarioDto) {
        Usuario usuario = repository.save(new Usuario(criarUsuarioDto));
        enderecoService.cadastrar(criarUsuarioDto.endereco(), usuario);
        return new UsuarioRespostaDto(usuario);
    }
}
