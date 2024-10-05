package br.com.delta.catalogo.api.controller;

import br.com.delta.catalogo.domain.dto.CarrinhoDto;
import br.com.delta.catalogo.domain.model.Carrinho;
import br.com.delta.catalogo.domain.service.CarrinhoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoService service;

    @Autowired
    public CarrinhoController(CarrinhoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Carrinho>> bucarPorUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorIdUsuario(id));
    }

    @PostMapping
    public ResponseEntity<Carrinho> cadastrar(@RequestBody @Valid CarrinhoDto dto, UriComponentsBuilder uriBuilder) {
        Carrinho resposta = service.adicionar(dto);
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrinho> atualizar(@PathVariable Long id, @RequestBody @Valid CarrinhoDto dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}