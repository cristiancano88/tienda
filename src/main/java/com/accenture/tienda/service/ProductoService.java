package com.accenture.tienda.service;

import org.springframework.stereotype.Service;

import com.accenture.tienda.entity.Producto;
import com.accenture.tienda.repository.ProductoRepository;
import com.accenture.tienda.repository.SucursalRepository;

import lombok.RequiredArgsConstructor;
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

}
