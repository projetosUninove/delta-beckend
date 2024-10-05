package br.com.delta.catalogo.domain.repository;

import br.com.delta.catalogo.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query("SELECT COUNT(e) = 2 " +
            "FROM Endereco e " +
            "WHERE e.usuario.id = :usuarioId " +
            "AND (e.tipoEndereco = 'ENTREGA' OR e.tipoEndereco = 'FATURAMENTO')")
    boolean usuarioPossuiEnderecoEntregaEFaturamento(@Param("usuarioId") Long usuarioId);
}