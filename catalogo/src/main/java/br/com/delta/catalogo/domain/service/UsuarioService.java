package br.com.delta.catalogo.domain.service;

import br.com.delta.catalogo.domain.dto.CriarUsuarioDto;
import br.com.delta.catalogo.domain.dto.UsuarioRespostaDto;
import br.com.delta.catalogo.domain.exception.UsuarioNaoEncontradoException;
import br.com.delta.catalogo.domain.model.Usuario;
import br.com.delta.catalogo.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final EnderecoService enderecoService;
    private final ContatoService contatoService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository repository, EnderecoService enderecoService, ContatoService contatoService, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.enderecoService = enderecoService;
        this.contatoService = contatoService;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioRespostaDto buscarUsuarioPorId(Long id) {
        return new UsuarioRespostaDto(findUsuarioId(id));
    }

    @Transactional
    public UsuarioRespostaDto cadastrarUsuario(CriarUsuarioDto criarUsuarioDto) {
        Usuario usuarioDto = new Usuario(criarUsuarioDto);
        usuarioDto.setPassword(encryptPassword(usuarioDto.getSenha()));

        Usuario usuario = repository.save(usuarioDto);
        enderecoService.cadastrar(criarUsuarioDto.enderecos(), usuario);
        contatoService.cadastrar(criarUsuarioDto.contatos(), usuario);
        return new UsuarioRespostaDto(usuario);
    }

    public Usuario findUsuarioId(Long id) {
        return repository.findById(id).orElseThrow(UsuarioNaoEncontradoException::new);
    }

    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

}