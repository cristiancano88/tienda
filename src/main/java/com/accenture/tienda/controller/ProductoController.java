package com.accenture.tienda.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.tienda.entity.Producto;
import com.accenture.tienda.service.ProductoService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sucursales")
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping("/{sucursalId}/productos")
    public Mono<Producto> agregarProducto(@PathVariable Long sucursalId, @RequestBody Producto producto) {
        return productoService.agregarProducto(sucursalId, producto);
    }

    @DeleteMapping("/{productoId}")
    public Mono<Void> eliminarProducto(@PathVariable Long productoId) {
        return productoService.eliminarProducto(productoId);
    }

    @PutMapping("/{productoId}/stock")
    public Mono<Producto> actualizarStock(@PathVariable Long productoId, @RequestParam int nuevoStock) {
        return productoService.actualizarStock(productoId, nuevoStock);
    }

}
