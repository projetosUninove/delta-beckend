package br.com.delta.catalogo.api.controller;

import br.com.delta.catalogo.domain.model.Produto;
import br.com.delta.catalogo.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;

    @Autowired
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    //    TODO -> Busca paginada
    @GetMapping
    public ResponseEntity<List<Produto>> buscarProduto(){
        return ResponseEntity.ok(service.buscarProduto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarProdutoPorId(id));
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto, UriComponentsBuilder uriBuilder) {
        Produto resposta = service.cadastrar(produto);
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        return ResponseEntity.ok(service.atualizar(id, produto));
    }
}