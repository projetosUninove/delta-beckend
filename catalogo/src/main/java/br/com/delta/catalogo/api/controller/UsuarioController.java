package br.com.delta.catalogo.api.controller;

import br.com.delta.catalogo.domain.dto.CriarUsuarioDto;
import br.com.delta.catalogo.domain.dto.UsuarioRespostaDto;
import br.com.delta.catalogo.domain.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/{id}")
    public ResponseEntity buscarUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarUsuarioPorId(id));
    }

    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid CriarUsuarioDto usuario, UriComponentsBuilder uriBuilder) {
        UsuarioRespostaDto usuarioResposta = service.cadastrarUsuario(usuario);
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuarioResposta.id()).toUri();
        return ResponseEntity.created(uri).body(usuarioResposta);
    }
}