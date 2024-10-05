package br.com.delta.catalogo.domain.service;

import br.com.delta.catalogo.domain.exception.ProdutoNaoEncontradoException;
import br.com.delta.catalogo.domain.model.Produto;
import br.com.delta.catalogo.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> buscarProduto() {
        return repository.findAll();
    }

    public Produto buscarProdutoPorId(Long id) {
        return findById(id);
    }

    public Produto cadastrar(Produto produto) {
        return repository.save(produto);
    }

    @Transactional
    public Produto atualizar(Long id, Produto dto) {
        Produto produto = findById(id);
        return produto.atualizar(dto);
    }

    private Produto findById(Long id) {
        return repository.findById(id).orElseThrow(ProdutoNaoEncontradoException::new);
    }

}