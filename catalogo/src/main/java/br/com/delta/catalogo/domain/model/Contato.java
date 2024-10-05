package br.com.delta.catalogo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "tb_contato")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nomeCompleto;

    @NotBlank
    private String telefone;
    private String celular;

    @NotBlank
    private String email;
    private String cargo;
    private String area;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Contato setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }
}