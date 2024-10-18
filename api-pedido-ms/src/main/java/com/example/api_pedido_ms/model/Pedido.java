package com.example.api_pedido_ms.model;

import com.example.api_pedido_ms.dto.PedidoDto;
import com.example.api_pedido_ms.enums.PedidoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String endereco;
    private LocalDate dataPedido;
    PedidoStatus pedidoStatus;

    private Long produtoId;

    public static Pedido fromDto(PedidoDto pedidoDto) {
        return new Pedido(null, pedidoDto.endereco(), pedidoDto.dataPedido(), pedidoDto.pedidoStatus(), pedidoDto.produtoId());
    }

}
