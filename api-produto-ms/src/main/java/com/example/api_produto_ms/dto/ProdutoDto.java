package com.example.api_produto_ms.dto;

import com.example.api_produto_ms.model.Produto;
import jakarta.validation.constraints.NotBlank;

public record ProdutoDto(
    Long id,
    @NotBlank String nome,
    @NotBlank String descricao,
    Integer quantidade,
    Float preco){

    public ProdutoDto(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getDescricao(),
                produto.getQuantidade(), produto.getPreco());
    }
}
