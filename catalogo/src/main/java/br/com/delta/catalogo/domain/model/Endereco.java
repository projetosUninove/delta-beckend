package br.com.delta.catalogo.domain.model;

import br.com.delta.catalogo.domain.enumerated.TipoEndereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_endereco")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Endereco setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", tipoEndereco=" + tipoEndereco +
                ", usuario=" + usuario +
                '}';
    }
}