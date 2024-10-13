package br.com.delta.catalogo.domain.repository;

import br.com.delta.catalogo.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String subject);
}