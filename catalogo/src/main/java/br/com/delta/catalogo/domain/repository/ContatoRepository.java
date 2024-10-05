package br.com.delta.catalogo.domain.repository;

import br.com.delta.catalogo.domain.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
