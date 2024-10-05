package br.com.delta.catalogo.domain.service;

import br.com.delta.catalogo.domain.enumerated.TipoEndereco;
import br.com.delta.catalogo.domain.model.Endereco;
import br.com.delta.catalogo.domain.model.Usuario;
import br.com.delta.catalogo.domain.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository repository;

    @Autowired
    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(List<Endereco> enderecos, Usuario usuario) {
        validarEnderecos(enderecos);

        if (!verificarUsuarioPossuiEnderecoEntregaEFaturamento(usuario.getId())) {
            enderecos.forEach(endereco -> repository.save(endereco.setUsuario(usuario)));
        } else {
            throw new IllegalArgumentException("Usuário já possui endereço de entrega e faturamento cadastrados.");
        }
    }

    //    TODO -> Refatorar metodo seguindo o pattern strategy
    private void validarEnderecos(List<Endereco> enderecos) {
        if (enderecos.size() > 2) {
            throw new IllegalArgumentException("Não é permitido cadastrar mais de dois endereços.");
        }

        long countEntrega = enderecos.stream().filter(e -> e.getTipoEndereco() == TipoEndereco.ENTREGA).count();
        long countFaturamento = enderecos.stream().filter(e -> e.getTipoEndereco() == TipoEndereco.FATURAMENTO).count();

        if (countEntrega > 1 || countFaturamento > 1) {
            throw new IllegalArgumentException("Cada usuário pode ter apenas um endereço de entrega e um de faturamento.");
        }

        if (countEntrega == 0 || countFaturamento == 0) {
            throw new IllegalArgumentException("É necessário fornecer um endereço de entrega e um de faturamento.");
        }
    }

    private boolean verificarUsuarioPossuiEnderecoEntregaEFaturamento(Long usuarioId) {
        return repository.usuarioPossuiEnderecoEntregaEFaturamento(usuarioId);
    }
}