package br.com.delta.catalogo.domain.model;

import br.com.delta.catalogo.domain.dto.CriarUsuarioDto;
import br.com.delta.catalogo.domain.enumerated.UsuarioTipo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cnpj;

    private String razaoSocial;
    private String nomeFantasia;
    private String inscricaoEstadual;
    private String inscricaoCcm;
    private String codigoContabil;
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private UsuarioTipo usuarioTipo;

    public Usuario(CriarUsuarioDto dto) {
        this.email = dto.email();
        this.cnpj = dto.cnpj();
        this.razaoSocial = dto.razaoSocial();
        this.nomeFantasia = dto.nomeFantasia();
        this.inscricaoEstadual = dto.inscricaoEstadual();
        this.inscricaoCcm = dto.inscricaoCcm();
        this.codigoContabil = dto.codigoContabil();
        this.senha = dto.senha();
        this.usuarioTipo = UsuarioTipo.COMUN;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", inscricaoEstadual='" + inscricaoEstadual + '\'' +
                ", inscricaoCcm='" + inscricaoCcm + '\'' +
                ", codigoContabil='" + codigoContabil + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}