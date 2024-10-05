package br.com.delta.catalogo.domain.repository;

import br.com.delta.catalogo.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
