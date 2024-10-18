package com.example.api_pedido_ms.feignClient;

import com.example.api_pedido_ms.dto.AtualizaQuantidadeDto;
import com.example.api_pedido_ms.dto.ProdutoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "produto-ms", url = "http://localhost:8081")
public interface ProdutoClient {
    @GetMapping("/produtos/{id}")
    ProdutoDto getProdutoById(@PathVariable("id") Long id);

    @PutMapping("/produtos/{id}/atualizar-quantidade")
    void atualizarQuantidade(@PathVariable("id") Long id, @RequestBody AtualizaQuantidadeDto atualizaQuantidadeDTO);
}
