package com.example.api_pedido_ms.controller;

import com.example.api_pedido_ms.dto.PedidoDto;
import com.example.api_pedido_ms.service.PedidoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/pedidos",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<Page<PedidoDto>> findAll(@PageableDefault(size= 10) Pageable pagination){
        return ResponseEntity.ok(pedidoService.findAll(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(pedidoService.findById(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Page<PedidoDto>> findByUserId(@PathVariable Long id, @PageableDefault(size = 5) Pageable pagination){
        return ResponseEntity.ok(pedidoService.findByProdutoId(id, pagination));
    }

    @PostMapping
    public ResponseEntity<PedidoDto> save(@RequestBody @Valid PedidoDto pedidoDto){
        return ResponseEntity.status(201).body(pedidoService.save(pedidoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> update(@PathVariable Long id, @RequestBody @Valid PedidoDto pedidoDto){
        return ResponseEntity.ok(pedidoService.update(id, pedidoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/updateStatus")
    public ResponseEntity<PedidoDto> updateStatus(@PathVariable Long id,
                                                 @RequestBody Map<String, String> body){

        String status = body.get("status");
        return ResponseEntity.ok(pedidoService.updateStatus(id, status));
    }
}
