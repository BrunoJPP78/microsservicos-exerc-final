package com.example.api_pedido_ms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_pedido_ms.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    Page<Pedido> findByProdutoId(Long userId, Pageable pagination);
}
