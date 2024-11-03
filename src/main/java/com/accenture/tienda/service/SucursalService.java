package com.accenture.tienda.service;

import org.springframework.stereotype.Service;

import com.accenture.tienda.entity.Sucursal;
import com.accenture.tienda.repository.SucursalRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class SucursalService {

    private final SucursalRepository sucursalRepository;

    public Mono<Sucursal> actualizarNombreSucursal(Long sucursalId, String nuevoNombre) {
        return sucursalRepository.findById(sucursalId)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Sucursal no encontrada")))
                .flatMap(sucursal -> {
                    sucursal.setNombre(nuevoNombre);
                    return sucursalRepository.save(sucursal);
                });
    }
}
