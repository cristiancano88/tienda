package com.accenture.tienda.service;

import org.springframework.stereotype.Service;

import com.accenture.tienda.dto.ProductoConSucursal;
import com.accenture.tienda.entity.Producto;
import com.accenture.tienda.repository.ProductoRepository;
import com.accenture.tienda.repository.SucursalRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final SucursalRepository sucursalRepository;

    public Mono<Producto> agregarProducto(Long sucursalId, Producto producto) {
        return sucursalRepository.findById(sucursalId)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Sucursal no encontrada")))
                .flatMap(sucursal -> {
                    producto.setSucursalId(sucursalId);
                    return productoRepository.save(producto);
                });
    }

    public Mono<Void> eliminarProducto(Long productoId) {
        return productoRepository.findById(productoId)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Producto no encontrado")))
                .flatMap(productoRepository::delete);
    }

    public Mono<Producto> actualizarStock(Long productoId, int nuevoStock) {
        return productoRepository.findById(productoId)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Producto no encontrado")))
                .flatMap(producto -> {
                    producto.setCantidadStock(nuevoStock);
                    return productoRepository.save(producto);
                });
    }

    public Flux<ProductoConSucursal> obtenerProductoConMayorStockPorSucursalParaFranquicia(Long franquiciaId) {
        return sucursalRepository.findByFranquiciaId(franquiciaId)
                .flatMap(sucursal
                        -> productoRepository.findBySucursalId(sucursal.getId())
                        .sort((p1, p2) -> p2.getCantidadStock() - p1.getCantidadStock())
                        .next()
                        .map(producto -> new ProductoConSucursal(sucursal.getNombre(), producto))
                );
    }

}
