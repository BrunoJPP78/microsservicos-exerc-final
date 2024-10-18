package com.example.api_pedido_ms.dto;

import com.example.api_pedido_ms.enums.PedidoStatus;
import com.example.api_pedido_ms.model.Pedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PedidoDto (
    Long id,
    @NotBlank String endereco,
    LocalDate dataPedido,
    PedidoStatus pedidoStatus,
    @NotNull Long produtoId){

    public PedidoDto(Pedido pedido) {
        this(pedido.getId(), pedido.getEndereco(), pedido.getDataPedido(),
                pedido.getPedidoStatus(), pedido.getProdutoId());
    }
}

