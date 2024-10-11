package br.com.delta.catalogo.domain.repository;

import br.com.delta.catalogo.domain.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    List<Carrinho> findByUsuarioId(Long id);
    void deleteByUsuarioId(Long id);
    boolean existsByUsuarioIdAndProdutoId(Long usuarioId, Long produtoId);
}