package com.example.api_produto_ms.controller;

import com.example.api_produto_ms.dto.ProdutoDto;
import com.example.api_produto_ms.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/produtos",
consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> registrar(@RequestBody @Valid ProdutoDto produtoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> update(@PathVariable Long id, @RequestBody @Valid ProdutoDto produtoDto){
        return ResponseEntity.ok(produtoService.update(id, produtoDto));
    }
}
