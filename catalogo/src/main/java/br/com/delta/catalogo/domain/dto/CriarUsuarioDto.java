package br.com.delta.catalogo.domain.dto;

import br.com.delta.catalogo.domain.model.Contato;
import br.com.delta.catalogo.domain.model.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

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
        List<Endereco> enderecos,
        List<Contato> contatos,

        @NotNull
        String senha
) {

}