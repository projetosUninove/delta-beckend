package br.com.delta.catalogo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_carrinho")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Carrinho(Integer quantidade, Usuario usuario, Produto produto) {
        this.quantidade = quantidade;
        this.usuario = usuario;
        this.produto = produto;
    }

    public Carrinho atualizar(Carrinho carrinho) {
        this.quantidade = carrinho.quantidade;
        this.usuario = carrinho.usuario;
        this.produto = carrinho.produto;
        return this;
    }

}