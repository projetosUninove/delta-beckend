package br.com.delta.catalogo.domain.repository;

import br.com.delta.catalogo.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}