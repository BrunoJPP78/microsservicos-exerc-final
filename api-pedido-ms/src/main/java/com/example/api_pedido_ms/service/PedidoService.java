package com.example.api_pedido_ms.service;

import com.example.api_pedido_ms.dto.AtualizaQuantidadeDto;
import com.example.api_pedido_ms.dto.PedidoDto;
import com.example.api_pedido_ms.dto.ProdutoDto;
import com.example.api_pedido_ms.enums.PedidoStatus;
import com.example.api_pedido_ms.feignClient.ProdutoClient;
import com.example.api_pedido_ms.model.Pedido;
import com.example.api_pedido_ms.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoClient produtoClient;

    public Page<PedidoDto> findAll(Pageable pagination){
        return pedidoRepository.findAll(pagination).map(l -> new PedidoDto(l));
    }

    public PedidoDto findById(Long id) {
        return new PedidoDto(pedidoRepository.getReferenceById(id));
    }

    public Page<PedidoDto> findByProdutoId(Long id, Pageable pagination){
        return pedidoRepository.findByProdutoId(id, pagination).map(pedido -> new PedidoDto(pedido));
    }

    @Transactional
    public PedidoDto save(PedidoDto pedidoDto) {
        ProdutoDto produto = produtoClient.getProdutoById(pedidoDto.produtoId());
        if (produto.quantidade() > 0) {
            // Atualiza
            AtualizaQuantidadeDto atualizaQuantidadeDTO = new AtualizaQuantidadeDto();
            atualizaQuantidadeDTO.setQuantidade(produto.quantidade() - 1); // Exemplo, diminui em 1
            produtoClient.atualizarQuantidade(pedidoDto.produtoId(), atualizaQuantidadeDTO);

            // Cria
            Pedido pedido = Pedido.fromDto(pedidoDto);
            pedido.setPedidoStatus(PedidoStatus.CRIADO);
            return new PedidoDto(pedidoRepository.save(pedido));
        } else {
            throw new RuntimeException("Produto não disponível");
        }
    }

    @Transactional
    public PedidoDto update(Long id, PedidoDto pedidoDto) {
        Pedido pedido = Pedido.fromDto(pedidoDto);
        pedido.setId(id);
        return new PedidoDto(pedidoRepository.save(pedido));
    }

    @Transactional
    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Transactional
    public PedidoDto updateStatus(Long id, String status) {
        Pedido pedido = pedidoRepository.getReferenceById(id);
        pedido.setPedidoStatus(PedidoStatus.valueOf(status));
        return new PedidoDto(pedido);
    }

}
