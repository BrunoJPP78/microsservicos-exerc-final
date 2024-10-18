package com.example.api_pedido_ms.model;

import com.example.api_pedido_ms.dto.ProdutoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Integer quantidade;
    private Float preco;

    public static Produto fromDto(ProdutoDto produtoDto){
        return new Produto(null, produtoDto.nome(), produtoDto.descricao(),
                produtoDto.quantidade(), produtoDto.preco());
    }
}
