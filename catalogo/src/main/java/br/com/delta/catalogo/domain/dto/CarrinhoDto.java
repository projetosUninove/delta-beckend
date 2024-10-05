package br.com.delta.catalogo.domain.dto;

import jakarta.validation.constraints.NotNull;

public record CarrinhoDto(
        Integer quantidade,
        @NotNull
        Long usuarioId,

        @NotNull
        Long produtoId
) {
}