package br.com.delta.catalogo.domain.dto;

import br.com.delta.catalogo.domain.model.Usuario;

public record UsuarioRespostaDto(
        Long id,
        String email,
        String cnpj,
        String razaoSocial,
        String nomeFantasia,
        String inscricaoEstadual,
        String inscricaoCcm,
        String codigoContabil
) {
    public UsuarioRespostaDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getCnpj(),
                usuario.getRazaoSocial(),
                usuario.getNomeFantasia(),
                usuario.getInscricaoEstadual(),
                usuario.getInscricaoCcm(),
                usuario.getCodigoContabil()
        );
    }
}
