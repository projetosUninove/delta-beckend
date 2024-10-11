package br.com.delta.catalogo.infra.exception;

import br.com.delta.catalogo.domain.exception.CarrinhoNaoEncontradoException;
import br.com.delta.catalogo.domain.exception.ProdutoNaoEncontradoException;
import br.com.delta.catalogo.domain.exception.ProdutoQuantidadeInsuficienteException;
import br.com.delta.catalogo.domain.exception.UsuarioNaoEncontradoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleError400(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(validationDataError::new).toList());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity handleProdutoNaoEncontradoException(ProdutoNaoEncontradoException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(CarrinhoNaoEncontradoException.class)
    public ResponseEntity handleCarrinhoNaoEncontradoException(CarrinhoNaoEncontradoException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(ProdutoQuantidadeInsuficienteException.class)
    public ResponseEntity handleProdutoQuantidadeInsuficienteException(ProdutoQuantidadeInsuficienteException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }


    private record validationDataError(String field, String message) {
        public validationDataError(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
