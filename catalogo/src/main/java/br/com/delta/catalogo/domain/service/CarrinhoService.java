package br.com.delta.catalogo.domain.service;

import br.com.delta.catalogo.domain.dto.CarrinhoDto;
import br.com.delta.catalogo.domain.exception.CarrinhoNaoEncontrado;
import br.com.delta.catalogo.domain.model.Carrinho;
import br.com.delta.catalogo.domain.model.Produto;
import br.com.delta.catalogo.domain.model.Usuario;
import br.com.delta.catalogo.domain.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarrinhoService {

    private final CarrinhoRepository repository;
    private final UsuarioService usuarioService;
    private final ProdutoService produtoService;

    @Autowired
    public CarrinhoService(CarrinhoRepository repository, UsuarioService usuarioService, ProdutoService produtoService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
        this.produtoService = produtoService;
    }

    public List<Carrinho> buscarPorIdUsuario(Long id) {
        return repository.findByUsuarioId(id);
    }

    public Carrinho adicionar(CarrinhoDto dto) {
        System.out.println(repository.existsByUsuarioIdAndProdutoId(dto.usuarioId(), dto.usuarioId()));
        if (repository.existsByUsuarioIdAndProdutoId(dto.usuarioId(), dto.produtoId())){
            throw new RuntimeException("Produto já esta no carrinho");
        }
        return repository.save(novoCarrinho(dto));
    }

    @Transactional
    public Carrinho atualizar(Long id, CarrinhoDto dto) {
        Carrinho carrinho = buscarPorId(id);
        return carrinho.atualizar(novoCarrinho(dto));
    }


    private Carrinho novoCarrinho(CarrinhoDto dto) {
        Usuario usuario = usuarioService.findUsuarioId(dto.usuarioId());
        Produto produto = produtoService.buscarProdutoPorId(dto.produtoId());
        return new Carrinho(dto.quantidade(), usuario, produto);
    }

    @Transactional
    public List<Carrinho> comparar(Long id) {
        List<Carrinho> carrinhos =  repository.findByUsuarioId(id);

        carrinhos.forEach(carrinho -> {
            produtoService.comprar(carrinho.getProduto(), carrinho.getQuantidade());
        });

        this.limparCarrinhoPorUsuario(id);
        return repository.findByUsuarioId(id);
    }

    private Carrinho buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(CarrinhoNaoEncontrado::new);
    }

    public void deletar(Long id) {
        repository.delete(buscarPorId(id));
    }

    @Transactional
    public void limparCarrinhoPorUsuario(Long id){
        repository.deleteByUsuarioId(id);
    }

}