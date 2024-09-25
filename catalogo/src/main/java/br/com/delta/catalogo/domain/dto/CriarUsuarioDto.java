package br.com.delta.catalogo.domain.dto;

import br.com.delta.catalogo.domain.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

public record CriarUsuarioDto(

        @Email
        @NotNull
        String email,

        @CNPJ
        @NotNull
        String cnpj,

        @NotNull
        String razaoSocial,

        @NotNull
        String nomeFantasia,
        String inscricaoEstadual,
        String inscricaoCcm,
        String codigoContabil,

        @NotNull
        String senha
) {
        public CriarUsuarioDto(Usuario usuario) {
                this(
                        usuario.getEmail(),
                        usuario.getCnpj(),
                        usuario.getRazaoSocial(),
                        usuario.getNomeFantasia(),
                        usuario.getInscricaoEstadual(),
                        usuario.getInscricaoCcm(),
                        usuario.getCodigoContabil(),
                        usuario.getSenha()
                );
        }
}
