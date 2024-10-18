package com.example.api_produto_ms.service;

import com.example.api_produto_ms.dto.ProdutoDto;
import com.example.api_produto_ms.model.Produto;
import com.example.api_produto_ms.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoDto save(ProdutoDto produtoDto) {
        Produto produto = Produto.fromDto(produtoDto);
        return new ProdutoDto(produtoRepository.save(produto));
    }

    public ProdutoDto findById(Long id) {
        Produto produto = produtoRepository.getReferenceById(id);
        return new ProdutoDto(produto);
    }

    public ProdutoDto update(Long id, ProdutoDto produtoDto) {
        Produto produto = Produto.fromDto(produtoDto);
        produto.setId(id);
        return new ProdutoDto(produtoRepository.save(produto));
    }
}
