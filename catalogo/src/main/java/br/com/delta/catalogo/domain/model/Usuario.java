package br.com.delta.catalogo.domain.model;

import br.com.delta.catalogo.domain.dto.CriarUsuarioDto;
import br.com.delta.catalogo.domain.enumerated.UsuarioTipo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

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

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private UsuarioTipo usuarioTipo;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Endereco> enderecos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Contato> contatos;

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
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.senha = password;
    }
}